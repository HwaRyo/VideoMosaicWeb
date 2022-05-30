<template>
  <div class="dan-up-vid">
    <div class="dan-video">
    <input
      class="dan-up-vid-input"
      type="file"
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

    <div class="dan-facevideo">
    <input
      class="dan-up-vid-input"
      type="file"
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




<div class="section bg">
    <div class="container">
        <h1>사용방법</h1>
        <div class="col two bg margin extrapad">
        <h1 class="icon side">1</h1>
        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
                    </div>
                    <div class="col two bg margin extrapad">
                        <h1 class="icon side">2</h1>
                        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
                    </div>
                    <div class="group margin"></div>
                    <div class="col two bg margin extrapad">
                        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
                    </div>
                    <div class="col two bg margin extrapad">
                        <h1 class="icon side">4</h1>
                        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
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
  width: 500px;
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
  width: 750px;
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
</style>

  