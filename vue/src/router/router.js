import {createWebHistory, createRouter} from 'vue-router';

const routes = [
    {
        path: '/login',
        name: 'login',
        component: () => import ('@/components/Login')
    }, {
        path: '/oauth2/redirect',
        name: 'oauthHandler',
        component: () => import ('@/components/OauthHandler')
    }, {
        path: '/profile',
        name: 'profile',
        component: () => import ('@/components/Profile')
    }, {
        path: '/download',
        name: 'videoDownload',
        component: () => import ('@/components/videoDownload')
    }, {
        path: '/',
        name: 'home',
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
];

export const router = createRouter({history: createWebHistory(), routes})

export default router