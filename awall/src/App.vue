<template>
  <div id="app">
    <router-view/></div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*background-color: #7c8181;*/
  background: url("https://cdn.jsdelivr.net/gh/Tab-tan/CDN@1.1.15/pic/171141-1575709901e5e0.jpg"),no-repeat;
  background-size: cover;
}
/*清除默认边距*/
*{
  margin: 0;
  padding: 0;
}
/*通用的样式*/
.left{
  float: left;
}
.right{
  float: right;
}
ul{
  list-style: none;
}
a{
  text-decoration: none;
  color: #676767;
}
a:hover{
  color: #fa7d3c;
}
.btn-info{
  font-size: 8px;
  background-color: #40d731;
  color: #FFFFFF;
  box-sizing: border-box;
  padding: 1px 4px;
  border-radius: 3px;
}
.btn-hot{
  font-size: 8px;
  background-color: #f36a23;
  color: #FFFFFF;
  box-sizing: border-box;
  padding: 1px 4px;
  border-radius: 3px;
}
.btn{
  font-size: 8px;
  background-color: rgba(255,255,255,.5);
  color: #000000;
  box-sizing: border-box;
  padding: 4px 4px;
  border-radius: 3px;
  box-shadow: 0 0 4px #000000;
}
.panel-shadow{
  box-shadow: 0 0 3px #626262;
}
textarea{
  margin-top: 5px;
  width: 100%;
  height: 80px;
  resize: none;
  border: 1px #d9d8d8 solid;
  outline: none;
  box-sizing: border-box;
  box-shadow: inset 0 0 5px #d9d8d8;
  padding: 10px;
}
/*test*/
/* 具体文章 */
.litem{
  background-color: #FFF;
  margin-bottom: 10px;
  border-radius: 2px;
  padding: 20px;
}
/*举报控件*/
.ltool{
  float: right;
}
.ltool ul{
  /*display: none;*/
  background-color: #eceaea;
}
.ltool li{
  /*border: 1px #fa7d3c solid;*/
  box-sizing: border-box;
  padding: 2px;
  font-size: 8px;
}
/*头像*/
.lhead .img{
  float: left;
}
.lhead img{
  width: 50px;
  border-radius: 25px;
}
/*账号信息*/
.lhead .info{
  overflow: hidden;
}
.linfo li{
  text-decoration: none;
  display: inline-block;
}
.linfo span{
  margin:5px;
}
.linfo p{
  margin: 5px;
}
/*文章主体*/
.lart{
  width: 550px;
  border-bottom: 1px #d9d5d5 solid;
}
/*底部*/
.lfoot{
  display: flex;
  margin-top: 10px;
  font-size: 10px;
  color: #5f5d5d;
}
.lfoot li{
  display: inline-block;
  width: 200px;
  text-align: center;
  border-right: 1px #d9d5d5 solid;
  box-sizing: border-box;
}
.lfoot li:last-child{
  border: none;
}
</style>
