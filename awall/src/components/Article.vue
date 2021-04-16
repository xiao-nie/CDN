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
            <div class="article">
              <div class="article-head">
                <a href="javascript:;" class="right fork">加关注</a>
                <div class="img left">
                  <img :src="user.img" alt="头像">
                </div>
                <div class="info">
                  <span><a href="" v-text="user.nikeName">nikeName</a></span>
                  <li><span class="btn-info">认证</span></li>
                  <li><span class="btn-hot">热门</span></li>
                  <p v-text="date"></p>
                </div>
              </div>
              <div class="article-body">
                <!--主体文章内容-->
                <div class="art">
                  <p v-text="text"></p>
                  <img v-for="img in imgs" :src="img" alt="头像" style="margin-right: 5px">
                </div>
              </div>
              <!--文章评论-->
              <div class="article-comment panel-shadow">
                <div class="comment-head">已有评论 <span v-text="comments.length"></span>条。</div>
                <!--评论列表-->
                <div class="comment-list">
                  <!--每条评论-->
                  <div class="item" v-for="comment in comments">
                    <div class="user-info">
                      <img class="left comment-img" :src="comment.user.img" alt="头像">
                      <div class="info">
                        <span><a :href="comment.user.url" v-text="comment.user.nikeName">nikeName</a></span>
                        <li><a class="btn-info" href="javascript:;" @click="toComment(comment.user.userId)">回复</a></li>
                        <p v-text="date"></p>
                      </div>
                    </div>
                    <div class="comment-content" :id="comment.user.userId">
                      <p v-text="comment.comment"></p>
                    </div>
                  </div>
                </div>
                <!--分页控件-->
                <div class="comment-page right">
                  <a href="javascript:;" class="btn">上一页</a>
                  <a href="javascript:;" class="btn" aria-disabled="true">...</a>
                  <a href="javascript:;" class="btn">下一页</a>
                </div>
                <div class="editor" id="editor">
                  <div class="editor-head">
                    <span>快来评论一下吧~</span>
                    <a href="javascript:;" class="btn" @click.prevent="comment">评论</a>
                  </div>
                  <div class="editor-body">
                    <textarea v-model="commentText"></textarea>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer"></div>
  </div>
</template>

