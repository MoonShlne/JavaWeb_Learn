import {createRouter, createWebHashHistory} from "vue-router";
import List from "../components/List.vue";
import Home from "../components/Home.vue";
import Add from "../components/Add.vue";
import ShowDetails from "../components/ShowDetails.vue";

const router = createRouter(
    {
        history: createWebHashHistory()
        , routes: [
            {path:"/list",component:List},
            {path:"/home",component:Home},
            {path:"/Add",component:Add},
            {path:"/ShowDetails/:id/:age",component:ShowDetails}
        ]
    }
);
export  default  router;