<template>
  <Header />

 <router-view></router-view>
  <Footer />
</template>

<script>
import Header from '@/components/Header'; //import 헤더 추가
import Footer from '@/components/Footer'; //import 풋터 추가
<<<<<<< HEAD

=======
>>>>>>> web
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





</style>