<template>
    <div class="header">
			<a>로그인</a>
        <div class="id">
            <a>아이디</a>
            <input v-model="id" required minlength="1" maxlength="50" placeholder="ID">
        </div>
        <div class="pw">
            <a>비밀번호</a>
            <input v-model="pw" required minlength="1" maxlength="50" placeholder="PW">
        </div>
        <a href="http://localhost:8080/oauth2/authorization/google">
        <button>로그인</button>
        </a>
        <a href="http://localhost:8080/logout">
        <button>로그아웃</button>
        </a>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            id: "",
            pw: "",
        };
    },
    methods: {
        login(){
           axios.get('/login').then(function(response) {
            console.log(response);
            })
            .catch(function(error) {
            console.log(error);
            });
        },
        logout(){
           axios.get('/logout').then(function(response) {
            console.log(response);
            })
            .catch(function(error) {
            console.log(error);
            });
        },
        // fileupload() {
        //     var result = confirm("파일을 업로드 하시겠습니까?");
        //     if (result){
        //         var frm = new FormData();
        //         var excelFile = document.getElementById("excel");
        //         frm.append("excel", excelFile.files[0]);
        //         frm.append("file_title",this.fileTitle);
        //         frm.append("force_main_type",this.currentForce);
        //         frm.append("force_sid_type",this.currentDetail);
        //         frm.append("year",this.currentYear);
        //         frm.append("seasoncode",this.currentSeason);
        //         this.$axios.post('/api/cm/upload', frm, {
        //             headers: {
        //                 'Content-Type': 'multipart/form-data'
        //             },
        //         })
        //         .then((response) => {
        //             // 응답 처리
        //             alert("파일 업로드에 성공하였습니다!");
        //         })
        //         .catch((error) => {
        //             // 예외 처리
        //             alert("파일 업로드에 실패하였습니다..");
        //         })
        //     }
        // },
    },
}
</script>