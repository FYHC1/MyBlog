<script setup>
import {Share, User,Message} from '@element-plus/icons-vue'
import {useRouter} from 'vue-router'
// import clipboard from 'clipboard'
// import VueClipboard from 'vue-clipboard2'
// import Vue from 'vue'

const router=useRouter();

const home=async()=>{
    router.push('/')
}

const articles=async()=>{
    router.push('/articles')
}

const timerShaft=async()=>{
    router.push('/timerShaft')
}

const friendLink=async()=>{
    router.push('/friendLink')
}

const about=async()=>{
    router.push('/about')
}

const login=async()=>{
    router.push('/login')
}

import { defineAsyncComponent, ref } from 'vue'
import { Calendar, Search } from '@element-plus/icons-vue'
const input1 = ref('')

const copyURL=()=>{
  const el = document.createElement('textarea');
    el.value = window.location.href;
    document.body.appendChild(el);
    el.select();
    document.execCommand('copy');
    document.body.removeChild(el);
    alert('URL已成功复制到剪贴板！');
}
// 
</script>

<template>
  <div class="common-layout0">
    <el-container>
      <el-header class="header">
        <el-row class="row1" >
          <el-rol :span="2" class="logo"> <img src=".\assets\imgs\OIG4.jpg" width="60" height="55"> </el-rol>

          <el-col :span="8" :offset="7">
            <el-menu
              :default-active="activeIndex"
              class="el-menu-demo"
              mode="horizontal"
              @select="handleSelect"
            >
              <el-menu-item index="1" @click="home"><el-icon><HomeFilled /></el-icon>首页</el-menu-item>
              <el-menu-item index="2" @click="articles"><el-icon><Message /></el-icon>文章</el-menu-item>
              <el-menu-item index="3" @click="timerShaft"><el-icon><Message /></el-icon>时间轴</el-menu-item>
              <el-menu-item index="4" @click="friendLink"><el-icon><Link /></el-icon>友链</el-menu-item>
              <el-menu-item index="5" @click="about"><el-icon><MoreFilled /></el-icon>关于</el-menu-item>
            </el-menu>
          </el-col>
         
          <el-col :span="3" :offset="3" class="search" >
              <!-- <el-button size="large" :icon="Search" round >Search</el-button> -->
              <el-input
                v-model="input1"
                style="width: 10vw"
                placeholder="Type something"
                :prefix-icon="Search"
              />
          </el-col>

          <el-col :span="1" class="share">
            <el-button type="primary" :icon="Share" @click="copyURL" />
          </el-col>

          <el-col :span="1" class="user">       
            <el-button type="info" :icon="User" circle @click="login" />
          </el-col>

        </el-row>
      </el-header>


      <el-main class="main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<style scoped>
.common-layout0{
  /* height: 100vh; */
  /* width: 100vw; */
  background-image: url(.\assets\imgs\coverimg3.png) ;
  background-size: 100% 100%;
}


.header{
  height: 8vh;
  padding: 0;
  margin: 0;
  background-color: rgb(255, 255, 255);
  opacity: 0.7;
}

.logo{
  margin-top: 3px;
  opacity: 0.9;
}

.el-menu{
    margin: 0;
    padding: 1px;
    height: 8vh;
    opacity: 0.9;
  }

.el-input{
  margin-top: 15px;
  opacity: 0.9;
}

.share{
  margin-top: 15px;
  opacity: 0.9;
}

.user{
  margin-top: 15px;
  opacity: 0.9;
}

.el-row {
  margin-bottom: 10px;
  /* margin-top: 10px; */
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.main{
  height: 92vh;
  margin: 0;
  padding: 0;
}

</style>
