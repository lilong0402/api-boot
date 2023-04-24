import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Index from '@/views/index.vue'
import Login from '@/views/login/index.vue'
import NotFound from '@/views/404.vue'

const routes =[
  {
    path: '/',
    name: 'index',
    component: Index
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },{
    path: '/:pathMatch(.*)*',
    name: 'home',
    component: NotFound
  },
] 

const router = createRouter({
  routes,
  history: createWebHistory()
})

export default router
