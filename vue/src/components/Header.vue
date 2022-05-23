<template>
	<div class="hold">
  <div class="header">
        <a href="/" class = "headerItem">MOSAIC WEB</a>
          <div v-if="!this.$store.getters['token/getIsLogin']" class="headerItem" >
            <a href="/login">로그인</a>
          </div>
          <div v-else class="headerItem" @click="handleLogout">
              <p class=""><b>로그아웃</b></p>
          </div>
        <a href="/announcement" class="headerItem">공지사항</a>
  </div>
</div>
</template>

<script>
export default {
  name: 'Header',
  methods: {
      handleLogout() {
          localStorage.removeItem("token");
          this
              .$store
              .dispatch('token/setToken', false);
          this
              .$store
              .dispatch('token/setIsLogin', false);
          this
              .$router
              .push("/");
      }
  },
}
</script>

<style>
div.headerItem {
  float: right;

}

</style>