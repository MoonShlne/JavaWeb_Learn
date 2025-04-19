import {createRouter, createWebHashHistory} from "vue-router";
import Home from "../components/Home.vue";
import Login from "../components/Login.vue";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/home',
            component: Home
        },
        {
            path: '/',
            component: Login
        },
        {
            path: '/login',
            component: Login
        }
    ]

})

router.beforeEach((to, from, next) => {

    if (to.path === '/login') {
        next()
    } else {
        if (sessionStorage.getItem("userName") != null) {
            next();
        } else {
            next("/login")
        }
    }
})


export default router;