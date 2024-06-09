<script lang="ts" setup>
import { MoreFilled } from '@element-plus/icons-vue'

const article=ref({
  title:'',
  id:0,
  content:'',
  createTime:'',
  updateTime:''
})

const activities = [
  {
    content: 'Custom icon',
    timestamp: '2018-04-12 20:46',
    size: 'large',
    type: 'primary',
    icon: MoreFilled,
  },
  {
    content: 'Custom color',
    timestamp: '2018-04-03 20:46',
    color: '#0bbd87',
  },
  {
    content: 'Custom size',
    timestamp: '2018-04-03 20:46',
    size: 'large',
  },
  {
    content: 'Custom hollow',
    timestamp: '2018-04-03 20:46',
    type: 'primary',
    hollow: true,
  },
  {
    content: 'Default node',
    timestamp: '2018-04-03 20:46',
  },
]


import { ref } from 'vue';
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
<div class="container">
  <el-scrollbar  class="scrollbar">
    <div class="timershaft">
        <el-timeline >
            <el-timeline-item
            v-for="(article, index) in articles"
            :key="index"
            :icon="MoreFilled"
            
            :timestamp="article.createTime"
            >
            {{ article.title }}
            </el-timeline-item>
        </el-timeline>
    </div>
  </el-scrollbar>
</div>
</template>

<style scoped>
.container{
  height: 92vh;
  width: 100vw;
  display: flex;
  justify-content: center;
  align-items: center;
  /* background-color: rgb(223, 231, 231); */
  opacity: 0.9;
}

/* .timershaft{ */
/*      */
/* } */

.el-timeline{
  margin-top: 10vh;
  justify-content: center;
  align-items: center;
  background-color: #74e976;
}

.el-timeline-item{
    /* height: 15vh; */
    font-size: large;
    justify-content: center;
    align-items: center;
}
</style>