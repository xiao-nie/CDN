<template>
  <div class="main">
    <div class="header">
      <Header></Header>
    </div>
    <div class="body-contain">
      <div class="body">
        <div class="left-contain left">
          <div class="nav">
            <Nav></Nav>
          </div>
        </div>
        <div class="right-contain">
          <!--中间展示文章部分-->
          <div class="content left">
            <!--输入框-->
            <Editor></Editor>
            <!--文章-->
<!--            <Items></Items>-->
            <test></test>
          </div>
          <!--右侧工具栏-->
          <div class="tools right">
            <!--个人信息-->
            <Info :nikename="user.nikename"></Info>
            <!--热门话题-->
            <Hot></Hot>
            <!--公告-->
            <Notice></Notice>
          </div>
        </div>
      </div>
    </div>
    <div class="footer"></div>
  </div>
</template>

<script>
import Nav from "./common/Nav";
import Header from "./common/Header";
import Editor from "./common/Editor";
import Items from "./common/Items";
import Info from "./common/Info";
import Hot from "./common/Hot";
import Notice from "./common/Notice";
import Test from "./common/test";
export default {
  name: "Main",
  data(){
    return{
      user: {
        tel: '',
        nikename: 'Tab-Tan',
        logined: false
      }
    }
  },
  components: {Test, Notice, Hot, Info, Items, Editor, Header, Nav},
  methods:{
    changeLoginStatus(ev){
      ev ?this.user.logined =true:this.user.logined = false;
    }
  }
}
</script>

<style scoped>
  .main{
    /*background-color: #c7f5f5;*/
    position: relative;
    background: rgba(255,255,255,.3);
  }
  /*主体页面*/
  .body-contain{
    display: flex;
    justify-content: center;
  }
  .body{
    box-sizing: border-box;
    background: url("https://cdn.jsdelivr.net/gh/Tab-tan/CDN@1.1.15/pic/171141-1575709901e5e0.jpg"),no-repeat;
    background-size: cover;
  }
  /*左侧导航栏*/
  .left-contain{
    width: 150px;
    box-sizing: border-box;
  }
  .nav{

  }
  /*右侧内容*/
  .right-contain{
    box-sizing: border-box;
    /*border: 1px #000 solid;*/
    /*background-color: #b79696;*/
    width: 850px;
    overflow: hidden;
  }
  /*中间内容主体版面*/
  .content{
    width: 600px;
    /*border: 1px #42b983 solid;*/
    /*background-color: aquamarine;*/
    margin-right: 10px;
  }
  /*右侧工具面板*/
  .tools{
    box-sizing: border-box;
    width: 230px;
    margin-right: 10px;
  }
  /*底部固定页脚*/
  .footer{
    height: 100px;
    background-color: #b79696;
  }

</style>
