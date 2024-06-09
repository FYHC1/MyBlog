<script setup>
import {Search,Share} from '@element-plus/icons-vue'
import {useRouter} from 'vue-router'

const router=useRouter();

const home=async()=>{
    router.push('/')
}

const article=async()=>{
    router.push('/article')
}

</script>

<template>
  <div class="common-layout">
    <el-container>
      <!-- <el-header id="header"> -->
        <!-- <el-row class="row1" > -->
          <!-- <el-rol :span="2" class="logo"> <img src="..\assets\imgs\OIG4.jpg" width="60" height="55"> </el-rol> -->
<!--  -->
          <!-- <el-col :span="8" :offset="7"> -->
            <!-- <el-menu -->
              <!-- :default-active="activeIndex" -->
              <!-- class="el-menu-demo" -->
              <!-- mode="horizontal" -->
              <!-- @select="handleSelect" -->
            <!-- > -->
              <!-- <el-menu-item index="1" @click="home"><el-icon><HomeFilled /></el-icon>首页</el-menu-item> -->
              <!-- <el-menu-item index="2" @click="article"><el-icon><Message /></el-icon>文章</el-menu-item> -->
              <!-- <el-menu-item index="3"><el-icon><Message /></el-icon>时间轴</el-menu-item> -->
              <!-- <el-menu-item index="4" ><el-icon><Link /></el-icon>友链</el-menu-item> -->
              <!-- <el-menu-item index="5"><el-icon><MoreFilled /></el-icon>关于</el-menu-item> -->
            <!-- </el-menu> -->
          <!-- </el-col> -->
<!--           -->
          <!-- <el-col :span="2" :offset="4" class="search" > -->
              <!-- <el-button size="large" :icon="Search" round >Search</el-button> -->
          <!-- </el-col> -->
<!--  -->
          <!-- <el-col :span="1" class="share"> -->
            <!-- <el-button type="primary" :icon="Share" /> -->
          <!-- </el-col> -->
<!--  -->
        <!-- </el-row> -->
      <!-- </el-header> -->

      <el-main class="main">
        <div class="note1">
         <h1>FYHC1的Blog</h1>
         <h3>愿此行终抵群星~</h3>
        </div>
      </el-main>
      <el-footer class="footer">
      <b> FYHC1@CopyRight </b>
      
      </el-footer>
    </el-container>
  </div>
</template>

<style scoped>

.common-layout{
  height: 92vh;
  width: 100vw;
  /* background-image: url(..\assets\imgs\coverimg3.png) ; */
  /* background-size: 100% 100%; */
}

#header{
  height: 8vh;
  padding: 0;
  margin: 0;
  background-color: #fff;
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

.search{
  margin-top: 10px;
  opacity: 0.9;
}

.share{
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
  height: 85vh;
  margin: 0;
  /* p{ */
    /* justify-content: center; */
    /* align-items: center; */
  /* } */

  .note1{
    height: 200px;
    width: 200px;
    /* background-color: #dea46b; */
    text-align: center; /* 文字水平居中 */
    line-height: 50px; /* 设置行高以实现垂直居中 */
    margin: auto; /*div水平居中; */
    margin-top: 25vh;

    h1{
      color: #fff;
    }
    h3{
      color: #fff;
    }
  }
}

.footer{
  height: 7vh;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  background-color: black;
  opacity: 0.6;

  b{
    font-weight: bold;
    color: white;
  }
 
}

</style>
