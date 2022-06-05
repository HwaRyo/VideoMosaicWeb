<template>
<div class="uploadzone">
  <div class="dan-up-vid">
<!--모자이크 할 영상 업로드 존-->
    <div class="dan-video">
      <input  class="dan-up-vid-input" type="file" name="dan-up-vid-input" @change="onChangevid1" accept="video/mp4,video/mkv,"/>
        <div v-show="files1.length === 0" class="dan-up-vid-body">
          <div class="dan-up-vid-image">
            <img width="200" height="200" src="../assets/video.png" />
          </div>
          <p class="dan-up-vid-sub-text">모자이크 할 동영상을 여기에 끌어다 놓으세요!</p>
        </div>
        
      <div v-show="files1.length > 0" class="dan-up-vid-back-body">
        <div class="dan-up-vid-file-name" :key="index" v-for="(fil, index) in files1">
          <!--<img width="30" :src="fil.vid" />-->
          {{ limitStr1(fil.file.name, 30) }}
          <button class="dan-up-vid-button" :id="fil.id" @click="eliminatevid1(fil.id)">
            x
          </button>
        </div>
      </div>
    </div>
    <!--업로드 버튼-->
  <div class="dan-uploadbtn">
    <button class="uploadbtn" v-on:click="upload()">
      <svg width="110.687px" height="90px" viewBox="-352.439 -334.975 110.687 90">
        <path id="shape" class="cloud" fill="none" stroke="rgba(191,191,191,1)" stroke-width="5" stroke-miterlimit="10" d="M-326.444-305.524
        c-12.976,0-23.495,10.529-23.495,23.504c0,12.976,10.519,23.495,23.495,23.495h45.217c20.421,0,36.975-16.554,36.975-36.975
        s-16.554-36.975-36.975-36.975c-16.942,0-31.213,11.408-35.586,26.951H-326.444z"/>
        <path class="cloud loader" fill="none" stroke="rgba(191,191,191,1)" stroke-width="5" stroke-miterlimit="10" d="M-326.444-305.524
        c-12.976,0-23.495,10.529-23.495,23.504c0,12.976,10.519,23.495,23.495,23.495h45.217c20.421,0,36.975-16.554,36.975-36.975
        s-16.554-36.975-36.975-36.975c-16.942,0-31.213,11.408-35.586,26.951H-326.444z"/>
      </svg>
      <p class="upload">업로드</p>
    </button>
  </div>
<!--얼굴 업로드 동영상 첨부 존-->
    <div class="dan-facevideo">
      <input class="dan-up-vid-input" type="file" name="dan-up-vid-input" @change="onChangevid2" accept="video/mp4,video/mkv,"/>
        <div v-show="files2.length === 0" class="dan-up-vid-body">
          <div class="dan-up-vid-image">
            <img width="200" src="../assets/video.png" />
          </div>
          <p class="dan-up-vid-sub-text">본인 얼굴 동영상을 이곳에 끌어다 놓으세요!</p>
        </div>
      <div v-show="files2.length > 0" class="dan-up-vid-back-body">
        <div class="dan-up-vid-file-name" :key="index" v-for="(fil, index) in files2">
          <!-- <img width="30" :src="fil.img" /> -->
          {{ limitStr2(fil.file.name, 30) }}
          <button class="dan-up-vid-button" :id="fil.id" @click="eliminatevid2(fil.id)">
            x
          </button>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="section bg">
        <div class="container">
            <h1>사용방법</h1>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">1</h1>
                <span class="feature side">모자이크 할 동영상 업로드</span>
                <p class="side">상단의 왼쪽 구역에 모자이크 할 동영상을 첨부해주세요.</p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">2</h1>
                <span class="feature side">본인 얼굴 동영상 업로드</span>
                <p class="side">본인의 얼굴이 확실히 나오는 동영상을 첨부해주세요.</p>
            </div>
            <div class="group margin"></div>
            <div class="col two bg margin extrapad">
               <h1 class="icon side">3</h1>
                <span class="feature side">확인하기</span>
                <p class="side">올바른 동영상을 넣었는지 제목과 함께 확인해주세요.</p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">4</h1>
                <span class="feature side">다운로드</span>
                <p class="side">모자이크가 완료된 영상을 다운로드 받기 위해 홈으로 이동해주세요.</p>
            </div>
            <div class="group"></div>
        </div>
    </div>
        

</template>

<script>

