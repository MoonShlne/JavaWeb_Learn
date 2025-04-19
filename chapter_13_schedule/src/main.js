import { createApp } from 'vue'
import App from './App.vue'
import router from "./routers/router.js";
import {createPinia} from "pinia";
let pinia = createPinia();


var elementApp = createApp(App);
elementApp.use(router)
elementApp.use(pinia)
elementApp.mount('#app')
