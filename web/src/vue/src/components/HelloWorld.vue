<template>
<!-- eslint-disable vue/no-use-v-if-with-v-for,vue/no-confusing-v-for-v-if -->
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
        <button @click="login()">로그인</button>
    </div>
</template>

<script>
/* eslint-disable */
export default {
    data() {
        return {
            id: "",
            pw: "",
        };
    },
    methods: {
        fileupload() {
            var result = confirm("파일을 업로드 하시겠습니까?");
            if (result){
                var frm = new FormData();
                var excelFile = document.getElementById("excel");
                frm.append("excel", excelFile.files[0]);
                frm.append("file_title",this.fileTitle);
                frm.append("force_main_type",this.currentForce);
                frm.append("force_sid_type",this.currentDetail);
                frm.append("year",this.currentYear);
                frm.append("seasoncode",this.currentSeason);
                this.$axios.post('/api/cm/upload', frm, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    },
                })
                .then((response) => {
                    // 응답 처리
                    alert("파일 업로드에 성공하였습니다!");
                })
                .catch((error) => {
                    // 예외 처리
                    alert("파일 업로드에 실패하였습니다..");
                })
            }
        },
    },
};
</script>


<style scoped>
.container{
  display: flex;
  flex-direction: column;
}
.header a{
    font-weight: bold;
    font-size: medium;
    color: darkolivegreen;
    margin-bottom: 20px;
}
a{
    padding: 10px;
    font-size: large;
}
select{
    margin: 5px;
    height: 30px;
    text-align: center;
    font-size: large;
}
input{
    margin: 5px;
    height: 30px;
    text-align: center;
    font-size: large;
}
button{
    font-size: large;
}
.force-wrapper{
    margin-bottom: 20px;
}
.detail-wrapper{
    margin-bottom: 20px;
}
.upload{
    margin-bottom: 20px;
    height: 40px;
}
.file-title{
    margin-bottom: 20px;
}
.start-year{
    margin-bottom: 20px;
}
</style>