export default {
  name: "DanUpvid",
  data() {
    return {
      file1: null,
      files1: this.dataFile1,
      file2: null,
      files2: this.dataFile2,
    };
  },
  watch: {
    files1(newF) {
      if (newF.length === 0) {
        this.$emit("up-show", false);
        console.log("this, watch file void", newF);
      }
    },
    files2(newF) {
      if (newF.length === 0) {
        this.$emit("up-show", false);
        console.log("this, watch file void", newF);
      }
    },
  },
  props: {
    dataFile1: {
      type: Array,
      default: () => [],
      required: false,
    },
    dataFile2: {
      type: Array,
      default: () => [],
      required: false,
      
    },
  },
  methods: {
    elim1() {
      this.files1 = [];
      this.file1 = null;
    },
    elim2() {
      this.files2 = [];
      this.file2 = null;
    },
    eliminatevid1(eliminate) {
      let newFiles = this.files1.filter((x) => {
        if (x.id !== eliminate) {
          return x;
        }
      });
      console.log("new", newFiles);
      this.files1 = newFiles;
      this.file1=null;
    },
    eliminatevid2(eliminate) {
      let newFiles = this.files2.filter((x) => {
        if (x.id !== eliminate) {
          return x;
        }
      });
      console.log("new", newFiles);
      this.files2 = newFiles;
      this.file2=null;
    },
   
    onChangevid1(e) {
      if(this.file1!=null){
        alert("하나의 파일만 업로드해주세요.")
      }else{
        let dataImg = null;
        for (let i = 0; i < e.target.files.length; i++) {
          this.file1 = e.target.files[0];
          e.target.value = '';
          dataImg = URL.createObjectURL(this.file1);
          this.files1.push({ id: i, file: this.file1, img: dataImg });
        }
        console.log(this.files1);
        this.$emit("file-up", this.files1);
      }
    },

    onChangevid2(e) {
       if(this.file2!=null){
        alert("하나의 파일만 업로드해주세요.")
      }else{
        let dataImg = null;
        for (let i = 0; i < e.target.files.length; i++) {
          this.file2 = e.target.files[0];
          e.target.value = '';
          dataImg = URL.createObjectURL(this.file2);
          this.files2.push({ id: i, file: this.file2, img: dataImg });
        }
        console.log(this.files2);
        this.$emit("file-up", this.files2);
      }
    },

    limitStr1(string, limit) {
      let str = string;
      this.$emit("up-show", true);
      if (typeof str === "string" && str.length > limit) {
        str = str.slice(0, limit) + "...";
      }

      return str;
    },
    limitStr2(string, limit) {
      let str = string;
      this.$emit("up-show", true);
      if (typeof str === "string" && str.length > limit) {
        str = str.slice(0, limit) + "...";
      }

      return str;
    },
    upload(){
            var result = confirm("파일을 업로드 하시겠습니까?");
            if (result){
              if(this.file1==null||this.file2==null){
                alert("파일을 전부 업로드 해주세요!");
              }else{
                const Token = localStorage.getItem('token');
                const headers = {
                  'Authorization': 'Bearer '+Token,
                  'Content-Type': 'multipart/form-data'
                }
                const url = 'http://localhost:8080/video/upload';
                console.log('url',url);

                var frm = new FormData();
                frm.append("video", this.file1);
                frm.append("face", this.file2);

                this.axios({
                  method: 'post',
                  url: url,
                  headers: headers,
                  data: frm
                })
                .then(({data}) => {
                    console.log('axios get success', data);
                    alert("성공적으로 업로드 되었습니다! ")
                }).catch((err) =>{
                    console.log('err',err);
                    alert("업로드가 실패했습니다! ")
                })
              }
            }
        }, 
  },
 
};
</script>

<style>
.hold {
  height: 60px;

  
}

.dan-uploadbtn {
  border: 3px dashed #000;
  background:rgba(255, 255, 255, 0.822)
}

.dan-uploadbtn:hover {
  transition: background 0.5s;
  background: rgba(0, 0, 0, 0.822);
}

.dan-video {
  width: 50%;
  height: 250px;
  display: flex;
  flex-direction: column;
  align-items: center;
  transition: background 0.5s;
  justify-content: center;
  cursor: pointer;
  position: relative;
  background:rgba(135, 135, 135, 0.822);
}

.dan-facevideo {
  width: 50%;
  height: 250px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  transition: background 0.8s;
  cursor: pointer;
  position: relative;
  background:rgba(135, 135, 135, 0.822)
}

.dan-up-vid {
  display: flex;
  width:100%;
  height:50%;
  
}
.dan-up-vid-body{
  align-items: center;
}
.dan-facevideo:hover {
  opacity: 1;
}
.dan-video:hover {
  opacity: 1
}
.dan-up-vid-input {
  cursor: pointer;
  position: absolute;
  width: 100%;
  height: 100%;
  z-index: 1;
  opacity: 0;
  -moz-opacity: 0;
  filter: progid:DXImageTransform.Microsoft.Alpha(opacity=0);
}
.dan-up-vid-button {
  position: absolute;
  z-index: 2;
  font-weight: 600;
  background: rgb(255, 55, 75);
  border-radius: 50%;
  border: none;
  margin: 0px 5px;
  width: 25px;
  height: 25px;
  color: white;
}
.dan-up-vid-button:focus {
  outline-width: 0px;
}
.dan-up-vid-file-name {
  margin: 5px;
}

.dan-up-vid-back-body {
   display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: flex-end;
  position: absolute;
  z-index: 2;
}
.dan-up-vid-buttom-div {
  margin-top: 10px;
}

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap');
.uploadzone {
  position: relative;
  width: 100%;
  margin: 0 auto;
  font-size: 14px;
  font-weight: 300;
  font-family: 'Nanum Gothic Coding', monospace;
  overflow: hidden;
  
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
  color:rgb(255, 255, 255); 
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
  반응형
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


/*업로드 버튼*/

body button {
  margin: 0 auto;
  position: relative;
  transform: translateY(-50%);
  top: 50%;
  border: 0;
  background-color: transparent;
  cursor: pointer;
}

body button p {
  color: #bfbfbf;
  font-family: "PT Sans", sans-serif;
  font-size: 12px;
  letter-spacing: 4px;
  text-indent: 4px;
  margin: 0 auto;
  text-align: center;
  line-height: 20px;
  margin-top: 5px;
}
body button:focus {
  outline: 0;
}

body button .loader {
  stroke: #ffffff;
  opacity: 0;
  stroke-DashArray: 232;
  transition: opacity 0s;
}
body button .complete {
  opacity: 0;
}
body button #shape, body button .arrow line, body button p {
  transition: color 0.3s,  stroke 0.3s,  letter-spacing 0.3s, font-size 0.3s, text-indent 0.3s;
}


body button:hover #shape {
  stroke: #ffffff;
  transition: stroke 0.3s;
}
body button:hover p{
  letter-spacing: 6px;
  color: #ffffff;
  font-size: 19px;
  text-indent: 6px;
}

</style>

  