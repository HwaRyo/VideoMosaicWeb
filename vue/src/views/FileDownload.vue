<template>
<table class="dllist">
  <colgroup>
    <col class="check">
    <col class="title">
    <col class="createDate">
    <col class="modifiedDate">
  </colgroup>
  <thead>
    <tr>
      <th>체크</th>
      <th>제목</th>
      <th>생성날짜(yyMMdd)</th>
      <th>생성시간(HHmmss)</th>
    </tr>
  </thead>
  <tbody>
    <tr class="content" v-for="(v, i) in datas" :key="i">
      <td><input type="radio" name="chkVideo" v-model="picked" :value="v"></td>
      <td>모자이크 비디오{{i}}</td>
      <td>{{v.substring(0,6)}}</td>
      <td>{{v.substring(7,13)}}</td>
    </tr>
  </tbody>
</table>
<div class="download">
    <button class="downloadbtn btn-1" v-on:click="download()"><span>Click!</span><span>다운로드</span></button>	
</div>
<div class="section bg">
        <div class="container">
            <h1>사용방법</h1>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">1</h1>
                <span class="feature side">동영상 고르기</span>
                <p class="side">다운로드를 원하시는 영상을 골라주세요. </p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">2</h1>
                <span class="feature side">동영상 체크하기</span>
                <p class="side">고른 영상을 체크박스에 체크해주세요.</p>
            </div>
            <div class="group margin"></div>
            <div class="col two bg margin extrapad">
               <h1 class="icon side">3</h1>
                <span class="feature side">다운로드 하기</span>
                <p class="side">다운로드 버튼을 클릭하여 다운로드해주세요.</p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">4</h1>
                <span class="feature side">확인하기</span>
                <p class="side">파일이 다운로드 되었는지 확인해주세요.</p>
            </div>
            <div class="group"></div>
        </div>
  </div>


 <div class="section">
        <div class="container">
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



</template>
<script>
export default {
    name: 'VideoDownload',
     data(){
        return{
            datas: [],
            picked: "",
            pageNum: 0
        }
    },mounted(){
      this.list();
    },
    methods:{
        download(){
            if(this.picked!=""){
                const FileDownload = require('js-file-download');
                const Token = localStorage.getItem('token');
                const headers = {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer '+Token
                }
                const url = 'http://localhost:8080/video/download?fileName='+this.picked.replace(".mp4","");
                console.log('url',url);

                this.axios({
                    method: 'get',
                    url: url,
                    responseType: 'blob',  
                    headers: headers
                })
                .then(({data}) => {
                    FileDownload(data, this.picked);
                    console.log('axios get success', data);
                }).catch((err) =>{
                    console.log('err',err);
                })
            }
        },
         list(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            const url = 'http://localhost:8080/video/download/list';
            console.log('url',url);
            console.log('Token',Token); 
            this.axios({
                method: 'get',
                url: url,
                headers: headers
            })
            .then(({data}) => {
                this.datas=data;
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
        }
    },
};
</script>

<style>
/* 테이블 색상 (중요하지 않음) */
.dllist {
  width: 80%;
  margin: 40px auto 0px;
  border-collapse: collapse;
}
th {
  background: rgb(34, 40, 49);
  color: #fff;
}
td, th {
  border: 1px solid #dbdbdb;
  padding: 5px 20px;
  font-size:16px;
  text-align: center;
}
tr:nth-of-type(odd) { 
	background: #eee; 
}


/* 컬럼의 너비 */
.check {width: 5%;}
.title {width: 70%;}
.createdate {width: 5%;}
.modifieddate {width: 5%;}


/* 컬럼의 정렬 */
tr td:nth-child(1){text-align:center;}
tr td:nth-child(2){text-align:center;}
tr td:nth-child(3){text-align:center;}
tr td:nth-child(4){text-align:center;}

/*목록 버튼*/
.download {
  text-align: center;
  margin:40px;
}
.downloadbtn {
  color:#fff
}
.btn-1{
  position: relative;
  right: 20px;
  bottom: 20px;
  border:none;
  box-shadow: none;
  width: 130px;
  height: 40px;
  line-height: 42px;
  -webkit-perspective: 230px;
  perspective: 230px;
}
.btn-1 span {
  background: rgb(70, 70, 70);
background: linear-gradient(0deg, rgb(49, 49, 49) 0%, rgb(83, 83, 83) 100%);
  display: block;
  position: absolute;
  width: 130px;
  height: 40px;
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  border-radius: 5px;
  margin:0;
  text-align: center;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all .3s;
  transition: all .3s;
}
.btn-1 span:nth-child(1) {
  box-shadow:
   -7px -7px 20px 0px #fff9,
   -4px -4px 5px 0px #fff9,
   7px 7px 20px 0px #0002,
   4px 4px 5px 0px #0001;
  -webkit-transform: rotateX(90deg);
  -moz-transform: rotateX(90deg);
  transform: rotateX(90deg);
  -webkit-transform-origin: 50% 50% -20px;
  -moz-transform-origin: 50% 50% -20px;
  transform-origin: 50% 50% -20px;
}
.btn-1 span:nth-child(2) {
  -webkit-transform: rotateX(0deg);
  -moz-transform: rotateX(0deg);
  transform: rotateX(0deg);
  -webkit-transform-origin: 50% 50% -20px;
  -moz-transform-origin: 50% 50% -20px;
  transform-origin: 50% 50% -20px;
}
.btn-1:hover span:nth-child(1) {
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  -webkit-transform: rotateX(0deg);
  -moz-transform: rotateX(0deg);
  transform: rotateX(0deg);
}
.btn-1:hover span:nth-child(2) {
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
 color: transparent;
  -webkit-transform: rotateX(-90deg);
  -moz-transform: rotateX(-90deg);
  transform: rotateX(-90deg);
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