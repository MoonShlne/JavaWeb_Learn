//定义共享pinia
import {defineStore} from "pinia";


//定义一个person

export const definedPerson = defineStore ('personPinia',
    {

        state: () => {
            return{
                username:"zhangsan",
                age:5,
                hobbies:["唱","跳","rap","🏀"]
            }
        },
        getters:{
            getAge(){
                return this.age;
            },
            getHobbiesCount(){
                return this.hobbies.length;
            }
        },
        actions:{
           doubleAge(){
               this.age=this.age*2;
           }
        }


    }
)


