<template>
<div class="wrap">
    <button v-on:click="insert()">등록</button>
    <button v-on:click="index()">목록</button>
    <table>
        <thead>
            <tr>
                <th>No.</th>
                <th>게시글</th>
                <th>콘텐츠</th>
                <th>업로드날짜</th>
                <th>수정날짜</th>
            </tr>
        </thead>

        <tbody>
            <tr class="content" @click="move()" v-for="(v, i) in datas" :key="i">
                <td>{{i+1}}</td>
                <td>{{v.title}}</td>
                <td>{{v.content}}</td>
                <td>{{v.createDate}}</td>
                <td>{{v.modifiedDate}}</td>
            </tr>
        </tbody>
    </table>
</div>
</template>
<script>
export default {
    name: 'VideoDownload',
    data(){
        return{
            datas: [],
        }
    },
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
            console.log(Token)
            const url = 'http://localhost:8080/indexboard';
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
        move(){
            location.href = "/";
        }
    },
};
</script>