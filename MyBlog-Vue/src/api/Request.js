import axios from "axios";
import { useTokenStore } from "@/stores/Token";
import { ElMessage, resultProps } from "element-plus";
// import { useRouter } from "vue-router";
// const baseURL='http://localhost:8080';
const baseURL='/api';
// 创建 Axios 实例
const instance = axios.create({ 
  baseURL,
  timeout:1000
});

// const router=useRouter()
import router from "@/router";

instance.interceptors.request.use( 
  (config) =>{
    const tokenStore=useTokenStore();
    // 在发送请求之前做些什么
    if(tokenStore.token){
      config.headers.Authorization=tokenStore.token;
    }
    return config
  }, (error) =>{
    // 对请求错误做些什么
    return Promise.reject(error)
  })
   
  // 添加响应拦截器
  instance.interceptors.response.use(
    result=>{
      //判断业务状态码
      if(result.data.code===0){
        return result.data;
      }
      //操作失败
      //alert(result.data.msg?result.data.msg:'服务异常')
      ElMessage.error(result.data.msg?result.data.msg:'服务异常')
      //异步操作的状态转换为失败
    return Promise.reject(result.data)
  }, error=>{
    if(result.data.status===401){
      ElMessage.error("请先登录");
      router.push('/login')
    }else{
      ElMessage.error("服务错误")
    }

    return Promise.reject(error)
  })
   

  // 3.导出axios实例instance
  export default instance
