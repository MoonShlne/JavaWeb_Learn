import {createApp} from 'vue'
import App from './App.vue'
//在App可以使用路由
import router from "./routers/router.js"


var elementApp = createApp(App);
elementApp.use(router);
elementApp.mount('#app')
