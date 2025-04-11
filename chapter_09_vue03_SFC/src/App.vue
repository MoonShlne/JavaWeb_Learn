<script setup>
import Header from "./components/Header.vue";
import Content from "./components/Content.vue";
import Navigator from "./components/Navigator.vue";
import {ref} from "vue";

let getMessage =ref();
function  receiver(data){
  getMessage.value=data;
}

</script>

<template>
<div>
  {{message}}
  <Header class="header"></Header>
  <Navigator class="Navigator" @sendMenu="receiver"></Navigator>
  <Content class="Content"  v-bind:message="getMessage"></Content>

</div>
</template>


<style scoped>

.header {
  width: 100%;
  height: 80px;
  border: 1px solid darkkhaki;
}
.Navigator{
  height: 500px;
  width: 35%;
  border: 1px solid fuchsia;
  float: left;
}

.Content{
height: 500px;
  width: 64%;
  border: 1px solid darkcyan;
  float: right;

}

</style>
