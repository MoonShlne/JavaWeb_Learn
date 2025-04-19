import {defineStore} from "pinia";


  export const definedUser = defineStore(
    "loginUser", {
        state: () => {
            return {
                uid:0,
                username:'',

            }
        },
        getters: {},
        actions: {}


    }
);
