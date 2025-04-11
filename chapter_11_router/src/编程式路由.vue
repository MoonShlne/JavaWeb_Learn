<script setup>

import {useRouter} from "vue-router";
import {ref} from "vue";

let Url = ref("");

function showAdd() {
  router.push(Url.value)

}

function GoHome() {
  router.push("home")
}

</script>

<template>


  <router-link to="List">List</router-link>
  <br>
  <router-link to="Add">Add</router-link>
  <br>
  <router-link to="Home">Home</router-link>
  <br>
  <hr>

  <button @click="showAdd()">GoUrl</button>
<!--  <button @click="GoHome()">GoHome</button>-->
  <input type="text" v-model="Url">


  <hr>
  <div>
    <router-view></router-view>
  </div>

</template>

<style scoped>

</style>
