<script setup>
import {ref, watch} from "vue";
import router from "../routers/router.js";

let userName=ref("");
let password= ref("");

function submit(){
  if (userName.value=="root"&&password.value=="123456"){
    sessionStorage.setItem("userName",userName.value);
    router.push("/home")
  }
  else {
    alert("false username&password")
  }
}

</script>

<template>
  账号：<input type="text" v-model="userName"><br>
  密码：<input type="password" v-model="password"><br>
  <button @click="submit()">submit</button>



</template>

<style scoped>

</style>
