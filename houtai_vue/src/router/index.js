import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/pc/Login.vue'
import pHome from '../components/pc/pHome.vue'
import Welcome from '../components/pc/Welcome.vue'
import stuInfo from '../components/pc/stuInfo.vue'
import teacherInfo from '../components/pc/teacherInfo.vue'
import bkInfo from '../components/pc/bkInfo.vue'
import accountInfo from '../components/pc/accountInfo.vue'
import classInfo from '../components/pc/classInfo.vue'
import upload from '../components/upload.vue'
Vue.use(VueRouter)

const routes = [{
    path: '/',
    redirect: '/login'
}, {
    path: '/login',
    name: 'Login',
    component: Login
}, {
    path: '/phome',
    component: pHome,
    children: [{
        path: '/phome',
        component: Welcome
    }, {
        path: '/bkInfo',
        name: 'bkInfo',
        component: bkInfo
    }, {
        path: '/stuInfo',
        component: stuInfo
    }, {
        path: '/teacherInfo',
        component: teacherInfo
    }, {
        path: '/accountInfo',
        component: accountInfo
    }, {
        path: '/classInfo',
        component: classInfo
    }, {
        path: '/upload',
        component: upload
    }, ]
}]

const router = new VueRouter({
    routes
})

router.beforeEach((to, from, next) => {
    if (to.path === '/login') return next()
    const userInfo = window.sessionStorage.getItem('userInfo')
    if (!userInfo) return next('/login')
    next()
})

export default router