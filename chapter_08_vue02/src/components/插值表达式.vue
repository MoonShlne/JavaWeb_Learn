<script setup>
/*插值表达式*/

let msg = "tiger";

let getMsg = () =>{
  return msg;
}

let age =17;

let bee ="蜜 蜂";

let cart = [{name:"cola",price:5,number:3},{name:"beef",price:50,number:3}]

let getPrice =() =>{
  let count =0;
  for (let i in cart ){
    count += cart[i].price*cart[i].number
  }
  return count;

}


</script>

<template>
  <span>{{msg}}</span>
  <br>
  <span>{{getMsg()}}</span>
  <br>
  年龄{{ age }} <span>{{age>18?"成年":"未成年"}}</span>
  <hr>
  <span>{{bee.split(" ").reverse().join("")}}</span>

  <hr>
  <span>{{getPrice()}}</span>

</template>

<style scoped>

</style>
