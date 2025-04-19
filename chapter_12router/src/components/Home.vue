<script setup>
import {useRouter} from "vue-router";

const router =useRouter();
let name = sessionStorage.getItem("userName");

function quit(){
  router.push("/login")
  sessionStorage.removeItem("userName")
}
</script>


<template>
<h1>welcome</h1>
  <h3>欢迎回来，{{name}}</h3>

  <button @click="quit()">退出登录</button>
</template>

<style scoped>

</style>
