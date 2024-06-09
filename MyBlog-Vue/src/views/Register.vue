<script setup>
import {ref} from 'vue'
import { useRouter } from 'vue-router';
const registerData=ref({
    username:'',
    password: '',
    repasswd:''
})

const checkRePasswd = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('Please input the password again'))
  } else if (value !== registerData.value.password) {
    callback(new Error("Two inputs don't match!"))
  } else {
    callback()
  }
}


const rules={
    username: [
        {required: true ,message:'请输入用户名',trigger:'blur'},
        {min:2,max:10,message:'长度为2-10的非空字符',trigger:'blur'}
    ],
    password: [
    {required: true,message:'请输入密码',trigger:'blur'},
    {min:5,max:16,message:'长度为5-16的非空字符',trigger:'blur'}
    ],
    repasswd: [
    { validator: checkRePasswd,trigger:'blur'}
    ]
}

const router=useRouter()
const login1=async()=>{
    router.push('/login')
}

import { userRegisterService } from '@/api/User.js';
const register1=async()=>{
    let result=await userRegisterService(registerData.value)
     if (result.code === 0) {
        //成功了
        alert(result.message ? result.message : '注册成功');
        login1();
    }else{
        //失败了
        alert(result.message ? result.message :'注册失败')
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
                :model="registerData"
                :rules="rules"
            >
                <el-form-item label="Username" prop="username">
                    <el-input v-model="registerData.username" />
                </el-form-item>
                <el-form-item label="Password" prop="password">
                    <el-input  type="password" autocomplete="off" v-model="registerData.password" />
                </el-form-item>
                <el-form-item label="Repasswd" prop="repasswd">
                    <el-input  type="password" autocomplete="off" v-model="registerData.repasswd" />
                </el-form-item>
                <!-- <el-button type="primary">登录</el-button> -->
                <el-button type="primary" @click="register1" >注册</el-button>
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