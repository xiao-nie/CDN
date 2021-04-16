<template>
  <div class="body">
    <div class="container">
      <div class="brand-logo"></div>
      <div class="brand-title" v-text="title"></div>
      <div class="inputs">
        <div class="item">
          <font-awesome-icon :icon="['fas','user']"></font-awesome-icon>
          <input type="tel" name="tel" placeholder="手机号" v-model="token.tel" @focusout="isOk('tel')">
        </div>
        <div class="item">
          <font-awesome-icon :icon="['fas','key']"></font-awesome-icon>
          <input name="password" type="password" placeholder="密码" v-model="token.password" @focusout="isOk('password')">
        </div>
        <div class="item">
          <font-awesome-icon :icon="['fas','key']"></font-awesome-icon>
          <input name="rePassword" type="password" placeholder="确认密码" @focusout="isOk('rePassword')">
        </div>
        <div class="item">
          <font-awesome-icon :icon="['fas','signature']"></font-awesome-icon>
          <input name="nikename" type="text" placeholder="昵称" v-model="token.nikename" @focusout="isOk('nikename')">
        </div>
       <div class="item">
         <a href="javascript:;" class="icon" id="count" @click="countChange">点击发送</a>
         <input name="code" id="end" type="text" placeholder="验证码" v-model="token.code" @focusout="isOk('code')">
       </div>
      </div>
      <button type="submit" @click.prevent="loginHandler">注册</button>
      <div class="bottom">
        <a href="">返回首页</a>
        <a href="#/login">去登录</a>
      </div>
    </div>
    <div class="iciba-root"></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Register",
  data(){
    return {
      title: 'Login',
      token: {
        tel:'',
        password: '',
        nikename: '',
        code: ''
      },
      count: 60
    }
  },
  methods: {
    loginHandler(){
      //后台验证
      let inputs = document.getElementsByTagName('input');
      //拿到值存在token里
      for (let input of inputs) {
        switch (input.type) {
          case 'tel': this.token.tel = input.value;break;
          case 'password': this.token.password = input.value;break;
          case 'nikename': this.token.nikename = input.value;break;
          case 'code': this.token.code = input.value;break;
        }
      }
      console.log('提交的数据: tel:',this.token.tel,'\tpassword:',this.token.password,'\tcode:',this.token.code);
      //调用后端登陆接口
      // this.$http.post('http://192.168.0.106:8080/login',this.token).then(function (res){
      this.$http.post('http://localhost:80/register',this.token).then(function (res){
        //res:返回的数据
        // if (res.code === 200){
        //    this.$router.push({name: "Main"})//成功登陆，跳转首页
        // }else {
        //   alert(res.data)
        // }
        console.log(res.data)//注册成功！
        if(res.data === '注册成功！'){
          this.$router.push({name: 'Login'});
        }
      }.bind(this));
    },
    goLogin(){
      this.$router.push()
    },
    changeImg(){
      this.url = this.url+'1';
    },
    countChange(){
      if(this.timer == null) {
        // 当没有计时的时候允许发送短信验证码
        this.$http.get('http://localhost:80/sms?tel='+this.token.tel).then(function (res) {
          // if (res.data.code === 200){
          //     console.log("验证码已发送")
          // }
        })
        this.timer = setInterval( () => {
          // console.log('倒计时:'+this.count)
          let count = document.getElementById("count");
          if (this.count>0){
            this.count--;
            count.innerText = this.count;
            count.disabled = 'disabled'
          }else {
            clearInterval(this.timer);
            count.innerText = '点击发送';
            count.disabled = 'enabled';
            this.timer = null;
            this.count = 60
          }
        }, 1000);
      }
    },
    isOk(name){
      switch (name) {
        case 'tel':{
          this.$http.post('http://localhost:80/tel',{tel:this.token.tel}).then(function (ev) {
            console.log('res:'+ev.data)
            if (ev.data === 'OK!'){
              document.getElementsByName('tel')[0].style.borderBottomColor = 'green'
            }else {
              document.getElementsByName('tel')[0].style.borderBottomColor = 'red'
            }
          })
        };break;
        case 'password': ;break;
        case 'rePassword': ;break;
        case 'nikename': ;break;
        case 'code': ;break;
        default: ;break;
      }
    }
  }
}
</script>

<style scoped>
.body {
  margin: 0;
  width: 100vw;
  height: 100vh;
  background: #ecf0f3;
  display: flex;
  align-items: center;
  text-align: center;
  justify-content: center;
  place-items: center;
  overflow: hidden;
  font-family: poppins;
}

.container {
  position: relative;
  width: 350px;
  height: 500px;
  border-radius: 20px;
  padding: 40px;
  box-sizing: border-box;
  background: #ecf0f3;
  box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white;
}

.brand-logo {
  height: 100px;
  width: 100px;
  background: url("https://cdn.jsdelivr.net/gh/Tab-tan/CDN@1.1.24/pic/logo100.png");
  margin: auto;
  border-radius: 50%;
  box-sizing: border-box;
  box-shadow: 7px 7px 10px #cbced1, -7px -7px 10px white;
}

.brand-title {
  margin-top: 10px;
  font-weight: 900;
  font-size: 1.8rem;
  color: #096d10;
  letter-spacing: 1px;
}

.inputs {
  text-align: left;
  margin-top: 30px;
  font-size: 25px;
}

.item{
  margin: 5px;
  color: #867d7d;
}
input::placeholder {
  color: gray;
}

input {
  width: 175px;
  border: none;
  float: right;
  margin-right: 20px;
  height: 30px;
  box-sizing: border-box;
  padding: 5px;
  background-color: #ecf0f3;
  border-bottom: #d9d5d5 2px solid;
  transition: width 1s;
}
#end{
  width: 150px;
}

input:focus{
  width: 200px;
  outline: none;
  border-bottom: #fa7d3c 2px solid;
}

button {
  border: 1px #d9d5d5 solid;
  width: 250px;
  height: 35px;
  border-radius: 5px;
  background-color: #4a9d42;
  color: #FFFFFF;
  transition: 0.5s;
  margin-top: 20px;
}

button:hover {
  cursor: pointer;
  box-shadow: 6px 6px 6px #cbced1, -6px -6px 6px white;
}

.icon{
  width: 80px;
  font-size: 10px;
  display: inline-block;
  border: 1px #a7a4a2 solid;
  box-sizing: border-box;
  padding: 2px;
  border-radius: 2px;
  text-align: center;
}

h1 {
  position: absolute;
  top: 0;
  left: 0;
}
.bottom{
  margin:10px 10px;
  font-size: 8px;
  float: right;
}
.bottom a{
  margin-left: 5px;
  border-bottom: 2px #bcaba4 solid;
}
</style>
