<template>
  <!--文章-->
  <div class="items">
    <div class="item panel-shadow" v-for="item in items" :key="item.id">
      <!--举报控件-->
      <div class="tool">
        <a href="javascript:;">
          <b @click="tool(item.id)">...</b>
        </a>
          <ul v-show="item.show">
            <a href=""><li>举报</li></a>
            <a href=""><li>关注</li></a>
          </ul>
      </div>
      <!--头部信息-->
      <div class="head">
        <div class="img">
          <img :src="item.user.url" alt="头像">
        </div>
        <div class="info">
          <span><a href="" v-text="item.user.nikeName">nikeName</a></span>
          <li><span class="btn-info">认证</span></li>
          <li><span class="btn-hot">热门</span></li>
          <p v-text="item.date"></p>
        </div>
      </div>
      <!--主体文章内容-->
      <div class="art">
        <p v-text="item.text"></p>
        <img v-for="img in item.imgs" :src="img" alt="头像" style="margin-right: 5px">
      </div>
      <div class="foot">
        <li>
          <a :href="item.url">阅读全文</a>
        </li>
        <li>
          <a href="">评论</a>
        </li>
        <li>
          <a href=""><font-awesome-icon :icon="['fas','thumbs-up']"></font-awesome-icon>点赞(<span v-text="item.star"></span>)</a>
        </li>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Items",
  data(){
    return{
      //当前页数
      pageNum: 1,
      //每页长度
      len: 10,
      //页面文章数据
      items:[
        // {
        //   user: {nikeName: 'TabTan',rz: ['认证','热门'],url: 'http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100'},
        //   date: new Date(),
        //   text: '文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息。',
        //   imgs: ['http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100','http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100'],
        //   star: 102
        // },
        // {
        //   user: {nikeName: 'Test',rz: ['认证','热门'],url: 'http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100'},
        //   date: new Date(),
        //   text: '文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息，文章的缩略信息。',
        //   imgs: ['http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100','http://q2.qlogo.cn/headimg_dl?dst_uin=1607847510&spec=100'],
        //   star: 11
        // }
      ]
    }
  },
  watch: {
    $route: ["initArticles"]
  },
  methods:{
    initArticles: function () {
      return this.$http.get("http://localhost/articles/"+this.pageNum+'/'+this.len).then(function (res) {
        // console.log(res.data.data)
        var obj = JSON.parse(res.data.data)
        console.log(obj)
        //处理图片
        for (let i = 0; i < obj.length; i++) {
          if(obj[i].imgs !== ''){
            obj[i].imgs = obj[i].imgs.split(",");
          }
        }
        this.items = obj;
      }.bind(this))},
    tool: function (id) {// 显示和隐藏举报控件
      for (let i = 0; i < this.items.length; i++) {
        if(this.items[i].id === id){
          this.items[i].show = !this.items[i].show;
        }
      }
    }
  },
  mounted() {
    // 初始化
    this.initArticles();
  }
}
</script>

<style scoped>
  /* 具体文章 */
  .item{
    background-color: #FFF;
    margin-bottom: 10px;
    border-radius: 2px;
    padding: 20px;
  }
  /*举报控件*/
  .tool{
    float: right;
  }
  .tool ul{
    /*display: none;*/
    background-color: #eceaea;
  }
  .tool li{
    /*border: 1px #fa7d3c solid;*/
    box-sizing: border-box;
    padding: 2px;
    font-size: 8px;
  }
  /*头像*/
  .head .img{
    float: left;
  }
  .head img{
    width: 50px;
    border-radius: 25px;
  }
  /*账号信息*/
  .head .info{
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
  .art{
    width: 550px;
    border-bottom: 1px #d9d5d5 solid;
  }
  /*底部*/
  .foot{
    display: flex;
    margin-top: 10px;
    font-size: 10px;
    color: #5f5d5d;
  }
  .foot li{
    display: inline-block;
    width: 200px;
    text-align: center;
    border-right: 1px #d9d5d5 solid;
    box-sizing: border-box;
  }
  .foot li:last-child{
    border: none;
  }
</style>
