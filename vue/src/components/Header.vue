<template>
	<div class="hold">
    <div class="header">
      <ul class="navlg" @click="moveHome()">
         <li><a>MOSAIC WEB</a></li>
        </ul>
          <ul class="nav">
            <div v-if="!this.$store.getters['token/getIsLogin']" class="headerItem" >
            <li><a href="/Login">로그인</a></li>
            </div>
            <div v-else class="headerItem" @click="handleLogout">
              <li><a class="">로그아웃</a></li>
            </div>
            <div class="headerItem">
            <li><a href="/BoardList">공지사항</a></li>
            </div>
          </ul>
      </div>
  </div>
</template>

<script>
export default {
  name: 'Header',
  methods: {
      handleLogout() {
          localStorage.removeItem("token");
          this
              .$store
              .dispatch('token/setToken', false);
          this
              .$store
              .dispatch('token/setIsLogin', false);
          this
              .$router
              .push("/");
      },
      moveHome() {
      this.$router.push('/');
      document.getElementsByClassName("detail-menu")[0].style.display = 'none';
    }
  },
}
</script>

<style>
div.headerItem {
  float: right;
}
 

ul.navlg {
  float: left;
    list-style: none;
    margin: 0;
    padding: 5;

}

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
  width: 100%;
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
/*
  Header
*/

.hold {
  height: 80px;
}

.header {
  line-height: 77px;
  width: 100%;
  transition: line-height 0.2s linear, box-shadow 0.2s linear;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 100;
  background: rgba(245, 245, 245, 0.97);
}

.header.small {
  line-height: 50px;
  box-shadow: 0px 1px 3px 0px rgba(50, 50, 50, 0.8);
}

.header.small > .container > #logo {
  height: 30px;
}

.logo {
  position: absolute;
  top: 30%;
  text-decoration: none;
  transform: translateY(-50%);
  float: left;
  height: 40px;
  width: 170px;
  margin-left: 20px;
}

ul.nav {
  float: right;
  list-style: none;
  margin: 0;
  padding: 5;
}

ul.nav li {
  float: left;
  position: relative;
}

ul.nav li a {
  transition: color 0.2s linear;
  font-size: 18px;
}

ul.nav li:hover a {
  color: rgb(51, 124, 252);
}

ul.nav li a {
  padding: 21px;
  color: initial;
  text-decoration: initial;
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