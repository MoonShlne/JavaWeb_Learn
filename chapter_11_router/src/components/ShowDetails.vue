<script setup>
import {useRoute} from "vue-router";
import {onUpdated, ref, watch} from "vue";

const route = useRoute();
let id = ref(0);
let age = ref(0);

id = route.params.id;
age = route.params.age;

watch(() => {
  id = route.params.id;
  age = route.params.age;
})
</script>
<template>
  <h1>传参测试</h1>
  <h3>{{ `id为${id} 的用户年龄为${age}` }}</h3>

</template>

<style scoped>

</style>