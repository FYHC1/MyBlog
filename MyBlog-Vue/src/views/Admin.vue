<script setup>
import { ref,reactive} from 'vue';
import { Edit } from '@element-plus/icons-vue';
import { getArticleListService } from '@/api/Article';
import { addArticleService } from '@/api/Article.js';

const article=ref({
  title:'',
  id:0,
  content:'',
  createTime:'',
  updateTime:''
})

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
])

const dialogFormVisible = ref(false)
const textarea=ref('')

const getArticleList=async()=>{
  let result= await getArticleListService();
  articles.value=result.data
}
getArticleList();

const addArticle=async()=>{
  
  let result=await addArticleService(article.value)
  
  if (result.code === 0) {
    //成功了
    alert(result.message ? result.message : '添加成功');
    login1();
}else{
    //失败了
    alert(result)
    alert(result.message ? result.message :'添加失败')
} 
}

const dialogFormTitle=ref('')
const addTitle=ref('Addarticle')
const articleAdd=()=>{
  dialogFormVisible.value=false;
  dialogFormTitle.value=addTitle.value;
  addArticle();
  getArticleList();
}

const currentPage =ref(1)
const pageSize = ref(5)
const small = ref(false)
const background = ref(false)
const disabled = ref(false)

// const total=tableData.length
const total1=100
const idnum=[]

const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val) => {
   console.log(`current page: ${val}`)
}


const editDialogVisible=ref(false)

import {getArticleContenService} from'../api/Article.js'

const getArticleConten=async(id)=>{
  let result=await getArticleContenService(id);
  article.value=result.data
  
}

const articleClean=()=>{
  article.title='',
  article.id=0,
  article.content='',
  article.createTime='',
  article.updateTime=''
}


const handleEdit = (row) => {
  console.log(row.id)
  editDialogVisible.value=true;
  getArticleConten(row.id);
}

import { deleteArticleService } from '@/api/Article'

const handleDelete = async(row) => {
  let result= await deleteArticleService(row.id)
  await getArticleList();
  // alert(row.id)
  
}

import { updateArticleService } from '@/api/Article';
const updateArticle=async()=>{
  await updateArticleService(article.value);
  editDialogVisible.value=false
}


</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
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
                  <span>2</span>
                  <span>1</span>
              </div>
          </div>
        </div>
      </el-aside>
      <el-main>
        <div class="article-admin">
          <div class="article-top">
            <el-button plain @click="dialogFormVisible=true">
              Add a article
            </el-button>
             <el-dialog v-model="dialogFormVisible" title="dialogFormTitle" width="500">
              <el-form :model="article">
                <el-form-item label="Title name" :label-width="formLabelWidth">
                  <el-input v-model="article.title" autocomplete="off" />
                </el-form-item>
                <el-form-item label="Content" :label-width="formLabelWidth">
                  <el-input
                  v-model="article.content"
                  style="width: 25vw"
                  :autosize="{ minRows: 4, maxRows: 8 }"
                  type="textarea"
                  placeholder="Please input"
                />
                </el-form-item>
              </el-form>
              <template #footer>
                <div class="dialog-footer">
                  <el-button @click="dialogFormVisible=false">Cancel</el-button>
                  <el-button type="primary" @click="articleAdd">
                    Confirm
                  </el-button>
                </div>
              </template>
            </el-dialog>
            <el-button type="primary" :icon="Edit" circle class="edit" size="large"  />
          </div>
          <div class="article-main">
            <el-scrollbar>
              <el-table stripe="true" :border="true" :data="articles" >
                <el-table-column prop="id" label="Id" type="index" width="150" />
                <el-table-column prop="title" label="Title" width="150" />
                <el-table-column fixed prop="createTime" label="CreateTime" width="150" />
                <el-table-column fixed="right" label="Operations" width="200">
                  <template #default="{row}">
                    <!-- <el-button link type="primary" size="small" @click="detail"> -->
                      <!-- Detail -->
                    <!-- </el-button> -->
                    <el-button link type="primary" size="small" @click="handleEdit(row)" >Edit</el-button>
                    <el-button link type="danger" size="small" @click="handleDelete(row)">Delete</el-button>

                  </template>
                </el-table-column>
              </el-table>
              <!-- <p v-for="i in 20":key="i">{{ i }} </p> -->
            </el-scrollbar>  
            <!-- <div class="demo-pagination-block"> -->
              
              <!-- <el-pagination -->
                <!-- v-model:current-page="currentPage" -->
                <!-- v-model:page-size="pageSize" -->
                <!-- :current-page="5" -->
                <!-- :page-size="5" -->
                <!-- :page-sizes="[5,10]" -->
                <!-- :small="small" -->
                <!-- :disabled="disabled" -->
                <!-- :background="background" -->
                <!-- layout="sizes, prev, pager, next" -->
                <!-- :total=total1 -->
                <!-- @size-change="handleSizeChange" -->
                <!-- @current-change="handleCurrentChange" -->
              <!-- /> 
            </div>-->
          </div>
          <el-dialog v-model="editDialogVisible" title="Warning" width="500" center>
           <!-- <span> -->
            <!-- {{ article.content }} -->
           <!-- </span> -->
           <el-form :model="article">
                <el-form-item label="Title name" :label-width="formLabelWidth">
                  <el-input v-model="article.title" autocomplete="off" />
                </el-form-item>
                <el-form-item label="Content" :label-width="formLabelWidth">
                  <el-input
                  v-model="article.content"
                  style="width: 25vw"
                  :autosize="{ minRows: 4, maxRows: 8 }"
                  type="textarea"
                  placeholder="Please input"
                />
                </el-form-item>
              </el-form>
           <template #footer>
             <div class="dialog-footer">
               <el-button @click="editDialogVisible = false">Cancel</el-button>
               <el-button type="primary" @click="updateArticle">
                 Confirm
               </el-button>
             </div>
           </template>
          </el-dialog>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<style scoped>

.el-aside{
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

.article-admin{
  width: 55vw;
  height: 70vh;
  background-color: #ffffff99;
  margin-top: 5vh;
  margin-left: 5vw;
}

.article-top{
  width: 55vw;
  height: 8vh;
  background-color: #de9999;
}

.edit{
  float: right;
  margin-right: 2vw;
}

.article-main{
  width: 55vw;
  height: 65vh;
  background-color: #fff;
}

.el-table{
  width: 45vw;
  margin-left: 4vw;
}

.demo-pagination-block{
  margin-top: 10px;
  float: left ;
  margin-left: 4vw;
}
.demo-pagination-block .demonstration {
  margin-bottom: 16px;
}

</style>