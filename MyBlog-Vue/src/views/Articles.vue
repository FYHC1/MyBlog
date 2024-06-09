<script setup>

// import Article from './Article.vue';
import {useRouter} from 'vue-router'
import { ref } from 'vue';

import { getMassageNum } from '@/api/GetMassageNum';

import { useIdStore } from '@/stores/Id';

const article=ref({
  title:'',
  id:0,
  content:'',
  createTime:'',
  updateTime:''
})

const router=useRouter();
const idStore=useIdStore();
const massage=async(aid)=>{
    router.push('/massage')
    idStore.setIdStore(aid);
}

const num=ref(0);

const massagenum=async()=>{
   let result= await getMassageNum();
  //  alert(result.data)
   num.value=result.data
}

massagenum();



const articles=ref([
{
     "title": "长沙旅游攻略",
     "id": 1,
     "content": "天安门...爱去哪去哪...",
     "createTime": "2024-06-06T19:50:08",
     "updateTime": "2024-06-06T19:50:08"
 },
 {
     "title": "blog1",
     "id": 2,
     "content": "blog1",
     "createTime": "2024-06-06T20:20:37",
     "updateTime": "2024-06-06T20:20:37"
 },
 {
     "title": "blog1",
     "id": 3,
     "content": "blog1",
     "createTime": "2024-06-06T20:22:55",
     "updateTime": "2024-06-06T20:22:55"
 },
 {
     "title": "blog",
     "id": 4,
     "content": "12345",
     "createTime": "2024-06-06T20:23:22",
     "updateTime": "2024-06-06T20:23:22"
 },
]);

import { getArticleListService } from '@/api/Article';
const getArticleList=async()=>{
  let result= await getArticleListService();
  articles.value=result.data
}

getArticleList()
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
                    <span>{{ num }}</span>
                    <span>1</span>
                </div>
            </div>
        </div>
      </el-aside>
      <el-container>

        <el-main class="main">
          <el-scrollbar  class="scrollbar">
            <div class="dp"> <p>文章总览</p></div>
           <p v-for="item in articles " :key="item" class="scrollbar-demo-item" @click="massage(item.id)">{{ item }} </p>
          </el-scrollbar>
          <router-view></router-view>
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
  height: 80vh;
  width: 60vw;
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

.scrollbar-demo-item {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 150px;
  margin: 10px;
  text-align: center;
  border-radius: 4px;
  /* background: var(--el-color-primary-light-9); */
  /* color: var(--el-color-primary); */
  background-color: #b64f4f6a;
}
</style>