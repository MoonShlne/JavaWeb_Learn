<script setup>
import {reactive, ref} from "vue";
import request from '../utils/request.js'
import router from "../routers/router.js";

let registerUser = reactive({
  username: '',
  password: ''
})

let usernameMsg = ref();
let userPwdMsg = ref();
let reUserPwdMsg = ref();
let reUserPwd = ref();

async function checkUsername() {

  let usernameReg = /^[a-zA-Z0-9]{5,10}$/
  if (usernameReg.test(registerUser.username)) {
    let response = await request.post(`http://localhost:8080/user/checkUsernameUsed?username=${registerUser.username}`)
    if (response.data.code === 200) {
      usernameMsg.value = "用户名可用"
      return true;
    } else {
      usernameMsg.value = "用户名已被占用"
      return false;

    }

  } else {
    usernameMsg.value = "用户格式有误"
    return false;
  }

}

function checkUserPwd() {
  let userPwdReg = /^[0-9]{6}$/
  if (userPwdReg.test(registerUser.password)) {
    userPwdMsg.value = "密码可用"
    return true
  }
  userPwdMsg.value = "密码格式有误"
  return false
}

function checkReUserPwd() {
  if (reUserPwd.value === registerUser.password) {
    reUserPwdMsg.value = "输入正确"
    return true;
  }
  reUserPwdMsg.value = "输入不一致";
  return false;

}

async function  register(){
  //校验方法是否合法
   let flag1=  await checkUsername();
   let flag2 = checkUserPwd();
   let flag3 =checkReUserPwd();
   if (flag1&&flag2&&flag3){
    var axiosResponse = await request.post("/user/register",registerUser);
     console.log(axiosResponse);
     if (axiosResponse.data.code === 200) {
      //注册成功，跳转router
       router.push("/login")
     } else {
        alert("发生未知错误")
       return false;

     }
   }
   else {
     alert("请输入正确的用户名和密码")
   }
}

</script>

<template>
  <div>
    <h3 class="ht">请注册</h3>

    <table class="tab" cellspacing="0px">
      <tbody>
      <tr class="ltr">
        <td>请输入账号</td>
        <td>
          <input class="ipt"
                 id="usernameInput"
                 type="text"
                 name="username"
                 v-model="registerUser.username"
                 @blur="checkUsername()">
          <span id="usernameMsg" class="msg" v-text="usernameMsg"></span>
        </td>
      </tr>
      <tr class="ltr">
        <td>请输入密码</td>
        <td>
          <input class="ipt"
                 id="userPwdInput"
                 type="password"
                 name="userPwd"
                 v-model="registerUser.password"
                 @blur="checkUserPwd()">
          <span id="userPwdMsg" class="msg" v-text="userPwdMsg"></span>
        </td>
      </tr>
      <tr class="ltr">
        <td>确认密码</td>
        <td>
          <input class="ipt"
                 id="reUserPwdInput"
                 type="password"
                 v-model="reUserPwd"
                 @blur="checkReUserPwd()">
          <span id="reUserPwdMsg" class="msg" v-text="reUserPwdMsg"></span>
        </td>
      </tr>
      <tr class="ltr">
        <td colspan="2" class="buttonContainer">
          <input class="btn1" type="button" @click="register()" value="注册">
          <input class="btn1" type="button" value="重置">
          <router-link to="/login">
            <button class="btn1">去登录</button>
          </router-link>
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
  width: 500px;
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
  width: 60px;
  background-color: antiquewhite;

}

.msg {
  color: gold;
}

.buttonContainer {
  text-align: center;
}
</style>
