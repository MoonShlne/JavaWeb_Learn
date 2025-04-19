<script setup>
import axios from "axios";
import {ref} from "vue";
import instance  from './axios.js'


let Message = ref("") ;
function getMessage() {
  let promise = instance({
    method:"get",
    url:"/api/rand.qinghua",
    data:{
    username:"zhangsan"
    }
  })

  promise.then(
      function (response){
        console.log(response);
        console.log(response.data.content);
        Message.value=response.data.content;
      },

  ).catch( function (error){
    console.log(error);
    console.log("找不到");
  })

}



</script>

<template>
  <div>
    <h1 >{{Message}}</h1>
  <button @click="getMessage()">get</button>
  </div>
</template>

<style scoped>

</style>
