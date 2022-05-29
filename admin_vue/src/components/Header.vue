<template>
  <div class="hold">
    <div class="header">
      <div class="header">
        <div class="container">
          <a href="/" class="al">MOSAIC WEB</a>
          <ul class="nav">
            <div
              v-if="!this.$store.getters['token/getIsLogin']"
              class="headerItem"
            >
              <li><a href="/login">로그인</a></li>
            </div>
            <div v-else class="headerItem" @click="handleLogout">
              <li><a class="">로그아웃</a></li>
            </div>
            <li><a href="/Announcement">공지사항</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  methods: {
    handleLogout() {
      localStorage.removeItem("token");
      this.$store.dispatch("token/setToken", false);
      this.$store.dispatch("token/setIsLogin", false);
      this.$router.push("/");
    },
  },
};
</script>

<style>
div.headerItem {
  float: right;
}
</style>
