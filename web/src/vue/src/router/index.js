import { createRouter, createWebHistory } from 'vue-router'



const routes = [
  // {
    //     path: '/',
    //     name: 'App',
    //     component: () => import('@/App')
    // },
  {
    path: '/',
    name: 'Home',
    component: () => import('@/components/Home')
    },
  {
    path: '/about',
    name: 'About',
    component: () => import('@/components/About')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/components/Login')
  },
  {
    path: '/fileupload',
    name: 'FileUpload',
    component: () => import('@/components/FileUpload')
  },
  {
    path: '/filedownload',
    name: 'FileDownload',
    component: () => import('@/components/FileDownload')
  },
  {
    path: '/announcement',
    name: 'Announcement',
    component: () => import('@/components/Announcement')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
