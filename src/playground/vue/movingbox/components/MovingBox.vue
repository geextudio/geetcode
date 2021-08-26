<template>
  <div class="movingBoxContainer" :id="id">
    <Table :span-method="handleSpan" :row-class-name="rowClassName" :columns="lanes.columns" :data="lanes.data" no-data-text="" size="small">
            <template slot-scope="{ row }" slot="action">
                <div v-if="row.slotted && row.actionSlot" style="display: flex; justify-content:space-around;">

                    <Button title="Up" :disabled="checkIfMoveDownToTop(row)" size="small" icon="md-arrow-round-up" @click="move(row, -1)" > </Button>

                    <Button title="Down" :disabled="checkIfMoveDownToButtom(row)" size="small" icon="md-arrow-round-down"  @click="move(row, 1)"> </Button>

                    <Button title="Clear" size="small" icon="md-trash" > </Button>

                </div>
            </template>
    </Table>
  </div>
</template>

<script>
    import { ref, reactive, onMounted  } from '@vue/composition-api'
    import { fillSlots} from '../compositionapis/domains/lane/movingbox'

    export default {

      props:{
        id: {
          type: String,
          required: true,
          default: "lanes-component-001"
        },

        slottedBoxes:{
          type: Array,
          default: []
        }
      },

      setup(props, context) {

        const lanes = reactive(
          {
            columns: [
              {
                        title: " ",
                        slot: "action",
                        width: 120,
                        align: "left",
                    },

                    {
                        title: 'Lane',
                        key: "label",
                        width: 72
                    },

                    {
                        title: 'Product Type',
                        key: "type",
                        width: 120,
                        ellipsis: true
                    },

                    {
                        title: 'Product Name',
                        key: "name",
                        width: 200,
                        ellipsis: true
                    },

                    {
                        title: 'MID',
                        key: "mid",
                        width: 100,
                        ellipsis: true
                    },

                    {
                        title: 'Rear Ports',
                        key: "rearPort",
                        width: 120,
                        ellipsis: true
                    },

                    {
                        title: 'Front Ports',
                        key: "frontPort",
                        width: 120,
                        ellipsis: true
                    },

            ],
            data: []
          }
        )

        const getEnv = async () => {
            lanes.data = fillSlots(props.slottedBoxes).map(l => {
                return {
                    label: l.label,
                    name: l.actionSlot?`DM-12U-24LC-(Demo)${l.slotted}`:'',
                    type: l.actionSlot?'DM (Demo)':'',
                    mid: l.actionSlot?'DM (Demo)':'',
                    rearPort: l.actionSlot?'2 x MPO12':'',
                    frontPort: l.actionSlot?'12 x LC Duplex':'',
                    slotted: l.slotted,
                    actionSlot: l.actionSlot,
                    slotIndex: l.slotIndex
                }
            })
        }
        onMounted(getEnv)

        const move = (row, step) => {

          let currentLaneIndex = row.slotIndex
          let currentSlotted = lanes.data.find(l => l.slotIndex == currentLaneIndex)
          let relatedSlotted = lanes.data.filter(l => l.slotted == currentSlotted.slotted)
          let firstSlotted = relatedSlotted[0]
          let lastSlotted = relatedSlotted[relatedSlotted.length - 1]
          let needSwap = false

          if(step > 0){// move down
              let afterFirstSlotted = lanes.data.find(l => l.slotIndex == (firstSlotted.slotIndex + 1))
              let afterLastSlotted = lanes.data.find(l => l.slotIndex == (lastSlotted.slotIndex + 1))

              if(afterLastSlotted.slotted == 0){
                afterLastSlotted.slotted = currentSlotted.slotted
                afterFirstSlotted.actionSlot = currentSlotted.actionSlot
                afterFirstSlotted.name = currentSlotted.name
                afterFirstSlotted.type = currentSlotted.type
                afterFirstSlotted.mid = currentSlotted.mid
                afterFirstSlotted.rearPort = currentSlotted.rearPort
                afterFirstSlotted.frontPort = currentSlotted.frontPort
                currentSlotted.slotted = 0
              }
              else{
                needSwap = true
                const swapSlottedDown = lanes.data.filter(l => l.slotted == afterLastSlotted.slotted)
                const newMergeSlotsDown = swapSlottedDown.map(s => {
                  return {
                    slotted: s.slotted,
                    actionSlot: s.actionSlot,
                    name: s.name,
                    type: s.type,
                    mid: s.mid,
                    rearPort:s.rearPort,
                    frontPort: s.frontPort
                  }
                }).concat(relatedSlotted.map(r => {
                  return {
                    slotted: r.slotted,
                    actionSlot: r.actionSlot,
                    name: r.name,
                    type: r.type,
                    mid: r.mid,
                    rearPort: r.rearPort,
                    frontPort: r.frontPort
                  }
                }))

                let flagDown = 0
                for(let indexDown = relatedSlotted[0].slotIndex - 1; indexDown < swapSlottedDown[swapSlottedDown.length - 1].slotIndex; indexDown++){
                  lanes.data[indexDown].actionSlot = newMergeSlotsDown[flagDown].actionSlot
                  lanes.data[indexDown].name = newMergeSlotsDown[flagDown].name
                  lanes.data[indexDown].type = newMergeSlotsDown[flagDown].type
                  lanes.data[indexDown].slotted = newMergeSlotsDown[flagDown].slotted
                  lanes.data[indexDown].mid = newMergeSlotsDown[flagDown].mid
                  lanes.data[indexDown].rearPort = newMergeSlotsDown[flagDown].rearPort
                  lanes.data[indexDown].frontPort = newMergeSlotsDown[flagDown].frontPort
                  flagDown++
                }
              }
          }
          else if(step < 0){// move up
              let beforeFirstSlotted = lanes.data.find(l => l.slotIndex == (firstSlotted.slotIndex - 1))
              if(beforeFirstSlotted.slotted == 0){
                lastSlotted.slotted = 0
                beforeFirstSlotted.slotted = currentSlotted.slotted
                beforeFirstSlotted.actionSlot = currentSlotted.actionSlot
                beforeFirstSlotted.name = currentSlotted.name
                beforeFirstSlotted.type = currentSlotted.type
                beforeFirstSlotted.mid = currentSlotted.mid
                beforeFirstSlotted.rearPort = currentSlotted.rearPort
                beforeFirstSlotted.frontPort = currentSlotted.frontPort
              }
              else{
                needSwap = true
                const swapSlottedUp = lanes.data.filter(l => l.slotted == beforeFirstSlotted.slotted )
                const newMergeSlotsUp = relatedSlotted.map(s => {
                  return {
                    slotted: s.slotted,
                    actionSlot: s.actionSlot,
                    name: s.name,
                    type: s.type,
                    mid: s.mid,
                    rearPort:s.rearPort,
                    frontPort: s.frontPort
                  }
                }).concat(swapSlottedUp.map(r => {
                  return {
                    slotted: r.slotted,
                    actionSlot: r.actionSlot,
                    name: r.name,
                    type: r.type,
                    mid: r.mid,
                    rearPort: r.rearPort,
                    frontPort: r.frontPort
                  }
                }))

                let flagUp = 0
                for(let indexUp = swapSlottedUp[0].slotIndex - 1; indexUp < relatedSlotted[relatedSlotted.length - 1].slotIndex; indexUp++){
                  lanes.data[indexUp].actionSlot = newMergeSlotsUp[flagUp].actionSlot
                  lanes.data[indexUp].name = newMergeSlotsUp[flagUp].name
                  lanes.data[indexUp].type = newMergeSlotsUp[flagUp].type
                  lanes.data[indexUp].slotted = newMergeSlotsUp[flagUp].slotted
                  lanes.data[indexUp].mid = newMergeSlotsUp[flagUp].mid
                  lanes.data[indexUp].rearPort = newMergeSlotsUp[flagUp].rearPort
                  lanes.data[indexUp].frontPort = newMergeSlotsUp[flagUp].frontPort
                  flagUp++
                }

              }
          }
          if(!needSwap){
            currentSlotted.name = ''
            currentSlotted.type = ''
            currentSlotted.mid = ''
            currentSlotted.rearPort = ''
            currentSlotted.frontPort = ''
            currentSlotted.actionSlot = false
          }
        }

        const checkIfMoveDownToTop = row => {
          const relatedSlotted = lanes.data.filter(l => l.slotted == row.slotted)
          let firstSlotted = relatedSlotted[0]
          return firstSlotted.slotIndex == 1
        }

        const checkIfMoveDownToButtom = row => {
          const relatedSlotted = lanes.data.filter(l => l.slotted == row.slotted)
          let lastSlotted = relatedSlotted[relatedSlotted.length - 1]
          return lastSlotted.slotIndex == 12
        }

        const rowClassName = (row, index) => {
                if (row.slotted && row.actionSlot)
                    return 'slottedActionRow';
                else if (row.slotted){
                    const relatedSlotted = lanes.data.filter(l => l.slotted == row.slotted)
                    const lastSlotted = relatedSlotted[relatedSlotted.length - 1]
                    if(row.slotIndex == lastSlotted.slotIndex)
                      return 'slottedLastRow'
                    return 'slottedRow'
                }
                return 'emptydRow';
        }

        const handleSpan = ({ row, column, rowIndex, columnIndex }) => {

        }

        return {
          lanes,

          rowClassName,
          handleSpan,
          move,
          checkIfMoveDownToTop,
          checkIfMoveDownToButtom
        }
      }

    }
</script>

<style scoped>
  .movingBoxContainer{
    user-select: none;
    display:flex;
    flex-direction: column;
    justify-content: flex-start;
  }

  /deep/ .ivu-table .slottedActionRow td{
      background-color: #ebf7ff;
      color: black;

      border: 0.5px #7F7F7F;
      border-top-style: solid;

  }

  /deep/ .ivu-table .slottedLastRow td{
      background-color: #ebf7ff;
      color: lightgray;
      border: 0.5px #7F7F7F;
      border-bottom-style: solid;
  }

  /deep/ .ivu-table .slottedRow td{
      background-color: #ebf7ff;
      color: lightgray;

  }

  /deep/ .ivu-table .emptydRow td{

      color: black;
  }

  /deep/ tr.ivu-table-row-hover td {
    user-select: none;
    background-color: #fff;
  }

</style>
