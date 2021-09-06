import './assets/css/common.css'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import Vue from 'vue'

import axios from 'axios'
// 设置一下根url，改这个和upload.vue里的链接地址
// 因为加入了企业微信，所以必须加这个https的链接
var baseURL = "https://yu423.mynatapp.cc/tyxkxt/"
axios.defaults.baseURL = baseURL
    // axios.interceptors.request.use(config => {
    //     config.headers.token = window.sessionStorage.getItem('token')
    //     return config
    // })
Vue.prototype.$http = axios

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')