<template>
  <div class="announcement">
    <button v-on:click="test()">등록</button>
  </div>
</template>


<script>
export default {
    name: 'VideoDownload',
    methods:{
        test(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            console.log(Token)
            const url = 'http://localhost:8080/upload2';
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
        },
    },
};
</script>
