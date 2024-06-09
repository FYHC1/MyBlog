<script setup>
import {useRouter} from 'vue-router'
const router=useRouter();
const massage=async()=>{
    router.push('/articles/massage')
}

</script>

<template>
    <!-- <h1>文章总览</h1> -->
    <el-scrollbar  class="scrollbar">
        <div class="dp"> <p>文章总览</p></div>
        <p v-for="item in 20" :key="item" class="scrollbar-demo-item" @click="massage"> {{ item }}</p>
        <!-- <el-menu> -->
            <!-- <el-menu-item v-for="item in 20" :key="item" ><button @click="massage"> {{ item }} </button></el-menu-item> -->
        <!-- </el-menu> -->
    </el-scrollbar>
</template>

<style scoped>
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
  border: 2px;
  border-radius: 4px;
  background: var(--el-color-primary-light-9);
  color: var(--el-color-primary);
}

</style>