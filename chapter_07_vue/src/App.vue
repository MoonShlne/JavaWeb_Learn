<script setup >
import  {ref} from  "vue";


    let count= ref(10);

    //让count增加的方法

    function countIncr(){
      count.value++;
    }
    function  countDecr(){
      count.value --;
    }
</script>


<template>
<button @click="countIncr">+</button>
<span v-text="count"></span>
<button  @click =countIncr>-</button>
</template>

<style scoped>

</style>
