<script setup>
let  imgUrl ="https://www.atguigu.com/images/index_new/logo.png"
let color = { color: 'red' }
</script>

<template>
<img v-bind:src="imgUrl">
<h1 :style="color">haah</h1>
</template>

<style scoped>

</style>

