import './assets/main.css'
import 'element-plus/theme-chalk/dark/css-vars.css'
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import router from '@/router/index.js'
import { createPinia } from 'pinia'
import { createPersistedState } from 'pinia-persistedstate-plugin'
const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }

const pinia=createPinia();
const persist= createPersistedState();

app.use(ElementPlus)
app.use(router)
app.use(pinia)
pinia.use(persist)
// app.use(clipboard);
app.mount('#app')
