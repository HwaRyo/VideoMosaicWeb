import {createWebHistory, createRouter} from 'vue-router';

const routes = [
    {
        path: '/login',
        name: 'login',
        component: () => import ('@/views/Login')
    }, {
        path: '/oauth2/redirect',
        name: 'oauthHandler',
        component: () => import ('@/views/OauthHandler')
    }, {
        path: '/profile',
        name: 'profile',
        component: () => import ('@/views/Profile')
    }, {
        path: '/download',
        name: 'videoDownload',
        component: () => import ('@/views/VideoDownload')
    }, {
        path: '/',
        name: 'home',
        component: () => import ('@/views/Home')
    }, {
        path: '/about',
        name: 'about',
        component: () => import ('@/views/About')
    }, {
        path: '/fileupload',
        name: 'fileUpload',
        component: () => import ('@/views/FileUpload')
    }, {
        path: '/filedownload',
        name: 'fileDownload',
        component: () => import ('@/views/FileDownload')
    }, {
        path: '/announcement',
        name: 'announcement',
        component: () => import ('@/views/Announcement')
    }
];

export const router = createRouter({history: createWebHistory(), routes})

export default router