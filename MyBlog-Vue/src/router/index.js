import { createRouter,createWebHistory } from "vue-router";
import LoginVue from '../views/Login.vue'
import RegisterVue from '../views/Register.vue'
import AdminVue from'../views/Admin.vue'
import ArticlesVue from '../views/Articles.vue'
import ArticleVue from '../views/Article.vue'
import MassageVue from '../views/Massage.vue'
import IndexVue from '../views/Index.vue'
import TimerShaftVue from '../views/TimerShaft.vue'
import FriendLinkVue from '../views/FriendLink.vue'
import AboutVue from '../views/About.vue'

const routes=[
    {path:'/',component: IndexVue},
    {path:'/login',component: LoginVue},
    {path:'/register',component: RegisterVue},
    {path:'/admin',component: AdminVue},
    {path:'/articles', component: ArticlesVue 
    // ,redirect: '/articles/article',
    // children:[{path:"/articles/article", component: ArticleVue}]
    },
    {path:'/massage', component :MassageVue},
    {path:'/timerShaft',component: TimerShaftVue},
    {path:'/friendLink',component: FriendLinkVue},
    {path:'/about',component: AboutVue}
]

const router=createRouter({
    history: createWebHistory(),
    routes: routes
});

export default router;