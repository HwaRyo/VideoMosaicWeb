<template>
  <Header />

 <router-view></router-view>
  <Footer />
</template>

<script>
import Header from '@/components/Header'; //import 헤더 추가
import Footer from '@/components/Footer'; //import 풋터 추가
import { onMounted } from '@vue/runtime-core'
import {computed} from 'vue';
import {useStore} from 'vuex';


window.onscroll = function() {
  var el = document.getElementsByClassName('header')[0];
  var className = 'small';
  if (el.classList) {
    if (window.scrollY > 10)
      el.classList.add(className);
    else
      el.classList.remove(className);
  }
};

export default {
  name: 'app',
  components: {
    Header          //헤더 컴포넌트 추가
    ,Footer         //풋터 컴포넌트 추가
    
  },

  setup(){
    const store = useStore();
    
    var isLogin = computed(() => store.getters['token/getIsLogin']);
    
    onMounted(() => {
      if(localStorage.getItem("token")){
        store.dispatch('token/setIsLogin', true);
      }else{
        store.dispatch('token/setIsLogin', false);
      }
    })

    return{
      isLogin
    }
  },
}

window.onscroll = function() {
  var el = document.getElementsByClassName('header')[0];
  var className = 'small';
  if (el.classList) {
    if (window.scrollY > 10)
      el.classList.add(className);
    else
      el.classList.remove(className);
  }
};
</script>
  
  

<style>
a {
  text-decoration: none;
  cursor: pointer;
  color: #444;
  font-size: 24px;
  font-weight: 350;
  font-family: 'Roboto Slab', sans-serif;
}
body {
  margin: 0;
  padding: 0;
}

.fw {
  text-decoration: none;
  color:white;
  cursor:pointer;
}

.fg {
  text-decoration: none;
  color:white;
  cursor:pointer;
}
.section {
  width: 100%;
}

.container {
  position: relative;
  width: 1170px;
  margin: 0 auto;
  color: #444;
  font-size: 14px;
  font-weight: 300;
  font-family: Roboto, 'Open Sans', Arial, sans-serif;
  overflow: hidden;
}

.section .container {
  padding: 10px 0 10px 0;
}

.section.bg {
  background: #c5d3fc;
}




</style>