<template>
  <div style="display:flex;flex-direction:column;padding: 120px;">
    <MovingBox id="singleBox001" :slotted-boxes="slottedBoxes001" />
  </div>
</template>

<script>
export default {
  data(){
    return {
      slottedBoxes001:[
        {id: 86, startIndex: 3, endIndex: 4},
        {id: 31, startIndex: 1, endIndex: 2},
        {id: 126, startIndex: 7, endIndex: 10},
      ]
    }

  }
}
</script>
