<template>
<div class="wrap">
    <button v-on:click="download()">다운로드</button>
    <button v-on:click="upload()">업로드</button>
</div>
</template>
<script>
export default {
    name: 'VideoDownload',
    methods:{
        download(){
            const FileDownload = require('js-file-download');
            const Token = localStorage.getItem('token');
            const headers = {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer '+Token
            }
            const url = 'http://localhost:8080/download';
            console.log('url',url);

            this.axios({
                method: 'get',
                url: url,
                responseType: 'blob',  
                headers: headers
            })
            .then(({data}) => {
                FileDownload(data, "test.mp4");
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
        },
         upload(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            const url = 'http://localhost:8080/upload';
            console.log('url',url);

            this.axios({
                method: 'get',
                url: url,
                headers: headers
            })
            .then(({data}) => {
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
        },
    },
};
</script>
<style>

</style>