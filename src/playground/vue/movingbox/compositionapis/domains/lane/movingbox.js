//import { slottedBoxes } from '../../repositories/slottedBox'

const fillSlots = (slottedBoxes) => {
  const laneSlots = [
    {label:'A', slotted: 0, slotIndex: 1, actionSlot: false},
    {label:'B', slotted: 0, slotIndex: 2, actionSlot: false},
    {label:'C', slotted: 0, slotIndex: 3, actionSlot: false},
    {label:'D', slotted: 0, slotIndex: 4, actionSlot: false},
    {label:'E', slotted: 0, slotIndex: 5, actionSlot: false},
    {label:'F', slotted: 0, slotIndex: 6, actionSlot: false},
    {label:'G', slotted: 0, slotIndex: 7, actionSlot: false},
    {label:'H', slotted: 0, slotIndex: 8, actionSlot: false},
    {label:'I', slotted: 0, slotIndex: 9, actionSlot: false},
    {label:'J', slotted: 0, slotIndex: 10, actionSlot: false},
    {label:'K', slotted: 0, slotIndex: 11, actionSlot: false},
    {label:'L', slotted: 0, slotIndex: 12, actionSlot: false}
  ]

  if(slottedBoxes && slottedBoxes.length > 0){
    slottedBoxes.sort((s1, s2) => s1.startIndex > s2.startIndex ? 1 : -1)
    for(let slottedBox of slottedBoxes){
      let slottedIndex = slottedBox.startIndex
      for(; slottedIndex <= slottedBox.endIndex; slottedIndex++){
        let foundSlot = laneSlots.find(l => l.slotIndex == slottedIndex)
        if(foundSlot){
          foundSlot.slotted = slottedBox.id
          foundSlot.actionSlot = (foundSlot.slotIndex == slottedBox.startIndex)
        }
      }
    }
  }
  return laneSlots
}


export { fillSlots }
