<template>
<div>
    <div class="sec">
        <div class="loginlogo">
            <div class="container slidercontent">
                <h1 class="hero">소셜 로그인</h1>
                <h2 class="hero">구글 계정과 연동하여 로그인하세요!</h2>
            </div>
        </div>
    </div>

   <div class="wrap">
    <div v-if="!this.$store.getters['token/getIsLogin']" class="google-btn" @click="sendGoogleUrl">
        <div class="google-icon-wrapper">
            <img class="google-icon" src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"/>
        </div>
        <p class="btn-text"><b>Sign in with google</b></p>
    </div>
</div>
<br><br><br><br><br><br>

 <div class="section">
        <div class="container">
            <div class="col two">
                <h1 class="icon">[]</h1>
                <h1 class="service">설명</h1>
                <p>설명 설명 설명 설명 설명 설명 설명 설명 설명 설명 설명 설명</p>
            </div>
            <div class="col two">
                <h1 class="icon">[]</h1>
                <h1 class="service">설명</h1>
                <p>설명 설명 설명 설명 설명 설명 설명 설명 설명 설명 설명 설명</p>
            </div>
            <div class="group"></div>
        </div>
    </div>
</div>
</template>
<script>
    import {computed} from 'vue';
    import {useStore} from 'vuex';
    import {reactive} from '@vue/reactivity';
    import googleLogo from '.././assets/google-logo.png';
    export default {
        name: 'Login',
        methods: {
        },
        setup() {
            const store = useStore();
            const state = reactive({
                googleUrl: 'http://localhost:8080/oauth2/authorize/google?redirect_uri=http://localhost:80' +
                        '81/oauth2/redirect',
                googleImage: googleLogo,
                response: ''
            })

            const isLogin = computed(() => store.getters['token/getToken']);
            const sendGoogleUrl = () => {
                console.log('sendGoogleUrl');
                location.href = state.googleUrl;
            }
            return {state, isLogin, sendGoogleUrl}
        }
    };
</script>
<style >
    .sec .loginlogo {
        background: #f8a251;
    }
    .wrap {
        width: 100%;
        height: 100%;
    }
    .google-btn {
        width: 240px;
        height: 55px;
        background-color: #f17909;
        border-radius: 2px;
        box-shadow: 0 3px 4px 0 rgba(0,0,0,.25);
        margin: 50px auto 0;
    }
    .google-btn-login {
        width: 240px;
        height: 55px;
        background-color: #fff;
        border-radius: 2px;
        box-shadow: 0 3px 4px 0 rgba(0,0,0,.25);
        margin: 50px auto 0;
    }
    .google-icon-wrapper {
        position: absolute;
        margin-top: 1px;
        margin-left: 1px;
        width: 53px;
        height: 53px;
        border-radius: 2px;
        background-color: #f17909;
    }
    .google-icon {
        position: absolute;
        margin-top: 18px;
        margin-right: 18px;
        width: 24px;
        height: 24px;
    }
    .btn-text {
        float: right;
        margin: 18px 18px 0 0;
        color: #fff;
        font-size: 17px;
        letter-spacing: 0.2px;
        font-family: "Roboto";
    }
    .btn-text-login {
        float: center;
        margin: 18px 18px 0 0;
        color: #4285f4;
        font-size: 17px;
        letter-spacing: 0.2px;
        font-family: "Roboto";
    }
    .google-btn:hover {
        box-shadow: 0 0 6px #4285f4;
    }
    .google-btn:active {
        background: #1669F2;
    }
    .google-btn-login:hover {
        box-shadow: 0 0 6px #4285f4;
    }
    .google-btn-login:active {
        background: #1669F2;
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
  font-family: 'Roboto Slab', sans-serif;
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
  font-family: 'Roboto Slab', sans-serif;
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
  font-family: 'Roboto Slab', sans-serif;
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