<script setup>
import {ref,reactive,toRef,toRefs} from "vue";

// let count =ref(1);

let person =reactive({
  name :"haha",
  age :11
})
/*let person ={
  name :"haha",
  age :11
}*/
let pAge= toRef(person,'age')
/*function increase(){
  count.value++;
}*/

function ageAdd(){
  pAge.value++;
}

</script>

<template>
<!--<button @click="increase()">+</button>
<button v-on:click="count++">+</button>
{{count}}

  <hr>
  <button @click="person.age++">+</button>
  <button @click="ageAdd()">+</button>
  {{person.age}}-->

  <hr>
  <button @click="pAge++">+</button>
  <button @click="ageAdd()">+</button>
  {{person.age}}
  {{pAge}}
</template>

<style scoped>

</style>


