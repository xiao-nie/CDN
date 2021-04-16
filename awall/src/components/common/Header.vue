<template>
  <div class="header">
    <div class="contain">
      <!--上面的logo-->
      <a href="#/">
        <div class="logo">
          <img width="45" src="@/assets/icon/logo.svg">
          <div class="right"><span>墙墙君</span></div>
        </div>
      </a>
      <!--导航栏中间部分-->
      <div class="body">
        <!--搜索栏-->
        <div class="search left">
          <input type="text" placeholder="想要搜些啥?">
          <div class="search-icon">
            <img width="25" height="25" src="@/assets/icon/搜索.svg">
          </div>
        </div>
        <!--导航栏-->
        <div class="navs">
          <ul>
            <li>
              <div class="item">
                <font-awesome-icon :icon="['fas','home']"></font-awesome-icon>首页
              </div>
            </li>
            <li>
              <div class="item">
                <font-awesome-icon :icon="['fas','home']"></font-awesome-icon>首页
              </div>
            </li>
            <li>
              <div class="item">
                <a href="#/login">
                  <font-awesome-icon :icon="['fas','home']"></font-awesome-icon>
                  <span v-show="!isLogin">去登录</span>
                  <span v-show="isLogin">退出登录</span>
                </a>
              </div>
            </li>
            <li>
              <div class="item">
                <font-awesome-icon :icon="['fas','user']"></font-awesome-icon>个人中心
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="tools">
        <ul>
          <li>
            <div class="item">
              <font-awesome-icon :icon="['fas','envelope']"></font-awesome-icon>
            </div>
          </li>
          <li>
            <div class="item">
              <font-awesome-icon :icon="['fas','cog']"></font-awesome-icon>
            </div>
          </li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "Header",
  data(){
    return{
      isLogin: false
    }
  },
  methods: {
    loginStatus(){
      this.$http.get('http://localhost:80/isLogin').then(function (res) {
        this.isLogin = res.data;
        console.log(res.data)
      }.bind(this))
    }
  },
  mounted() {
    this.loginStatus();
  }
}
</script>

<style scoped>
  /*头部固定导航栏*/
  .header{
    background-color: #fff;
    /*border: 1px #000 solid;*/
    border-top: 2px #fa7d3c solid;
  }
  .contain{
    display: flex;
    justify-content: center;
  }
  a{
    width: 100px;
    box-sizing: border-box;
    margin-right: 20px;
  }
  .logo img{
  }
  span{
    display: inline-block;
    margin-top: 10px;
  }
  /*导航栏中间*/
  .body{
    width: 1000px;
  }
  /*搜索栏*/
  .search{
    width: 470px;
    position: relative;
    margin-right: 100px;
  }
  .search input{
    width: 470px;
    padding: 6px;
    border: 1px #aaa solid;
    box-sizing: border-box;
    margin-top: 10px;
    background-color: #eeeeee;
  }
  .search input:focus{
    outline:none;
    box-sizing: border-box;
    border: 1px #fa7d3c solid;
    background-color: #fff;
  }
  /*搜索小图标*/
  .search-icon{
    position: absolute;
    top:13px;right: 5px;
  }
  .search-icon:hover{
    box-sizing: border-box;
    border-radius: 20px;
    cursor: pointer;
  }
  /*导航栏*/
  .navs{
    overflow: hidden;
  }
  .item{
    color: #676767;
  }
  .item:hover{
    color: #fa7d3c;
    cursor: pointer;
  }
  .navs ul{
    float: right;
  }
  .navs li{
    box-sizing: border-box;
    display: inline-block;
    margin: 15px 20px 0 0;
  }
  .navs li:last-child{
    margin-right: 0;
    padding-right: 30px;
    border-right: 1px #d9d5d5 solid;
  }
  /*小工具*/
  .tools{
    width: 120px
  }
  .tools li{
    box-sizing: border-box;
    display: inline-block;
    margin: 15px 0 0 30px;
    font-size: 20px;
  }
  .tools .item{
    color: #a9a8a8;
  }
  .tools .item:hover{
    color: #fa7d3c;
  }

</style>
