<script setup>

import {useRoute} from "vue-router";
import router from "./routers/router.js";


function  showDetail(id,age){
  router.push(`/showDetails/${id}/${age}`)
}

function  showDetail2(id,age){
  router.push(`/showDetails?id=${id}&age=${age}`)
}



</script>

<template>
    <router-link to="/ShowDetails/1/13">声明式路由传参</router-link>
  <button  @click="showDetail(2,30)">编程式路由传参</button>


  <hr>
  <router-link to="/ShowDetails?id=2&age=53">声明式路由键值对传参</router-link>
  <button  @click="showDetail2(2,30)">编程式路由键值对传参</button>

  <hr>
  <div>
    <router-view></router-view>
  </div>

</template>

<style scoped>

</style>
