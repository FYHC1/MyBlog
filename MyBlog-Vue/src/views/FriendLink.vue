<script setup>
import { getFriendLink } from '@/api/GetFriendLink';
const getfriendlink=()=>{
    return getFriendLink();
}
const friendlink=[2,3,4,5]
// friendlink=getfriendlink();
</script>

<template>
    <div class="Friendlink" style="display: flex; flex-direction: column;">
        <p v-for="item in friendlink":key="item" class="Friendlink-item">{{ item }}</p>
    </div>
</template>

<style scoped>
.Friendlink{
    height: 60vh;
    display: flex;
    justify-content: center;
    align-items: center;
    p{
    font-size:xx-large;
    color: rgb(53, 189, 189);
    }
    margin-top: 10vh;
}

.Friendlink-item{
    display: flex;
    align-items: center;
    justify-content: center;
    height: 150px;
    width: 60vw;
    margin-top: 10vh;
    text-align: center;
    border-radius: 4px;
    /* background: var(--el-color-primary-light-9); */
    /* color: var(--el-color-primary); */
    background-color: #699aef6a;
}
</style>