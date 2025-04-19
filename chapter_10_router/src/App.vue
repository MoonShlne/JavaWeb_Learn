<script setup>
</script>

<template>

  <div>
    <h1>导航栏</h1>
    <hr>
    <router-link to="/home">home</router-link>
    <br>
    <router-link to="/list">list</router-link>
    <br>
    <router-link to="/add">add</router-link>
    <br>

    <router-view></router-view>
    <hr>


    <h1>版权声明</h1>
  </div>

</template>

<style scoped>

</style>
