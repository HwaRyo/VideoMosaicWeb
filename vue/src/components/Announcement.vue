<template>
  <div class="announcement">
    <input type="button" value="파일 업로드" @click="test"/>
  </div>
</template>

<script>
export default {
  name: 'Header',
  methods: {
    test(){
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            console.log(Token)
            const url = 'http://localhost:8080/upload';
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
  },
}
</script>
