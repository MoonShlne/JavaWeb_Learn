<script setup>
import {ref} from "vue";

let flag = ref(false);


</script>

<template>
  <h1 v-if="flag">vue 666</h1>
  <h1 v-else>god dam</h1>
  <h1 v-show="flag">我依然在dom树里面</h1>
  <button @click="flag=!flag">show</button>



</template>

<style scoped>

</style>


