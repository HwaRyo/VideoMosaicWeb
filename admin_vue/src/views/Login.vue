<template>
<div>
    <input v-model="currentYear" placeholder="ID">
    <input v-model="pw" placeholder="PW">
    <button @click="Login()">로그인</button>
</div>
</template>

<script>
    export default {
        name: 'Login',
         data() {
        return {
            id: "",
            pw: "",
        };
    },
    methods: {
        Login(){
        const url = 'http://localhost:8080/adminlogin';
        this.axios({
            method: 'post',
            url: url,
            data:{
                id:"test",
                pw:"test"
            }
        })
        .then(({data}) => {
            console.log('axios get success', data);
        }).catch((err) =>{
            console.log('err',err);
        })
        }
    }
}
</script>

    <style></style>