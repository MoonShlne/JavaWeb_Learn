import axios from "axios";


const instance = axios.create({
    baseURL: 'https://api.uomg.com',

})
instance.interceptors.request.use(
    function (config) {
        console.log("拦截器生效");
        config.headers.Accept ="application/json,text/plain,text/html,*/*"
        return config
    },

    function (error) {
        console.log("拦截器异常方法");

        return Promise.reject("wrong")
    }
)
instance.interceptors.response.use(


)


export default instance