<script>
import Header from "./common/Header";
import Nav from "./common/Nav";
import Editor from "./common/Editor";
export default {
name: "Article",
  components: {Editor, Nav, Header},
  data(){
    return{
        id: -1,
        editorId: 0,
        isClose: true,
        user: {nikeName: 'TabTan',rz: ['认证','热门'],img: 'http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100',url:''},
        date: new Date(),
        text: '文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息。',
        imgs: [],
        star: 102,
        comments:[
          {
            user:{userId:12,nikeName:'张三',url: '',img:'http://q2.qlogo.cn/headimg_dl?dst_uin=1607847501&spec=100'},
            comment: '哇塞，ohhhhhhhhhh，牛啊牛啊！！！'
          },
          {
            user:{userId:11,nikeName:'李四',url: '',img:'http://q2.qlogo.cn/headimg_dl?dst_uin=3298739729&spec=100'},
            comment: '哎嘿嘿，嘿嘿，嘿嘿~'
          }
        ],
      commentText:''
    }
  },
  methods:{
    test: function (e){console.log('test:'+e)},
    //移除评论控件
    removeEditor(){
      let el = document.getElementById(this.editorId);
      el.removeChild(el.childNodes[1]);
      this.editorId = 0;
    },
    //添加评论控件
    addEditor(userId){
      let editor = document.getElementById(userId);
      let span = document.createElement('span')
      span.innerText = '快来回复一下吧~';
      let a = document.createElement('a');
      a.innerHTML = `<a href="javascript:;" class="btn" onclick="{
    // console.log(this.id)
    // console.log(this.id.substring(0,this.id.indexOf('a')))
    let el = document.getElementById(this.id.substring(0,this.id.indexOf('a')));
        el.removeChild(el.childNodes[1]);
}">回复</a>`;
      let textarea = document.createElement('textarea');
      let div = document.createElement('div');
      div.appendChild(span);
      div.appendChild(a);
      div.appendChild(textarea);
      //给动态评论控件加id
      a.childNodes[0].setAttribute('id',userId+'a')
      div.setAttribute('id','editor')
      editor.appendChild(div);
    },
    //动态改变评论栏位置算法
    toComment(userId) {

      if (document.getElementById(userId+'a')===null&&this.isClose === true){
        this.addEditor(userId);
        this.editorId = userId;
        this.isClose = false;
        // console.log('document.getElementById(userId+\'a\')===null,isClose:'+this.isClose+',eid:'+this.editorId);
        return;
      }else {
        // console.log('document.getElementById(userId+\'a\')!==null,isClose:'+this.isClose+',eid:'+this.editorId);
        if(document.getElementById(this.editorId+'a')===null){
          // console.log('document.getElementById(userId+\'a\')===null')
          this.editorId = 0;
          this.isClose =true;
        }
        if(this.editorId === userId){
          this.removeEditor();
          this.editorId = 0;
          return;
        }
        this.isClose = false;
      }

      switch (this.editorId){
        case 0:{
          this.addEditor(userId);
          this.editorId = userId;
          this.isClose = false;
          console.log('add - this.editorId:'+this.editorId+',isClose:'+this.isClose)
        }break;
        case userId:{
          this.removeEditor();
          this.isClose =true;
          this.editorId = 0;
          console.log('rem - this.editorId:'+this.editorId+',isClose:'+this.isClose)
        }break;
        default:{
          this.removeEditor();
          this.addEditor(userId);
          this.isClose =false;
          this.editorId = userId;
          console.log('rem-add - this.editorId:'+this.editorId+',isClose:'+this.isClose)
        }
      }
    },
    comment(){//评论
      if(this.commentText!==''){
        this.comments.push({user:this.user,comment: this.commentText});
        this.commentText = ''
      }
    },
    countInc: function (id){//更新文章浏览情况
      //读cookie查看今天是否已经浏览

      if(this.$cookies.get(id) === undefined){
        //如果没看过就写cookie增加浏览量
        // console.log(this.$cookies.get(id))
        this.$http.get('http://localhost:80/articles/count/'+id).then(function (res) {
          console.log("更新浏览量:"+res.data.data)
        })
        this.$cookies.set(id,1,{expires: 1,path:''});
      }
    },
    initArticle: function (id) {//初始化文章
      this.$http.get('http://localhost:80/article/'+id).then(function (res) {
        console.log('article:'+res.data.data)
        let obj = JSON.parse(res.data.data)
        this.user = obj.user;
        this.date = obj.date;
        this.text = obj.text;
        this.id = obj.id;
        //处理图片
        if (obj.imgs !== ''){
          let urls = obj.imgs;
          this.imgs = urls.split(",")
        }

        // console.log(this.id)
        // 写cookie
        this.countInc(obj.id);
        // console.log(this.$cookies.get())
      }.bind(this))
    }
  },
  mounted() {

    this.initArticle(this.$route.params.id);
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
    width: 830px;
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
  /*文章*/
  .article{
    min-height: 100vh;
    background: rgba(234, 224, 235,.4);
  }
  /*文章头部*/
  .article-head{
    /*height: 100px;*/
    padding: 30px 20px;
    /*border: 1px #a9a8a8 solid;*/
  }
  /*头部头像*/
  .article-head img{
    width: 50px;
    border-radius: 25px;
  }
  .article-head .info{
    overflow: hidden;
  }
  .info li{
    text-decoration: none;
    display: inline-block;
  }
  .info span{
    margin:5px;
  }
  .info p{
    margin: 5px;
  }
  /*文章主体*/
  .article-body{
    /*height: 500px;*/
    /*border: 1px #fa7d3c solid;*/
  }
  /*文章内容*/
  .art{
    box-sizing: border-box;
    padding: 10px 20px;

  }
  /*评论*/
  .article-comment{
    min-height: 200px;
    overflow: hidden;
    padding: 10px;
  }
  .comment-head{
    margin: 5px;
  }
  .item{
    overflow: hidden;
    background: rgba(255,234,244,.2);
    margin-bottom: 10px;
    border-radius: 2px;
  }
  .comment-img{
    width: 50px;
    border-radius: 10px;
    margin: 5px;
  }

  .fork{
    box-shadow: 0 0 5px #a9a8a8 ;
    background-color: #fa7d3c;
    color: #FFFFFF;
    box-sizing: border-box;
    padding: 0 10px;
    border-radius: 2px;
  }

  /*评论*/
  .editor{
    overflow: hidden;
    margin: 40px 0;
    background: rgba(255,255,255,.5);
    box-sizing: border-box;
    padding: 10px;
  }
  .editor-head .btn{
    box-shadow: none;
    background-color: #fa7d3c;
    color: #FFFFFF;
    padding: 4px 15px;
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
  textarea:focus{
    border: 1px #fa7d3c solid;
    box-shadow: none;
  }
</style>
