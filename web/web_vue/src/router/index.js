import Vue from 'vue'
import Router from 'vue-router'
import stuList from '@/views/user/stuList'
// import HomeView from '../views/HomeView.vue'

Vue.use(Router)


export default new Router({
  routes: [
    {
      path: '/user/stuList',
      name: 'stuList',
      component: stuList
    }
  ]
})
