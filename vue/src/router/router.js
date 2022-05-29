import {createWebHistory, createRouter} from 'vue-router';

const routes = [
    {
        path: '/login',
        name: 'login',
<<<<<<< HEAD
        component: () => import ('@/components/Login')
    }, {
        path: '/oauth2/redirect',
        name: 'oauthHandler',
        component: () => import ('@/components/OauthHandler')
    }, {
        path: '/profile',
        name: 'profile',
        component: () => import ('@/components/Profile')
=======
        component: () => import ('@/views/Login')
    }, {
        path: '/oauth2/redirect',
        name: 'oauthHandler',
        component: () => import ('@/views/OauthHandler')
    }, {
        path: '/profile',
        name: 'profile',
        component: () => import ('@/views/Profile')
>>>>>>> web
    }, {
        path: '/download',
        name: 'videoDownload',
        component: () => import ('@/views/VideoDownload')
    }, {
        path: '/',
        name: 'home',
<<<<<<< HEAD
        component: () => import ('@/components/Home')
    }, {
        path: '/about',
        name: 'about',
        component: () => import ('@/components/About')
    }, {
        path: '/fileupload',
        name: 'fileUpload',
        component: () => import ('@/components/FileUpload')
    }, {
        path: '/filedownload',
        name: 'fileDownload',
        component: () => import ('@/components/FileDownload')
    }, {
        path: '/announcement',
        name: 'announcement',
        component: () => import ('@/components/Announcement')
    }
=======
        component: () => import ('@/views/Home')
    }, {
        path: '/fileupload',
        name: 'fileUpload',
        component: () => import ('@/views/FileUpload')
    }, {
        path: '/filedownload',
        name: 'fileDownload',
        component: () => import ('@/views/FileDownload')
    }, {
        path: '/boardlist',
        name: 'boardlist',
        component: () => import ('@/views/BoardList')
    }, {
        path: '/boarddetail',
        name: 'boarddetail',
        component: () => import ('@/views/BoardDetail')
    },

>>>>>>> web
];

export const router = createRouter({history: createWebHistory(), routes})
export default router