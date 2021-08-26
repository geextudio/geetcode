//import { slottedBoxes } from '../../repositories/slottedBox'

const laneSlots = [
  {label:'A', slotted: 0, index: 1, actionSlot: false},
  {label:'B', slotted: 0, index: 2, actionSlot: false},
  {label:'C', slotted: 0, index: 3, actionSlot: false},
  {label:'D', slotted: 0, index: 4, actionSlot: false},
  {label:'E', slotted: 0, index: 5, actionSlot: false},
  {label:'F', slotted: 0, index: 6, actionSlot: false},
  {label:'G', slotted: 0, index: 7, actionSlot: false},
  {label:'H', slotted: 0, index: 8, actionSlot: false},
  {label:'I', slotted: 0, index: 9, actionSlot: false},
  {label:'J', slotted: 0, index: 10, actionSlot: false},
  {label:'K', slotted: 0, index: 11, actionSlot: false},
  {label:'L', slotted: 0, index: 12, actionSlot: false}
]

const fillSlots = (slottedBoxes) => {
  if(slottedBoxes){
    slottedBoxes.sort((s1, s2) => s1.startIndex > s2.startIndex ? 1 : -1)


    for(let slottedBox of slottedBoxes){
      let slottedIndex = slottedBox.startIndex
      for(; slottedIndex <= slottedBox.endIndex; slottedIndex++){
        let foundSlot = laneSlots.find(l => l.index == slottedIndex)
        if(foundSlot){
          foundSlot.slotted = slottedBox.id
          foundSlot.actionSlot = (foundSlot.index == slottedBox.startIndex)
        }
      }

    }
    return laneSlots
  }
  return []
}

const moveBox = (row, step) => {

}

export { laneSlots, fillSlots, moveBox }
