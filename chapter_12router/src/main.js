import { createApp } from 'vue'
import App from './App.vue'
import router from "./routers/router.js";

var elementApp = createApp(App);
elementApp.use(router)
elementApp.mount('#app')
