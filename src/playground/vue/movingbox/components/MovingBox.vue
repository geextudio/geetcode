<template>
  <div class="movingBoxContainer">
    <Table :span-method="handleSpan" :row-class-name="rowClassName" :columns="lanes.columns" :data="lanes.data" no-data-text="" size="small">
            <template slot-scope="{ row }" slot="action">
                <div v-if="row.slotted > 0 " style="display: flex; justify-content:space-around;">

                    <Button title="Up" size="small" icon="md-arrow-round-up" @click="moveBox(row, -1)" > </Button>

                    <Button title="Down" size="small" icon="md-arrow-round-down"  @click="moveBox(row, 1)"> </Button>

                    <Button title="Clear" size="small" icon="md-trash" > </Button>

                </div>
            </template>
    </Table>
  </div>
</template>

<script>
    import { ref, reactive  } from '@vue/composition-api'
    import {laneSlots, moveBox} from '../compositionapis/domains/lane/movingbox'

    export default {
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
                        title: 'Name',
                        key: "name",
                        width: 256,
                        ellipsis: true
                    },
            ],

            data:laneSlots.map(l => {
                return {
                    label: l.label,
                    name: '',
                    slotted: l.slotted,
                    disabled: false // true when slotted and not the first lane
                }
            })
          }
        )

        const rowClassName = (row, index) => {
                if (row.slotted)
                    return 'slottedRow';
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

  /deep/ .ivu-table .slottedRow td{
      background-color: #2db7f5;
      color: #fff;
  }

  /deep/ .ivu-table .emptydRow td{

      color: lightgray;
  }

</style>
