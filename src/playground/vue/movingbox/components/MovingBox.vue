<template>
  <div class="movingBoxContainer">
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
    import {laneSlots, fillSlots} from '../compositionapis/domains/lane/movingbox'

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
                        title: 'Prod Name',
                        key: "name",
                        width: 200,
                        ellipsis: true
                    },

                    {
                        title: 'Prod Type',
                        key: "type",
                        width: 100,
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
                    name: l.actionSlot?`DM-8U-TEST-${l.slotted}`:'',
                    type: l.actionSlot?'DM':'',
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

          if(step > 0){// move down
              let afterFirstSlotted = lanes.data.find(l => l.slotIndex == (firstSlotted.slotIndex + 1))
              let afterLastSlotted = lanes.data.find(l => l.slotIndex == (lastSlotted.slotIndex + 1))

              afterLastSlotted.slotted = currentSlotted.slotted
              afterFirstSlotted.actionSlot = currentSlotted.actionSlot
              afterFirstSlotted.name = currentSlotted.name
              afterFirstSlotted.type = currentSlotted.type
              currentSlotted.slotted = 0
          }
          else if(step < 0){// move up
              let beforeFirstSlotted = lanes.data.find(l => l.slotIndex == (firstSlotted.slotIndex - 1))
              //let afterLastSlotted = lanes.data.find(l => l.slotIndex == (lastSlotted.slotIndex + 1))

              lastSlotted.slotted = 0
              beforeFirstSlotted.slotted = currentSlotted.slotted
              beforeFirstSlotted.actionSlot = currentSlotted.actionSlot
              beforeFirstSlotted.name = currentSlotted.name
              beforeFirstSlotted.type = currentSlotted.type
          }

          currentSlotted.name = ''
          currentSlotted.type = ''
          currentSlotted.actionSlot = false
        }

        const checkIfMoveDownToTop = row => {
          let currentLaneIndex = row.slotIndex
          let currentSlotted = lanes.data.find(l => l.slotIndex == currentLaneIndex)
          let relatedSlotted = lanes.data.filter(l => l.slotted == currentSlotted.slotted)
          let firstSlotted = relatedSlotted[0]
          return firstSlotted.slotIndex == 1
        }

        const checkIfMoveDownToButtom = row => {
          let currentLaneIndex = row.slotIndex
          let currentSlotted = lanes.data.find(l => l.slotIndex == currentLaneIndex)
          let relatedSlotted = lanes.data.filter(l => l.slotted == currentSlotted.slotted)
          let lastSlotted = relatedSlotted[relatedSlotted.length - 1]
          return lastSlotted.slotIndex == 12
        }

        const rowClassName = (row, index) => {
                if (row.slotted && row.actionSlot)
                    return 'slottedActionRow';
                else if (row.slotted)
                    return 'slottedRow'
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
