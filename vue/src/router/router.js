import {createWebHistory, createRouter} from 'vue-router';

const routes = [
    {
        path: '/login',
        name: 'login',
        component: () => import ('@/components/login')
    }, {
        path: '/oauth2/redirect',
        name: 'oauthHandler',
        component: () => import ('@/components/oauthHandler')
    }, {
        path: '/profile',
        name: 'profile',
        component: () => import ('@/components/profile')
    }, {
        path: '/download',
        name: 'videoDownload',
        component: () => import ('@/components/videoDownload')
    }, {
        path: '/',
        name: 'home',
        component: () => import ('@/components/home')
    }, {
        path: '/about',
        name: 'about',
        component: () => import ('@/components/about')
    }, {
        path: '/fileupload',
        name: 'fileUpload',
        component: () => import ('@/components/fileUpload')
    }, {
        path: '/filedownload',
        name: 'fileDownload',
        component: () => import ('@/components/fileDownload')
    }, {
        path: '/announcement',
        name: 'announcement',
        component: () => import ('@/components/announcement')
    }
];

export const router = createRouter({history: createWebHistory(), routes})

export default router