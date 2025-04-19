import {createRouter, createWebHashHistory} from "vue-router";
import Login from "../components/Login.vue";
import Register from "../components/Register.vue";
import ShowSchedule from "../components/ShowSchedule.vue";
import {createPinia} from "pinia";
import {definedUser} from "../store/userStore.js";

// let pinia = createPinia();
// let sysUser = definedUser(pinia);


let router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/login',
            component: Login
        }
        , {
            path: '/register',
            component: Register
        },
        {
            path: '/showSchedule',
            component: ShowSchedule
        },
        {
            path: '/',
            redirect: 'showSchedule'
        }
    ]
})
// 路由守卫 访问showSchedule
router.beforeEach(
    (to, from, next) => {
        const sysUser = definedUser();
        if (to.path === '/showSchedule') {
            if (sysUser.username === '') {
                next('/login')
            } else {
                next()
            }

        } else {
            next()
        }
    }
)

export default router;