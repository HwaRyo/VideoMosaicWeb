<template>
<div class="wrap">
    <button v-on:click="insert()">등록</button>
    <button v-on:click="index()">목록</button>
</div>
</template>
<script>
export default {
    name: 'VideoDownload',
    methods:{
         insert(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            const url = 'http://localhost:8080/insert';
            this.axios({
                method: 'post',
                url: url,
                headers: headers,
                data:{
                    title:"asdasd",
                    content:"asdasd"
                }
            })
            .then(({data}) => {
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
        },
        index(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            const url = 'http://localhost:8080/indexboard';
            this.axios({
                method: 'get',
                url: url,
                headers: headers,
            })
            .then(({data}) => {
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
        }
    },
};
</script>