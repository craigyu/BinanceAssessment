// main.ts
import { createApp } from 'vue'
import './main.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/display.css'
import App from './App.vue'

const app = createApp(App)
app.config.devtools = true

app.use(ElementPlus)
app.mount('#app')
