<script setup>

import {definedUser} from "../store/userStore.js";
import {definedSchedule} from "../store/scheduleStore.js";
import {onMounted} from "vue";
import request from "../utils/request.js";

let sysUser = definedUser();
let sysSchedule = definedSchedule();

onMounted(() => {
      showSchedule();
    }
)

//查询所有该uid 的日程信息
async function showSchedule() {
  let {data} = await request.get("/schedule/findAllSchedule", {params: {"uid": sysUser.uid}});
  sysSchedule.itemLise = data.data.itemList;
}

//为当前用户增加一条新的记录
async function addNewSchedule() {
  await request.get("/schedule/addNewSchedule", {params: {"uid": sysUser.uid}});
  await showSchedule();
}

async function saveChange(index) {
  await request.post("/schedule/saveChange", sysSchedule.itemLise[index])
  await showSchedule();
}

async function dropSchedule(index) {
  await request.post("/schedule/dropSchedule", sysSchedule.itemLise[index])
  await showSchedule();
}

</script>

<template>
  <div>
    <h3 class="ht">您的日程如下</h3>
    <table class="tab" cellspacing="0px">
      <thead>
      <tr class="ltr">
        <th>编号</th>
        <th>内容</th>
        <th>进度</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr class="ltr" v-for="(user,index) in sysSchedule.itemLise">
        <td>{{ index + 1 }}</td>
        <td>
          <input type="text" v-model="user.title">
        </td>
        <td>
          未完成<input type="radio" value="0" v-model="user.completed">
          已完成<input type="radio" value="1" v-model="user.completed">
        </td>
        <td class="buttonContainer">
          <button class="btn1" @click="dropSchedule(index)">删除</button>
          <button class="btn1" @click="saveChange(index)">保存修改</button>
        </td>
      </tr>
      <tr class="ltr buttonContainer">
        <td colspan="4">
          <button class="btn1" @click="addNewSchedule()">新增日程</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>


<style scoped>

.ht {
  text-align: center;
  color: cadetblue;
  font-family: 幼圆;
}

.tab {
  width: 80%;
  border: 5px solid cadetblue;
  margin: 0px auto;
  border-radius: 5px;
  font-family: 幼圆;
}

.ltr td {
  border: 1px solid powderblue;

}

.ipt {
  border: 0px;
  width: 50%;

}

.btn1 {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 100px;
  background-color: antiquewhite;

}

#usernameMsg, #userPwdMsg {
  color: gold;
}

.buttonContainer {
  text-align: center;
}

</style>
