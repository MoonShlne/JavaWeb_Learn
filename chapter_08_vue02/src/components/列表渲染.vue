<script setup>
import {reactive} from "vue";

let items = reactive([
  {
    id: "item1",
    message: "薯片"
  },
  {
    id: "item2",
    message: "可乐"
  },
  {
    id: "item3",
    message: "炸鸡"
  }
  , {
    id: "item4",
    message: "飞机"
  }
])

let cart = reactive([
  {
    name: "可乐",
    price: 2,
    number: 10
  },
  {
    name: "鸡腿",
    price: 20,
    number: 1
  },
  {
    name: "方便面",
    price: 5,
    number: 2
  }, {
    name: "火腿肠",
    price: 2,
    number: 4
  }


])

function getMoney() {
  let count = reactive(0);
  for (let index in cart) {
    count += cart[index].number * cart[index].price;
  }
  return count;
}
function  clearCart(){
  cart.splice(0,cart.length)
}


function remove(index) {
  cart.splice(index, 1);
}

</script>

<template>

  <table border="1">
    <thead>
    <tr>
      <th>序号</th>
      <th>名称</th>
      <th>单价</th>
      <th>数量</th>
      <th>小记</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody v-if="cart.length!==0">
    <tr v-for="(items,index) in cart">
      <td>{{ index + 1 }}</td>
      <td>{{ items.name }}</td>
      <td>{{ items.price }}</td>
      <td>{{ items.number }}</td>
      <td>{{ items.number * items.price }}</td>
      <td>
        <button @click="remove(index)"> 删除</button>
      </td>
    </tr>
    </tbody>

    <tbody v-else>
    <tr><td colspan="6">真的没东西了</td></tr>
    </tbody>
  </table>
  <button @click="clearCart()">一键清空购物车</button>
  <h1 v-if="cart.length!==0">购物车总金额为 ：{{ getMoney() }}</h1>
  <h1 v-else> 空空如也</h1>

  <!--
  <ul>
    <li v-for="item in items">

    {{item.id}}  {{item.message}}</li>
  </ul>


  <hr>
  <ul>
    <li v-for="(item,index) in items ">

      {{index+1}}  {{item.message}}</li>
  </ul>
-->

</template>

<style scoped>

</style>


