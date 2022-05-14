import {createWebHistory, createRouter} from 'vue-router';

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: () => import ('@/components/Login')
    }, {
        path: '/oauth2/redirect',
        name: 'OauthHandler',
        component: () => import ('@/components/OauthHandler')
    }, {
        path: '/profile',
        name: 'Profile',
        component: () => import ('@/components/Profile')
    }, {
        path: '/download',
        name: 'VideoDownload',
        component: () => import ('@/views/VideoDownload')
    }, {
        path: '/',
        name: 'Home',
        component: () => import ('@/components/Home')
    }, {
        path: '/about',
        name: 'About',
        component: () => import ('@/components/About')
    }, {
        path: '/fileupload',
        name: 'FileUpload',
        component: () => import ('@/components/FileUpload')
    }, {
        path: '/filedownload',
        name: 'FileDownload',
        component: () => import ('@/components/FileDownload')
    }, {
        path: '/announcement',
        name: 'Announcement',
        component: () => import ('@/components/Announcement')
    }
];

export const router = createRouter({history: createWebHistory(), routes})

export default router