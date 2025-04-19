<script setup>
import {reactive, ref} from "vue";
import request from "../utils/request.js";
import {definedUser} from "../store/userStore.js";
import {useRouter} from "vue-router";
const router = useRouter();
const sysUser = definedUser();
let loginUser = reactive({
  username: '',
  password: ''
})

let usernameMsg = ref();
let userPwdMsg = ref();


function checkUsername() {

  let usernameReg = /^[a-zA-Z0-9]{5,10}$/
  if (usernameReg.test(loginUser.username)) {
    usernameMsg.value = "用户名可用"
    return true;
  } else {
    usernameMsg.value = "用户名不可用"
    return false;
  }

}

function checkUserPwd() {
  let userPwdReg = /^[0-9]{6}$/
  if (userPwdReg.test(loginUser.password)) {
    userPwdMsg.value = "密码可用"
    return true
  }
  userPwdMsg.value = "密码格式有误"
  return false
}

async function login() {
  let flag1 = checkUsername();
  let flag2 = checkUserPwd();
  if (flag1 && flag2) {
      var axiosResponse = await request.post("/user/login", loginUser);
    if (axiosResponse.data.code === 200) {
      alert("登录成功")
      console.log(axiosResponse.data.data);
      sysUser.uid= axiosResponse.data.data.loginUser.uid;
      sysUser.username=axiosResponse.data.data.loginUser.username;
      router.push("/showSchedule")
    } else if (axiosResponse.data.code === 501) {
      alert("用户名有误")
    } else if (axiosResponse.data.code === 503) {
      alert("密码有误")
    } else {
      alert("请输入")
    }

  }
}

</script>

<template>
  <div>
    <h3 class="ht">请登录</h3>
    <table class="tab" cellspacing="0px">
      <tbody>
      <tr class="ltr">
        <td>请输入账号</td>
        <td>
          <input class="ipt"
                 type="text"
                 v-model="loginUser.username"
                 @blur="checkUsername()">
          <span id="usernameMsg" v-text="usernameMsg"></span>
        </td>
      </tr>
      <tr class="ltr">
        <td>请输入密码</td>
        <td>
          <input class="ipt"
                 type="password"
                 v-model="loginUser.password"
                 @blur="checkUserPwd()">
          <span id="userPwdMsg" v-text="userPwdMsg"></span>
        </td>
      </tr>
      <tr class="ltr">
        <td colspan="2" class="buttonContainer">
          <input class="btn1" type="button" @click="login()" value="登录">
          <input class="btn1" type="button" value="重置">
          <router-link to="/register">
            <button class="btn1">去注册</button>
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

#usernameMsg, #userPwdMsg {
  color: gold;
}

.buttonContainer {
  text-align: center;
}
</style>
