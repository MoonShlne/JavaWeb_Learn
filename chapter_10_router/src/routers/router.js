import {createRouter, createWebHashHistory} from "vue-router"
import Home from "../components/Home.vue";
import List from "../components/List.vue";
import Add from "../components/Add.vue";
import App from "../App.vue";


const router = createRouter(
    {
        history: createWebHashHistory(),
        routes: [
            {
                path: "/home",
                component: {HomeView:Home}
            }, {
                path: "/list",
                component: {ListView:List}
            }, {
                path: "/Add",
                component: Add
            }, {
                path: "/",
                component: Home
            }
            , {path: "/haha",
                redirect: "/List"}


        ]
    }
);


export default router;