import { createApp } from 'vue'
import App from './App.vue'
import router from "./router/router.js";
// 开启全局pinia功能
import {createPinia} from "pinia";
let pinia = createPinia();
let elementApp = createApp(App);
elementApp.use(router)
elementApp.use(pinia)
elementApp.mount('#app')
