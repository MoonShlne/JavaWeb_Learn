<script setup>
import {definedUser} from "../store/userStore.js";
import {definedSchedule} from "../store/scheduleStore.js";
import {useRouter} from "vue-router";

let User = definedUser();
let router=useRouter();
let schedule = definedSchedule();

function logOut(){
  //清空数据
  User.$reset();
  schedule.$reset();

  router.push("login")

}
</script>
<template>
  <div>
    <h1 class="ht">欢迎使用日程管理系统</h1>
    <div>
      <div  class="optionDiv" v-if="User.username===''">
        <router-link to="/login">
          <button class="b1s">登录</button>
        </router-link>
        <router-link to="/register">
          <button class="b1s">注册</button>
        </router-link>
      </div>


      <div   class="optionDiv" v-else>
        欢迎{{ User.username }}
        <button class="b1b" @click="logOut()">退出登录</button>
        <router-link to="/showSchedule">
          <button class="b1b">查看我的日程</button>
        </router-link>
      </div>

      <br>
    </div>
  </div>
</template>

<style scoped>

.ht{
  text-align: center;
  color: cadetblue;
  font-family: 幼圆,serif;
}
.b1s{
  border: 2px solid powderblue;
  border-radius: 4px;
  width:60px;
  background-color: antiquewhite;

}

.b1b{
  border: 2px solid powderblue;
  border-radius: 4px;
  width:100px;
  background-color: antiquewhite;
}
.optionDiv{
  width: 400px;
  float: right;
}
</style>