<template>
<div class="bg-img">
    <div class="section">
        <div class="slider">
            <div class="container slidercontent">
                <h1 class="hero">영상 얼굴 인식 모자이크 웹</h1>
                <h2 class="hero">체험해보세요!</h2>
                <input type="button" class="uploadbtn" value="파일 업로드" @click="moveUpload"/>
                <input type="button" class="downloadbtn" value="파일 다운로드" @click="moveDownload"/>
                <br><br>
            </div>
        </div>
    </div>
    <div class="section bg">
        <div class="container">
            <h1>사용방법</h1>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">1</h1>
                <span class="feature side">메인 동영상 준비</span>
                <p class="side">얼굴을 자동으로 모자이크 할 영상파일을 준비하세요.</p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">2</h1>
                <span class="feature side">본인 얼굴 영상 준비</span>
                <p class="side">본인 얼굴이 확실하게 인식될 수 있는 영상 파일을 준비하세요.</p>
            </div>
            <div class="group margin"></div>
            <div class="col two bg margin extrapad">
               <h1 class="icon side">3</h1>
                <span class="feature side">동영상 파일 업로드</span>
                <p class="side">준비한 2가지의 영상을 파일 업로드 버튼을 누르셔서 첨부해주세요.</p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">4</h1>
                <span class="feature side">모자이크(업로드) 완료된 영상 다운로드</span>
                <p class="side">모자이크가 완료된 영상을 파일 다운로드 버튼을 누르셔서 다운받으세요.</p>
            </div>
            <div class="group"></div>
        </div>
    </div>

    <div class="section">
        <div class="containertwo">
            <div class="col two">
                <h1 class="icon">[]</h1>
                <h1 class="service">자동 모자이크 서비스</h1>
                <p>간편한 자동 모자이크 서비스로 일찍 퇴근 완료!</p>
            </div>
            <div class="col two">
                <h1 class="icon">[]</h1>
                <h1 class="service">서버 기반 서비스</h1>
                <p>느릿느릿한 컴퓨터로 편집은 이제 그만!</p>
            </div>
            <div class="group"></div>
        </div>
    </div>
</div>
</template>

<script>
    export default {
        name: 'Home',
        methods: {
            moveUpload(){
                location.href = "/fileupload";
            },
            moveDownload(){
                location.href = "/filedownload";
            }

            /*moveUpload(){
                if(!this.$store.getters['token/getIsLogin']){
                    alert("로그인을 진행해주세요!");
                }else{
                    location.href = "/FileUpload"; 
                }             
            },
            moveDownload(){
                if(!this.$store.getters['token/getIsLogin']){
                    alert("로그인을 진행해주세요!");
                }else{
                    location.href = "/FileDownload"; 
                }
            }*/
            
        }
    }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap');

.uploadbtn{
  background-image: linear-gradient(to bottom right, #cdcbcb, #eae9e9);
  border-radius: 15px;
  border: none;
  opacity: 0.4;
  color: rgb(0, 0, 0);
  padding: 30px 70px;
  text-align: center;
  font-size: 25px;
  margin: 4px 2px;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  box-shadow: 0 5px 18px -7px rgba(0,0,0,1);
  
}
.uploadbtn:hover {opacity: 1}

.downloadbtn{
  background-image: linear-gradient(to bottom right, #cdcbcb, #eae9e9);
  border-radius: 15px;
  border: none;
  opacity: 0.4;
   color: rgb(0, 0, 0);
  padding: 30px 57px;
  text-align: center;
  font-size: 25px;
  margin: 4px 2px;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  box-shadow: 0 5px 18px -7px rgba(0,0,0,1);
  
}
.downloadbtn:hover {opacity: 1}


body {
  margin: 0;
  padding: 0;
  background: url('http://unsplash.it/1200x800') 
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
	background-position: center;
	background-repeat: repeat;
	background-size: 7%;
	background-color: #fff;
	overflow-x: hidden;
  transition: all 200ms linear;
  

}

.container {
  position: relative;
  width: 100%;
  margin: 0 auto;
  font-size: 14px;
  font-weight: 300;
  font-family: 'Nanum Gothic Coding', monospace;
  overflow: hidden;
  padding:30px 0 30px 0;
  
}

.section .containertwo {
  padding: 30px 0 30px 0;
  background:rgba(236, 235, 235, 0.564)
  
  
}

.section.bg {
  background: rgb(255, 255, 255)
  
}
/*
  Slider
*/

.section .slider {
  background: rgb(34, 40, 49);
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



.col.three {
  width: 31.3%;
  margin: 0 1%;
}

.col.two {
  width: 40%;
  margin: 0 2.5%;
  padding: 0 2.5%;
  background: rgb(221, 221, 221);
  border-radius: 10px;
  box-shadow: 0 5px 18px -7px rgba(0,0,0,1);

}

.col.extrapad {
  padding-top: 20px;
  padding-bottom: 20px;
   color: rgba(255, 255, 255, 0.771);
}
.col.five {
  width: 2424%;
  margin: 0 1%;
  float: right;
}

.col .service,
.col .feature {
  font-size: 21px;
  font-weight: 700;
  color:#000; 
  
}

.col .service:after {
  content: "";
  width: 50px;
  position: relative;
  border-bottom: 1px solid rgb(0, 0, 0);
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
  color:#000;
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
  top: -11px;
  height: 50px;
  width: 50px;
}





.responsivegroup {
  display: none;
}
/*
  Column specifics
*/

.col p,
.col h1 {
  padding: 0 0%;
  text-align: center;
}

.group.margin {
  margin-bottom: 20px;
}


.col.bg {
  background-image: rgb(221, 221, 221);
  border-radius: 10px;
}

.col.pointer {
  cursor: pointer;
}

.col span.feature {
  font-size: 25px;
  font-weight: 400;
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
    width: 100%;
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
    width: 100%;
  }
}

@media all and (min-width: 992px) {
  .container {
    width: 100%;
  }
}

@media all and (min-width: 1100px) {
  .container {
    width: 100%;
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