<script setup>


</script>

<template>
  <router-link to="/list">list</router-link>
  <br>
  <router-link to="/operate">operate</router-link>

  <router-view></router-view>
  <router-view name="operate"></router-view>
</template>

<style scoped>

</style>
