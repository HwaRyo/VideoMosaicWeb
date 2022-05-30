<template>
<div class="wrap">
    <button v-on:click="download()">다운로드</button>
    <button v-on:click="list()">리스트</button>
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
            const url = 'http://localhost:8080/video/download?fileName=220530_033548';
            console.log('url',url);

            this.axios({
                method: 'get',
                url: url,
                responseType: 'blob',  
                headers: headers
            })
            .then(({data}) => {
                FileDownload(data, "mosaic.mp4");
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
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