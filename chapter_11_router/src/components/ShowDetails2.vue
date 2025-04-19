<script setup>
import {useRoute} from "vue-router";
import {onUpdated, ref, watch} from "vue";

const route = useRoute();
let id = ref(0);
let age = ref(0);

id = route.query.id;
age = route.query.age;

watch(() => {
  id = route.query.id;
  age = route.query.age;
})
</script>
<template>
  <h1>接收键值对参数</h1>
  <h3>{{ `id为${id} 的用户年龄为${age}` }}</h3>

</template>

<style scoped>

</style>