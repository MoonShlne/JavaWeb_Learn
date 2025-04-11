<script setup>
import {ref} from "vue";

let warn = () => {
  alert("呗点击了")
}
let count = ref(1);

function countPlus() {
  count.value++;
}
function checkout (event){
  var flag= confirm("are you sure?")
  if (!flag){
    event.preventDefault();
  }
}

</script>

<template>
  <button v-on:click="warn()"></button>
  <button v-on:click="alert('呗点击了')"></button>

  <button @click.once="countPlus"></button>
  <button @click.once="count++;"></button>
  {{ count }}


  <a href="https://www.google.com" @click="checkout($event)">咕噜咕噜</a>

</template>

<style scoped>

</style>


