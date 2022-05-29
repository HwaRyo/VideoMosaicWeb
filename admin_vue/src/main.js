import { createApp } from 'vue'
import App from './App.vue'

// import axios from 'axios';
import router from './router';  //라우터 추가

import store from './store'
// import store from "./store";        //vuex 추가

const app = createApp(App).use(store);
// app.use(VueAxios, axios);
app.use(router);
// app.use(store);
app.mount('#app');