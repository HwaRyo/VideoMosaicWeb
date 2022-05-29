<template>
  <div class="announcement">
<<<<<<< HEAD
    <input type="button" value="파일 업로드" @click="test"/>
  </div>
</template>

<script>
export default {
  name: 'Header',
  methods: {
    test(){
=======
    <button v-on:click="test()">등록</button>
  </div>
</template>


<script>
export default {
    name: 'VideoDownload',
    methods:{
        test(){
>>>>>>> web
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            console.log(Token)
<<<<<<< HEAD
            const url = 'http://localhost:8080/upload';
=======
            const url = 'http://localhost:8080/upload2';
>>>>>>> web
            this.axios({
                method: 'get',
                url: url,
                headers: headers,
            })
            .then(({data}) => {
<<<<<<< HEAD
                this.datas = data
=======
>>>>>>> web
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
        },
<<<<<<< HEAD
  },
}
=======
    },
};
>>>>>>> web
</script>
