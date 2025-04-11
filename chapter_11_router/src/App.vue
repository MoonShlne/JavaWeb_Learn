<script setup>

import {onUpdated, ref, watch} from "vue";
import {useRoute} from "vue-router";
let Userid= ref("");
let UserName=ref(0);


let route = useRoute();


onUpdated(()=>{
  Userid.value = route.params.id;
  UserName.value= route.params.age;
})

</script>

<template>
    <router-link to="/ShowDetails/1/13">Test</router-link>
   我的id是 {{Userid}}
   我的年龄是{{UserName}}
  <hr>
  <div>
    <router-view></router-view>
  </div>

</template>

<style scoped>

</style>
