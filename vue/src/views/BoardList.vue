<template>
<div class="section">
    <div class="slider">
      <div class="container slidercontent">
        <h1 class="hero">FAQ(자주 묻는 질문)
        </h1>
        <h2 class="hero">웹에 대한 궁금증을 풀어보세요!</h2>
      </div>
    </div>     
  </div>
  <table>
  <colgroup>
    <col class="number">
    <col class="title">
    <col class="writer">
    <col class="createDate">
    <col class="modifiedDate">
  </colgroup>
  <thead>
    <tr>
      <th>No</th>
      <th>제목</th>
      <th>생성날짜</th>
      <th>수정날짜</th>
    </tr>
  </thead>
  <tbody>
    <tr class="content" @click="move(v.id)" v-for="(v, i) in datas" :key="i">
      <td>{{i+1}}</td>
      <td>{{v.title}}</td>
      <td>{{v.createdDate}}</td>
      <td>{{v.modifiedDate}}</td>
    </tr>
  </tbody>
</table>
 <div class="section">
        <div class="container">
            <div class="col two">
                <h1 class="icon">[]</h1>
                <h1 class="service">FAQ</h1>
                <p>사용자분들이 자주 묻는 질문 모음입니다. </p>
            </div>
            <div class="col two">
                <h1 class="icon">[]</h1>
                <h1 class="service">고객센터</h1>
                <p>해결되지 않는 사항은 010-1234-5678로 연락바랍니다. </p>
            </div>
            <div class="group"></div>
        </div>
    </div>

</template>

<script> 
export default {
  name: 'boardlist',
    data(){
        return{
            datas: [],
            pageNum: 0
        }
    },
    props: {
      listArray:{
        type: Array,
        required: true
      },
    pageSize: {
      type: Number,
      required: false,
      default: 5
      }
    },
    mounted(){
      this.index();
    },
    methods:{
      index(){
          const Token = localStorage.getItem('token');
          const headers = {
              'Authorization': 'Bearer '+Token
          }
          console.log(Token)
          const url = 'http://localhost:8080/board/index';
          this.axios({
              method: 'get',
              url: url,
              headers: headers,
          })
          .then(({data}) => {
              this.datas = data
              console.log('axios get success', data);
          }).catch((err) =>{
              console.log('err',err);
          })
      },
      move(x){
        this.$router.push({
          name: 'boarddetail',
          params: { id: x }
        })
      }
    }
 }

</script>

<style>
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}

tr.content {
  text-decoration: none;
  color: #333;
}
tr.content:hover {color: #6199ff;}



/* 테이블 색상 (중요하지 않음) */
table {
  width: 80%;
  margin: 40px auto 10px;
  border-collapse: collapse;
}
th {
  background: rgb(34, 40, 49);
  color: #fff;
}
td, th {
  border: 2px solid #dbdbdb;
  padding: 5px 30px;
  font-size:16px;
}
tr:nth-of-type(odd) { 
	background: #eee; 
}

/* 컬럼의 너비 */
.number {width: 3%;}
.title {width: 63%;}
.writer {width: 10%;}
.createdate {width: 5%;}
.modifieddate {width: 5%;}

/* 컬럼의 정렬 */
tr td:nth-child(1){text-align:center;}
tr td:nth-child(2){text-align:center;}
tr td:nth-child(3){text-align:center;}
tr td:nth-child(4){text-align:center;}
tr td:nth-child(5){text-align:center;}

/* 페이징 버튼 */
.page-box {
  width: 80%;
  margin: 5px auto;
  height: 30px;
  text-align: center;
}
.page-box a.btn {
  display:inline-block;
  padding: 3px 5px;
  font-size: 10px;
  border: 1px solid #dbdbdb;
  color: #333;
}
.page-box a.btn.on {
  background-color: #dbdbdb;
}


.container {
  position: relative;
  width: 100%;
  margin: 0 auto;
  font-size: 14px;
  font-weight: 300;
  font-family: 'Nanum Gothic Coding', monospace;
  overflow: hidden;
  
}

.section .container {
  padding: 30px 0 30px 0;
  
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
  background: rgba(221,221,221);
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
  background-image: linear-gradient(to bottom right, #2252b1, #dc4225);
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

</style>
