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
                component: Home
            }, {
                path: "/list",
                component: List
            }, {
                path: "/Add",
                component: Add
            }, {
                path: "/",
                component: Home
            }
            , {
                path: "/haha",
                redirect: "/List"
            }


        ]
    }
);

//设置全局前置守卫
router.beforeEach((to, from, next) => {
    console.log("beforeEach");
    console.log(from.path);
    console.log(to.path);
    next();


})

//全局后置首位
router.afterEach(() => {
    console.log("afterEach");
})

export default router;