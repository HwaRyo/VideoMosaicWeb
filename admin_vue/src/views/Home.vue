<template>
<div>
    <div class="section">
        <div class="slider">
            <div class="container slidercontent">
                <h1 class="hero">영상 얼굴 인식 모자이크 웹</h1>
                <h2 class="hero">체험해보세요!</h2>
                <input type="button" value="파일 업로드" @click="moveUpload"/>
                <input type="button" value="파일 다운로드" @click="moveDownload"/>
            </div>
        </div>
    </div>

    <div class="section bg">
        <div class="container">
            <h1>사용방법</h1>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">1</h1>
                <span class="feature side">영상선택하기</span>
                <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">2</h1>
                <span class="feature side">설명</span>
                <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
            </div>
            <div class="group margin"></div>
            <div class="col two bg margin extrapad">
                <span class="feature side">설명</span>
                <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
            </div>
            <div class="col two bg margin extrapad">
                <h1 class="icon side">4</h1>
                <span class="feature side">설명</span>
                <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
            </div>
            <div class="group"></div>
        </div>
    </div>

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
    export default {
        name: 'Home',
        methods: {
            moveUpload(){
                if(!this.$store.getters['token/getIsLogin']){
                    alert("로그인을 진행해주세요!");
                }else{
                    location.href = "/fileupload"; 
                }             
            },
            moveDownload(){
                if(!this.$store.getters['token/getIsLogin']){
                    alert("로그인을 진행해주세요!");
                }else{
                    location.href = "/filedownload"; 
                }             
            }
        }
    }
</script>

    <style></style>