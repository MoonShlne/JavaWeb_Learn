<script setup>


import {definedPerson} from "../store/store.js";

let person = definedPerson();

</script>

<template>



<h1>用于展示</h1>



  <hr>
  <input type="text" v-model="person.username">
  唱<input type="checkbox"  v-model="person.hobbies" value="唱" >
  跳<input type="checkbox"  v-model="person.hobbies" value="跳" >
  rap<input type="checkbox"  v-model="person.hobbies" value="rap" >
  篮球<input type="checkbox"  v-model="person.hobbies" value="🏀" >
  鸡<input type="checkbox"  v-model="person.hobbies" value="鸡" >
  美<input type="checkbox"  v-model="person.hobbies" value="美" >
  <br>
  <button @click="person.doubleAge()">超级加倍！</button>

<!--  恢复默认值-->
  <button @click="person.$reset()">重置！</button>
<!--   一次性该值-->
  <button @click="person.$patch({username:'奥特曼',age:20,hobbies:['吃饭','看电视']})">变身奥特曼！</button>
  <hr>




  {{person}}

</template>

<style scoped>

</style>
