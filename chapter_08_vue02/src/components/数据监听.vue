<script setup>

import {reactive, ref, watch, watchEffect} from "vue";

let fullName = ref("");
let firstName = ref("为你");
let lastName = reactive({name:"千千万万遍"});

watch(firstName,(newValue,oldValue)=>{
  fullName.value =firstName.value +lastName.name;
})
watch(lastName, ()=>{
  fullName.value =firstName.value +lastName.name;
},{immediate:true})


watchEffect(()=>{

})
</script>

<template>
  姓氏 <input type="text" v-model="firstName">
  <br>
  名字 <input type="text" v-model="lastName.name">
  <hr>
  全名 {{ fullName }}
</template>

<style scoped>

</style>


