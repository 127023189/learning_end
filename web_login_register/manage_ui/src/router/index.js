import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '@/views/userLogin'
import register from '@/views/userRegister'
import userSuccess from '@/views/userSuccess'

Vue.use(VueRouter)

export default new VueRouter({
  routes:[{
    path:'/login',
    name:'login',
    component:login
  },
  {
    path:'/register',
    name:'register',
    component:register
  },
  {
    path:'/success',
    name:'success',
    component:userSuccess
  }
]
})