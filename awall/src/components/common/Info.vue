<template>
  <div class="info panel-shadow">
    <div class="head">
      <img src="http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100" alt="头像">
    </div>
    <div class="name">
      <a href="" v-text="nikename">nikeName</a>
    </div>
    <div class="foot">
      <a href="">
        <li>
          <p>234</p>
          <p><span>订阅</span></p>
        </li>
      </a>
      <a href="">
        <li>
          <p>332</p>
          <p>粉丝</p>
        </li>
      </a>
      <a href="">
        <li>
          <p>11</p>
          <p>发文</p>
        </li>
      </a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Info",
  props:{
    "tel":String,
     "nikename":String
  }
}
</script>

<style scoped>
  .info{
    background-color: #FFFFFF;
    padding: 10px;
    box-sizing: border-box;
  }
  /*个人信息面板*/
  .info{
    margin-top: 15px;
    border-radius: 2px;
    padding:0;
  }
  .info .head{
    display: flex;
    justify-content: center;
    background: url("https://cdn.jsdelivr.net/gh/Tab-tan/CDN@1.1.15/pic/171141-1575709901e5e0.jpg"),no-repeat;
  }
  .info img{
    width: 50px;
    border-radius: 25px;
    margin: 30px 0 5px 0;
  }
  .info .name{
    display: flex;
    justify-content: center;
  }
  .info .foot{
    display: flex;
    justify-content: center;
  }
  .info li{
    display: inline-block;
    margin: 10px 10px 0 10px;
    padding: 0 10px 20px 10px;
    font-size: 12px;
    border-right:  1px #d9d5d5 solid;
  }
  .info li:last-child{
    border:none
  }
</style>
