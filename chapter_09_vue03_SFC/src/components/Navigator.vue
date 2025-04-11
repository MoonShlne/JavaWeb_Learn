<script setup>
let info = ["考试管理", "图书系统","信息门户","教务系统","更多资源"]

let emits = defineEmits(["sendMenu"]);
function send(data){
  emits("sendMenu",data)
}
</script>

<template>
  <div><ul>
    <li v-for="(infos,index) in info"  @click="send(infos) " >{{infos}}</li>
  </ul></div>
</template>

<style scoped>

</style>
