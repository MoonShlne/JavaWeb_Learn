import {createRouter, createWebHashHistory} from "vue-router";
import List from "../components/List.vue";
import Operate from "../components/Operate.vue";


var router = createRouter(
    {
        history: createWebHashHistory(),
        routes: [
            {
                path: '/list',
                components: {
                    default: List,
                    operate: Operate
                }
            },
            {
                path: '/operate',
                component: Operate
            }
        ]


    }
);

export default router;