import { slottedBoxes } from '../../repositories/slottedBox'

const laneSlots = [
  {label:'A', slotted: 0, index: 1},
  {label:'B', slotted: 0, index: 2},
  {label:'C', slotted: 0, index: 3},
  {label:'D', slotted: 0, index: 4},
  {label:'E', slotted: 0, index: 5},
  {label:'F', slotted: 0, index: 6},
  {label:'G', slotted: 0, index: 7},
  {label:'H', slotted: 0, index: 8},
  {label:'I', slotted: 0, index: 9},
  {label:'J', slotted: 0, index: 10},
  {label:'K', slotted: 0, index: 11},
  {label:'L', slotted: 0, index: 12}
]

const fillSlots = () => {
  if(slottedBoxes){
    console.log(slottedBoxes)
  }
}

fillSlots()

const moveBox = (row, step) => {

}

export { laneSlots, moveBox }
