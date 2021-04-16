<template>
  <div class="body">
    <div class="container">
      <div class="brand-logo"></div>
      <div class="brand-title" v-text="title"></div>
      <div class="inputs">
        <div class="item">
          <font-awesome-icon :icon="['fas','user']"></font-awesome-icon>
          <input type="tel" name="tel" placeholder="example@qq.com">
        </div>
        <div class="item">
          <font-awesome-icon :icon="['fas','key']"></font-awesome-icon>
          <input type="password" name="password" placeholder="大于6个字符">
        </div>
       <div class="item">
         <input type="text" placeholder="验证码"> <img :src="url">
         <div class="icon">
           <a href="javascript:;" @click="changeImg"><font-awesome-icon :icon="['fas','sync-alt']"></font-awesome-icon> 换一张</a>
         </div>
       </div>
      </div>
      <button type="submit" @click.prevent="loginHandler">登录</button>
      <div class="bottom">
        <a href="#/find">忘记密码</a>
        <a href="#/register">去注册</a>
      </div>
    </div>
    <div class="iciba-root"></div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return {
      title: 'Login',
      // url: 'http://192.168.0.106:8080/getVerifyCode?1',//验证码接口，
      url: 'http://localhost:80/getVerifyCode?1',//验证码接口，
      token: {
        tel:'',
        password: '',
        code: ''
      }
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
          case 'text': this.token.code = input.value;break;
        }
      }
      console.log('提交的数据: tel:',this.token.tel,'\tpassword:',this.token.password,'\tcode:',this.token.code);
      //调用后端登陆接口
      // this.$http.post('http://192.168.0.106:8080/login',this.token).then(function (res){
      this.$http.post('http://localhost:80/login',this.token).then(function (res){
        //res:返回的数据
        console.log(res.data)
        if(res.data.code === 200){
          this.$router.push({name: 'Main'});
        }
      }.bind(this));
    },
    changeImg(){
      this.url = this.url+'1';
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


.item input:first-child{
  margin-left: 20px;
  width: 80px;
}
.item img{
  width: 80px;
  height: 30px;
}
.icon{
  font-size: 10px;
  display: inline-block;
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
