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
        path: '/download',
        name: 'videoDownload',
        component: () => import ('@/views/VideoDownload')
    }, {
        path: '/',
        name: 'home',
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
];

export const router = createRouter({history: createWebHistory(), routes})
export default router