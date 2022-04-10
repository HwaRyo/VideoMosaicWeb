<template>
<div class="wrap">
    <button v-on:click="download()">다운로드</button>
    <img ref="uploadItemImage">
</div>
</template>
<script>
import axios from 'axios';
export default {
    name: 'VideoDownload',
    methods:{
        download(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer '+Token
            }
            const url = 'http://localhost:8080/download';
            console.log('url',url);

            axios({
                method: 'get',
                url: url,
                responseType: 'blob',  
                headers: headers
            })
            .then(({data}) => {
                let itemImage = this.$refs.uploadItemImage;
                itemImage.src = window.URL.createObjectURL(data);
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
            }
    },
};
</script>