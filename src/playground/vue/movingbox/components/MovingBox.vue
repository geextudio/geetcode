<template>
  <div class="movingBoxContainer">
    <Table :span-method="handleSpan" :row-class-name="rowClassName" :columns="lanes.columns" :data="lanes.data" no-data-text="" size="small">
            <template slot-scope="{ row }" slot="action">
                <div v-if="row.slotted > 0 && row.actionSlot" style="display: flex; justify-content:space-around;">

                    <Button title="Up" size="small" icon="md-arrow-round-up" @click="moveBox(row, -1)" > </Button>

                    <Button title="Down" size="small" icon="md-arrow-round-down"  @click="moveBox(row, 1)"> </Button>

                    <Button title="Clear" size="small" icon="md-trash" > </Button>

                </div>
            </template>
    </Table>
  </div>
</template>

<script>
    import { ref, reactive, onMounted  } from '@vue/composition-api'
    import {laneSlots, fillSlots, moveBox} from '../compositionapis/domains/lane/movingbox'

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
                        width: 256,
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
                    name: '',
                    slotted: l.slotted,
                    actionSlot: l.actionSlot
                }
            })
         }
         onMounted(getEnv)

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

          moveBox
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
