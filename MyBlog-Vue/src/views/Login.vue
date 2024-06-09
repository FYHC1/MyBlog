<script setup>
import {ref} from 'vue'
import { useRouter } from 'vue-router';

const router=useRouter();
const register=()=>{
    router.push('/register')
}

const loginData=ref({
    username:'',
    password: ''
})

const rules={
    username: [
        {required: true ,message:'请输入用户名',trigger:'blur'},
        {min:2,max:10,message:'长度为2-10的非空字符',trigger:'blur'}
    ],
    password: [
    {required: true,message:'请输入密码',trigger:'blur'},
    {min:5,max:16,message:'长度为5-16的非空字符',trigger:'blur'}
    ]
}

import { userLoginService } from '@/api/User.js';
import { useTokenStore } from '@/stores/Token.js';
const tokenStore=useTokenStore();
const login1=async()=>{
    let result=await userLoginService(loginData.value)
     if (result.code === 0) {
        //成功了
        alert(result.message ? result.message : '登录成功');
        tokenStore.setToken(result.data)
        router.push('/admin')
        
    }else{
        //失败了
        alert(result.message ? result.message :'登录失败')
    } 

}

</script>

<template>
    <div class="loginuser">
        <div class="loginform">
            <el-form
                
                status-icon
                label-width="auto"
                class="label-form"
                :model="loginData"
                :rules="rules"
            >
                <el-form-item label="Username" prop="username">
                    <el-input v-model="loginData.username" />
                </el-form-item>
                <el-form-item label="Password" prop="password">
                    <el-input  type="password" autocomplete="off" v-model="loginData.password" />
                </el-form-item>
                <el-button type="primary" @click="login1">登录</el-button>
                <el-button type="primary" @click="register">注册</el-button>
            </el-form>
        </div>
    </div>
</template>

<style scoped>
.loginuser{
    height: 92vh;
    width: 100vw;
    /* background-color: #d85a5a; */
    margin: 0;
    padding-top: 20vh;
}

.loginform{
    height: 50vh;
    width: 40vw;
    background-color: #1211119f;
    
    margin-left: 30vw;
    padding-top: 10vh;
    padding-left: 5vw;
}

.label-form{
    height: 30vh;
    width: 30vw;
    background-color: #d9d8d1d3;
    padding-top: 2vh;
}
</style>