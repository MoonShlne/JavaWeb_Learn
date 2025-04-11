<script setup>

import {reactive, ref} from "vue";

let person = reactive({
  name: "",
  age: null,
  intr: "",
  position: ""
})
let hobbies = ref([]);

function clearAll() {
  person.name = "",
      person.age = null,
      person.intr = "",
      person.position = ""

      hobbies.value.splice(0,hobbies.value.length)
}
</script>

<template>

  name: <input type="text" v-model="person.name">
  <br>
  age: &nbsp &nbsp<input type="text" v-model="person.age">
  <br>
  简介 <textarea v-model="person.intr"></textarea>
  <br>
  唱<input type="checkbox" v-model="hobbies" value="sing">
  跳<input type="checkbox" v-model="hobbies" value="dance">
  rap<input type="checkbox" v-model="hobbies" value="rapper">
  <br>
  籍贯 <select v-model="person.position">
  <option>京</option>
  <option>纽约</option>
  <option>爱丁堡</option>

</select>

  <button @click="clearAll()">清空</button>

  <hr>
  {{ person }} <br> {{ hobbies }}
</template>

<style scoped>

</style>


