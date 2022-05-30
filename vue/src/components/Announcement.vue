<template>
  <div class="announcement">
<<<<<<< HEAD
    <button v-on:click="test()">등록</button>
  </div>
</template>


<script>
export default {
    name: 'VideoDownload',
    methods:{
        test(){
=======
    <input type="button" value="파일 업로드" @click="test"/>
  </div>
</template>

<script>
export default {
  name: 'Header',
  methods: {
    test(){
>>>>>>> main
            const Token = localStorage.getItem('token');
            const headers = {
                'Authorization': 'Bearer '+Token
            }
            console.log(Token)
<<<<<<< HEAD
            const url = 'http://localhost:8080/upload2';
=======
            const url = 'http://localhost:8080/upload';
>>>>>>> main
            this.axios({
                method: 'get',
                url: url,
                headers: headers,
            })
            .then(({data}) => {
<<<<<<< HEAD
=======
                this.datas = data
>>>>>>> main
                console.log('axios get success', data);
            }).catch((err) =>{
                console.log('err',err);
            })
        },
<<<<<<< HEAD
    },
};
=======
  },
}
>>>>>>> main
</script>
