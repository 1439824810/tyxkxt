import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import axios from 'axios'
// axios.defaults.baseURL = 'http://192.168.31.39:8000/tyxkxt/'
axios.defaults.baseURL = 'https://yu423.mynatapp.cc/tyxkxt/'
Vue.prototype.$http = axios
Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')