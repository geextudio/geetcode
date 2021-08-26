<template>
  <div style="display:flex;flex-direction:column;">
    <span class="caseTitle" style="width: 100%; margin-left: 30%;margin-top: 15px; margin-bottom: 15px;">Up/Down Demo Prototype of Modules in Lane</span>
    <div class="playground">

      <div class="boxCase">
        <span class='caseTitle'>1 Module</span>
        <MovingBox id="singleBox001" :slotted-boxes="slottedBoxes001" />
      </div>
      <div class="boxCase">
        <span class='caseTitle'>2 Modules</span>
        <MovingBox id="singleBox002" :slotted-boxes="slottedBoxes002" />
      </div>

      <div class="boxCase">
        <span class='caseTitle'>Full Modules</span>
        <MovingBox id="singleBox003" :slotted-boxes="slottedBoxes003" />
      </div>

      <div class="boxCase">
        <span class='caseTitle'>No Modules</span>
        <MovingBox id="singleBox004" :slotted-boxes="slottedBoxes004" />
      </div>

    </div>
  </div>
</template>

<script>
export default {
  data(){
    return {
      slottedBoxes001:[
        {id: 86, startIndex: 3, endIndex: 4}
      ],
      slottedBoxes002:[
        {id: 16, startIndex: 3, endIndex: 4},
        {id: 126, startIndex: 7, endIndex: 10}
      ],
      slottedBoxes003:[
        {id: 36, startIndex: 3, endIndex: 5},
        {id: 26, startIndex: 1, endIndex: 2},
        {id: 48, startIndex: 6, endIndex: 7},
        {id: 77, startIndex: 11, endIndex: 12},
        {id: 2126, startIndex: 8, endIndex: 10}
      ],
      slottedBoxes004: []
    }

  }
}
</script>

<style scoped>
  .playground{
    user-select: none;
    display:grid;
    grid-template-columns: repeat(2, 870px);

    /*  声明行间距和列间距  */
    /* grid-gap: 20px; */
    column-gap: 10px;
    /* row-gap: 60px; */
    row-gap: 10px;


    /*  声明行的高度  */
    /* grid-template-rows: 512px 512px; */
    grid-template-rows: auto;

    padding: 30px;
    width: 100%;
  }

  .caseTitle{
    user-select: none;
    font-size: 24px;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  }

  .boxCase{
    display:flex;
    flex-direction:column;
    border:1px solid black;
    border-radius: 5px;
    padding: 5px;
    height: 567px;
    /* cursor:pointer; */
  }
</style>
