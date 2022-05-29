<template>
<div class="container">
  <div class="dan-up-vid">
    <div class="dan-video">
    <input
      class="dan-up-vid-input"
      type="file"
      name="dan-up-vid-input"
      @change="onChangevid"
      accept="video/mp4,video/mkv,"
    />
    <div v-show="files.length === 0" class="dan-up-vid-body">
      <div class="dan-up-vid-image">
        <img width="200" height="200" src="../assets/video.png" />
      </div>
      <p class="dan-up-vid-sub-text">영상을 여기에 끌어다 놓으세요!</p>
    </div>
    <div v-show="files.length > 0" class="dan-up-vid-back-body">
      <div
        class="dan-up-vid-file-name"
        :key="index"
        v-for="(fil, index) in files"
      >
        <img width="30" :src="fil.img" />
        {{ limitStr(fil.file.name, 15) }}
        <button
          class="dan-up-vid-button"
          :id="fil.id"
          @click="eliminatevid(fil.id)"
        >
          x
        </button>
      </div>
    </div>
    </div>
<!--얼굴 업로드 동영상 첨부 존-->
    <div class="dan-facevideo">
    <input
      class="dan-up-vid-input"
      type="file"
      name="dan-up-vid-inputt"
      @change="onChangevid"
      accept="video/mp4,video/mkv,"
    />
    <div v-show="files.length === 0" class="dan-up-vid-body">
      <div class="dan-up-vid-image">
        <img width="200" src="../assets/video.png" />
      </div>
      <p class="dan-up-vid-sub-text">영상을 이곳에 끌어다 놓으세요!</p>
      
    </div>
    <div v-show="files.length > 0" class="dan-up-vid-back-body">
      <div
        class="dan-up-vid-file-name"
        :key="index"
        v-for="(fil, index) in files"
      >
        <img width="30" :src="fil.img" />
        {{ limitStr(fil.file.name, 15) }}
        <button
          class="dan-up-vid-button"
          :id="fil.id"
          @click="eliminatevid(fil.id)"
        >
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
                <p class="side">유일하게 모자이크 처리 되지 않을 본인의 얼굴이 확실히 나오는 동영상을 첨부해주세요.</p>
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
                <p class="side">모자이크가 완료된 영상을 다운로드 받기 위해 창을 홈으로 이동해주세요.</p>
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
      file: null,
      files: this.dataFile,
    };
  },
  watch: {
    files(newF) {
      if (newF.length === 0) {
        this.$emit("up-show", false);
        console.log("this, watch file void", newF);
      }
    },
  },
  props: {
    dataFile: {
      type: Array,
      default: () => [],
      required: false,
    },
  },
  methods: {
    elim() {
      this.files = [];
      this.file = null;
    },
    eliminatevid(eliminate) {
      let newFiles = this.files.filter((x) => {
        if (x.id !== eliminate) {
          return x;
        }
      });
      console.log("new", newFiles);
      this.files = newFiles;
    },
    onChangevid(e) {
      let dataImg = null;
      for (let i = 0; i < e.target.files.length; i++) {
        this.file = e.target.files[i];
        dataImg = URL.createObjectURL(this.file);
        this.files.push({ id: i, file: this.file, img: dataImg });
      }
      console.log(this.files);
      this.$emit("file-up", this.files);
    },
    limitStr(string, limit) {
      let str = string;
      this.$emit("up-show", true);
      if (typeof str === "string" && str.length > limit) {
        str = str.slice(0, limit) + "...";
      }

      return str;
    },
  },
 
};
</script>

<style>

.dan-facevideo {
 border-radius: 15px;
  border: 3px dashed lightblue;
  width: 50%;
  height: 250px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  transition: background 0.8s;
  cursor: pointer;
  position: relative;
  background: rgb(173, 216, 230, 0.2);
}


.dan-video {
 border-radius: 15px;
  border: 3px dashed lightblue;
  width: 100%;
  height: 250px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  transition: background 0.8s;
  cursor: pointer;
  position: relative;
  background: rgb(173, 216, 230, 0.2);
}
.dan-up-vid {
  display: flex;
}
.dan-up-vid-body{
  align-items: center;
}
.dan-facevideo:hover {
  transition: background 0.1s;
  background: rgb(173, 216, 230, 0.5);
}
.dan-video:hover {
  transition: background 0.1s;
  background: rgb(173, 216, 230, 0.5);
}
.dan-up-vid-input {
  cursor: pointer;
  position: absolute;
  width: 100%;
  height: 100%;
  z-index: 1;
  /*Opacity settings for all browsers*/
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
  font-weight: 400;
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
  top: -10px;
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
  padding: 0 0%;
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
</style>

  