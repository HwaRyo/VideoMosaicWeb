<template>
<div>
</div>
</template>

<script>
// import { onMounted } from '@vue/runtime-core'
// import useRoute from 'vue-router'
// import {useStore} from "vuex"

export default {
    name: 'OauthHandler',
    methods: {
    moveHome(){
                location.href = "/";
            }
},
    mounted(){
        const url = this.$route.fullPath;
        const slice = url.split("token=");
        const token = slice[1];
        // 분기처리 
        // token 존재 => /profile
        // error 존재 => /
        if(token){
            this.$store.dispatch('token/setToken', token);
            localStorage.setItem('token', token);
            this.$store.dispatch('token/setIsLogin', true);
            console.log(this.$store.getters['token/getToken']);
            
            this.$router.push({name: 'home'});
        }else{
            this.$router.push('/');
        }
    }

    // setup() {
    //     const router = useRoute();    
    //     const store = useStore();
        
    //     onMounted(() => {
    //         const url = router.fullPath;
    //         const slice = url.split("token=");
    //         const token = slice[1];
            
    //         // 분기처리 
    //         // token 존재 => /profile
    //         // error 존재 => /
    //         if(token){
    //             store.dispatch('token/setToken', token);
    //             localStorage.setItem('token', token);
    //             store.dispatch('token/setIsLogin', true);
    //             console.log(store.getters['token/getToken']);
                
    //             router.replace('/profile');
    //         }else{
    //             router.replace('/');
    //         }
    //     })
    //     return{
    //         router,
    //         store
    //     }
    // },
}

</script>

<style>
.homebtn{
  background-color: #fa4e22;
  border-radius: 15px;
  border: none;
  opacity: 0.4;
  color: rgb(226, 226, 226);
  padding: 30px 70px;
  text-align: center;
  font-size: 25px;
  margin: 20px 2px;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  
}
.homebtn:hover {opacity: 1}

.sec .loginlogo {
    background: #f8a251;
}
    

    /*
  Slider
*/

.section .slider,
.section .footer {
  background: rgb(117, 150, 241);
}

.slidercontent {
  text-align: center;
}


.hero {
  color: white;
  font-weight: normal;
  letter-spacing: 1px;
}

h1.hero {
  font-size: 54px;
}

h2.hero {
  font-size: 30px;
  margin-bottom: 60px;
}

h1.hero:after {
  content: "";
  width: 300px;
  position: relative;
  border-bottom: 1px solid #aaa;
  text-align: center;
  margin: auto;
  margin-top: 15px;
}

.call {
  color: white;
  display: block;
  margin-bottom: 20px;
}

.call span {
  display: inline;
  border: 1px solid white;
  text-decoration: none;
  padding: 8px 13px;
  font-size: 20px;
  transition: background 0.15s linear;
}

.call span:hover {
  background: rgba(255, 255, 255, 0.1);
  cursor: pointer;
}
/* 
  Columns 
*/

.col {
  float: left;
  padding: 0;
  margin: 0;
  position: relative;
}

.col.four {
  width: 23%;
  margin: 0 1%;
}

.col.three {
  width: 31.3%;
  margin: 0 1%;
}

.col.two {
  width: 40%;
  margin: 0 2.5%;
  padding: 0 2.5%;
}

.col.extrapad {
  padding-top: 20px;
  padding-bottom: 20px;
}
.col.five {
  width: 2424%;
  margin: 0 1%;
  float: right;
}

.col .service,
.col .feature {
  font-size: 21px;
  font-weight: 300;
}

.col .service:after {
  content: "";
  width: 50px;
  position: relative;
  border-bottom: 1px solid #eee;
  display: block;
  text-align: center;
  margin: auto;
  margin-top: 15px;
}

.col .feature {
  font-size: 19px;
}

.col h1.side,
.col p.side,
.col span.side:first-of-type {
  margin-left: 50px;
  text-align: left;
}

.col .icon {
  border-radius: 50%;
  height: 85px;
  width: 85px;
  line-height: 85px;
  text-align: center;
  margin: 0 auto;
  transition: background 0.25s linear, color 0.25s linear;
}

.col .icon.side {
  position: absolute;
  padding: 0;
  margin: 0;
  top: -15px;
  height: 50px;
  width: 50px;
}

.col:hover > .icon {
  background: #F44336;
  color: white;
}

.col:hover > .icon.side {
  background: initial;
  color: initial;
}

.responsivegroup {
  display: none;
}
/*
  Column specifics
*/

.col p,
.col h1 {
  padding: 0 1%;
  text-align: center;
}

.group.margin {
  margin-bottom: 20px;
}


.col.bg {
  background: rgb(231, 234, 255);
}

.col.pointer {
  cursor: pointer;
}

.col span.feature {
  font-size: 20px;
}
/*
  Text
*/

.container > h1:not(.hero) {
  margin-bottom: 30px;
  text-align: center;
}

.container > h1:after {
  content: "";
  width: 30px;
  position: relative;
  border-bottom: 1px solid #aaa;
  display: block;
  text-align: center;
  margin: auto;
  margin-top: 15px;
}

h2 {

  text-align: center;
  font-weight: 400;
  font-size: 18px;
}

.left,
.left > h1,
.left > p {
  text-align: left;
}

.reset {
  text-align: left !important;
}

.reset:after {
  display: none !important;
}
/* 
  Slider with Content
*/

.white h1,
.white p,
.white div,
.white a {
  color: #fff;
}
/*
  Responsive
*/

.group:after {
  content: "";
  display: table;
  clear: both;
}

@media all and (max-width: 768px) {
  .container {
    width: 95%;
  }
  .col.four {
    width: 48%;
    margin: 1%;
  }
  .col.three {
    display: block;
    width: 95%;
    padding: 0;
    margin: 0 auto;
    float: none;
  }
  .header {
    height: auto;
    background: #eee;
  }
  #logo {
    position: initial;
    float: none;
    display: block;
    transform: none;
    margin: 10px auto 0 auto;
    text-decoration: none;
  }
  ul.nav {
    float: none;
    display: block;
    text-align: center;
    margin: 0 auto;
  }
  ul.nav li {
   
    display: inline-block;
  }
  .responsivegroup {
    display: block;
  }
  .responsivegroup:after {
    content: "";
    display: table;
    clear: both;
  }
}

@media all and (min-width: 768px) {
  .container {
    width: 750px;
  }
}

@media all and (min-width: 992px) {
  .container {
    width: 970px;
  }
}

@media all and (min-width: 1200px) {
  .container {
    width: 1170px;
  }
}

@media all and (max-width:450px) {
  .col, .col.four, .col.three, .col.two {
    display: block;
    width: 95%;
    padding: 0;
    margin: 0 auto;
    float: none;
  }
  .col.extrapad {
    padding: 1%;
    margin-bottom: 10px;
  }
  .group {
    display: none;
  }
}
</style>
