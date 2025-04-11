<script setup>
let msg = "haha"
let msg2 = `msg =${msg}`
let bee = "蜜 蜂"
let span = "  <span style=\"color: #9B5146;\">你好</span>\n";
</script>

<template>
  <h1 v-text="msg"></h1>
  <h1 v-text="17>18?'成年':'未成年'"></h1>
  <h1 v-text="msg2"></h1>
  <h1 v-text="`你好${msg}`"></h1>
  <h1 v-text="bee.split('').join('')"></h1>
<h1 v-text="span"></h1>
  <h1 v-html="span"></h1>
</template>

<style scoped>

</style>
