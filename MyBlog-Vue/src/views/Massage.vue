<script setup>

import { useIdStore } from '@/stores/Id';
import { ref } from 'vue';
const article=ref({
  title:'',
  id:0,
  content:'',
  createTime:'',
  updateTime:''
})


const idStore=useIdStore()
const aid=idStore.id;

import { getArticleContenService } from '@/api/Article';
const getArticleConten=async(aid)=>{
  let result=await getArticleContenService(aid);
  article.value=result.data
}

getArticleConten(aid);

const num=ref(0);
import { getMassageNum } from '@/api/GetMassageNum';
const massagenum=async()=>{
   let result= await getMassageNum();
  //  alert(result.data)
   num.value=result.data
}

massagenum();
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-aside class="aside">
        <div class="container-left">
            <div class="card">
                <img src="../assets/imgs/OIG1.jpg" class="avtar" alt="">
                <h3>FYHC1</h3>
                <a href="https://github.com/FYHC1">github 地址</a>
                <div class="counter">
                    <span>文章</span>
                    <span>分类</span>
                </div>
                <div class="counter">
                    <span>{{num}}</span>
                    <span>1</span>
                </div>
            </div>
          </div>
      </el-aside>
      <el-container>

        <el-main class="main">
          <el-scrollbar  class="scrollbar">
            <div class="dp"> <p>{{ article.title }}</p></div>
            <div class="content">{{ article.content }}</div>
          </el-scrollbar>
          <!-- <router-view></router-view> -->
        </el-main>
        
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
.aside{
    width: 25vw;
    height: 92vh;
    /* background-color: black; */
    padding-top: 5vh;
    padding-left: 5vh;
    
    /* 展示用户信息的卡片 */
  .card {
      height: 45vh;
      width: 17vw;
      background-color: rgba(236, 225, 156, 0.79);
      border-radius: 10px;
      padding-top: 5vh;
      padding-left: 2vh;
  }

  /* 用户头像 */
  .card img {
      width: 120px;
      height: 120px;
      border-radius: 50%;
      margin-left:4vw;
  }

  /* 用户名 */
  .card h3 {
      text-align: center;
      padding: 10px;
  }

  /* 用户gitee连接 */
  .card a {
      display: block;
      text-align: center;
      color: #999;
      text-decoration: none;
      padding: 10px;
  }

  /* 展示文章数目的面板 */
  .card .counter {
      padding: 5px;
      display: flex;
      justify-content: space-around;
  }
}

.scrollbar{
  height: 85vh;
  width: 60vw;
  background-color: #a294239a;
  .dp{
    height: 5vh;
    display: flex;
    justify-content: center;
    align-items: center;

    p{
      font-size:xx-large;
      color: rgb(53, 189, 189);
    }
  }
}

.content{
    height: 80vh;
    width: 60vw;
    background-color: #fff;
}
</style>