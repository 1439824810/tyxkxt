import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: 'Home',
    component: () =>
        import ('../views/Home.vue')
}, {
    path: '/teacherinfo',
    name: 'teacherinfo',
    component: () =>
        import ('../views/TeacherInfo.vue')
}, {
    path: '/classinfo',
    name: 'classinfo',
    component: () =>
        import ('../views/ClassInfo.vue')
}, {
    path: '/xk',
    name: 'xk',
    component: () =>
        import ('../views/xk.vue')
}, {
    path: '/xkinfo',
    name: 'xkinfo',
    component: () =>
        import ('../views/xkinfo.vue')
}, ]

const router = new VueRouter({
    routes
})

export default router