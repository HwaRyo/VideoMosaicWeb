<template>
<<<<<<< HEAD
<table class="info">
  <colgroup>
    <col class="title">
    <col class="creater">
    <col class="createDate">
    <col class="modifiedDate">
  </colgroup>
  <thead>
    <tr>
      <th>제목</th>
      <th>작성자</th>
      <th>생성일</th>
      <th>수정일</th>
    </tr>
  </thead>
  <tbody>
        <td>{{datas.title}}</td>
        <td>운영자</td>
        <td>{{datas.createdDate}}</td>
        <td>{{datas.modifiedDate}}</td>
  </tbody>
</table>
  <table class="infotwo">
    <thead class="contents">
        <tr>
          <th class="contents">내용</th>
        </tr>
    </thead>
      <tbody>
        <td>{{datas.content}}</td>
      </tbody>
</table>	
<div class="back">
    <button class="backbtn btn-2" @click="moveBoardList()">목록으로 돌아가기</button>	
</div>

=======
<div>
    <div class="bdlist">
		<div class="AddWrap">
			<form>
				<table class="tbAdd">
					<colgroup>
						<col width="15%" />
						<col width="*" />
					</colgroup>
                <thead>
                    <tr>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>생성일</th>
                        <th>수정일</th>
                    </tr>
                </thead>

                <tbody>
                        <td>{{datas.title}}</td>
                        <td>관리자</td>
                        <td>{{datas.createdDate}}</td>
                        <td>{{datas.modifiedDate}}</td>
                </tbody>
                <thead>
                    <tr>
                        <th colspan="4">내용</th>
                    </tr>
                </thead>
                <tbody>
                        <td colspan="4">{{datas.content}}</td>
                </tbody>
				</table>
			</form>
		</div>	
        <div class="btnWrap">
			<a href="/" class="btn">목록</a>
		</div>	
	</div>
>>>>>>> YH

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
    data(){
        return{
            datas: [],
        };
    },
    mounted(){
      this.read();
    },
    methods:{
        read(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            console.log(this.$route.params.id)
            const url = 'http://localhost:8080/board/read?id='+this.$route.params.id;
            this.axios({
                method: 'get',
                url: url,
                headers: headers,
            })
            .then((res) => {
                this.datas = res.data;
                console.log('axios get success', res.data);
            }).catch((err) =>{
                console.log('err',err);
            })
        },
        moveBoardList(){
            location.href = "/BoardList";
        }
    },
  
}
</script>

<style>
/* 테이블 색상 (중요하지 않음) */
.info {
  width: 80%;
  margin: 40px auto 0px;
  border-collapse: collapse;
}
.infotwo{
  width: 80%;
  margin: 0px auto 0px;
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
.title {width: 43%;}
.creater {width: 20%;}
.createdate {width: 5%;}
.modifieddate {width: 5%;}


/* 컬럼의 정렬 */
tr td:nth-child(1){text-align:center;}
tr td:nth-child(2){text-align:center;}
tr td:nth-child(3){text-align:center;}
tr td:nth-child(4){text-align:center;}

/*목록 버튼*/
.back {
  text-align: center;
  margin: 40px;
}
.backbtn {
  width: 200px;
  height: 40px;
  color: #fff;
  border-radius: 5px;
  padding: 10px 25px;
  font-family: 'Lato', sans-serif;
  font-weight: 500;
  background: transparent;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
}
.btn-2 {
  background: rgb(34, 40, 49);
  background: linear-gradient(0deg, rgb(34, 40, 49)) 0%, rgb(34, 40, 49) 100%;
  border: none;
  
}
.btn-2:before {
  height: 0%;
  width: 2px;
}
.btn-2:hover {
  box-shadow:  4px 4px 6px 0 rgba(255,255,255,.5),
              -4px -4px 6px 0 rgba(116, 125, 136, .5), 
    inset -4px -4px 6px 0 rgba(255,255,255,.2),
    inset 4px 4px 6px 0 rgba(0, 0, 0, .4);
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