<template>
  <div class="editor panel-shadow">
    <div class="contain">
      <div class="header">
        <span class="art" @mouseover="delImg">有什么新鲜事上墙？</span>
      </div>
      <div class="body">
        <textarea v-model="article.text"></textarea>
          <div id="img"></div>
        <input type="text" id="hidden" style="display: none" v-model="article.imgs">
      </div>
      <div class="foot">
        <div class="fl">
          <ul>
            <li>
              <div class="laugh">
                <font-awesome-icon :icon="['fas','laugh']"></font-awesome-icon>
              </div>
              <span>表情</span>
            </li>
            <li>
              <a href="javascript:;" id="test1">
                <div class="image">
                  <font-awesome-icon :icon="['fas','image']"></font-awesome-icon>
                </div>
                <span>图片</span></a>
            </li>
<!--            <li>-->
<!--              <div class="video">-->
<!--                <font-awesome-icon :icon="['fas','video']"></font-awesome-icon>-->
<!--              </div>-->
<!--              <span>视频</span>-->
<!--            </li>-->
            <li>
              <div class="tag">
                #
              </div>
              <span>话题</span>
            </li>
          </ul>
        </div>
        <div class="fr">
          <a class="btn" href="" @click.prevent="submit">发布</a>
        </div>
      </div>
      <span id="add"></span>
    </div>
  </div>
</template>

<script>
export default {
  name: "Editor",
  data(){
    return{
      //待发送文章
      article:{
        text: '',
        imgs: '',
        date: new Date(),
        classify: '',
        tag: '',
        type: ''
      }
    }
  },
  methods:{
    submit(){
      //点击提交时更新imgs
      this.article.imgs = document.getElementById('hidden').value;
      this.$http.post('http://localhost:80/articles/pubArticle',this.article).then(function (res) {
          console.log(res.data.data)
      })
    },
    inImg: function(id){
      let imgArea = document.getElementById('img');
      //创建图片
      let img = document.createElement('img')
      // img.src=this.imgs[this.imgs.length-1];
      img.src="http://localhost/upload/2021-04-15/05dd5467-12cf-4090-9870-0623e125080b.gif";
      img.style="width:200px";
      //创建控件
      // <a href="" class="right" @click.prevent="delImg(id)">x</a>
      let a = document.createElement('a')
      a.className="right";
      a.innerText="x";
      a.href="javascript:;";
      a.onclick = function () {
        // 调用删除方法
        this.delImg()
      }.bind(this)
      let div = document.createElement('div')
      div.appendChild(img);
      div.appendChild(a);
      div.id='img'+id;
      div.style="display: inline-block";
      div.className="img";
      document.getElementById('img').parentElement.appendChild(div);
    },
    outImg: function(id){
      var did = document.getElementById('div'+id)
      document.getElementById(id).parentElement.parentElement.removeChild(did)
    },
    delImg: function (){
      console.log("删除方法");
      console.log(this.article.imgs)
    },
    addImgs: function (url){
      console.log("添加"+url)

    }
  },
  mounted: function () {

    this.$nextTick(function () {
      //上传照片
      layui.use('upload', function () {

        var upload = layui.upload;
        var $ = layui.$
        //执行实例
        upload.render({
          elem: '#test1' //绑定元素
          , url: 'http://localhost:80/upload' //上传接口
          , done: function (res) {
            //上传完毕回调
            // $("#url").val(res.data)
            console.log(res.data)
            let obj = JSON.parse(res.data);
            let oldValue = $("#hidden").val();
            if(oldValue !== ''){
              oldValue = oldValue+','+obj.id;
              $("#hidden").val(oldValue)
            }else {
              oldValue = obj.id;
              $("#hidden").val(oldValue);
            }
            // 上传成功后添加图片
            let imgArea = document.getElementById('img');
            //创建图片
            let img = document.createElement('img')
            // img.src=this.imgs[this.imgs.length-1];
            img.src=obj.url;
            img.style="width:200px";
            //创建控件
            // <a href="" class="right" @click.prevent="delImg(id)">x</a>
            let a = document.createElement('a')
            a.className="right";
            a.innerText="x";
            a.href="javascript:;";
            a.onclick = function () {
              // 删除照片
              // console.log(this.parentElement.firstChild.src)
              //要删除的div
              let delDiv = document.getElementById(this.parentElement.id);
              //要删除的url
              let delId = this.parentElement.id;
              // console.log(delId)
              document.getElementById('img').parentElement.removeChild(delDiv);
              // 删除图片的连接
              let val = $("#hidden").val();
              // console.log(val.indexOf(delId.substr(3,delId.length)))
              // console.log(val + "  " +delId.substr(3,delId.length))
              let start = Number(val.indexOf(delId.substr(3,delId.length)));
              let end = Number(start)+Number(delId.length-3);
              // console.log("start:"+start+",end:"+end)
              if(start === 0){
                //在第一个直接把id和第一个逗号删了
                val = val.substr(end+1,val.length)
                // console.log("在开头 val:" + val)
              } else if(end<val.length-1){
                //在中间,删除后逗号和id
                let be = val.substring(0,start);
                let en = val.substring(end+1,val.length)
                val = be+en;
                // console.log("在中间 val:" + val)
              }else {
                //在最后直接把前面逗号和id删掉
                val = val.substring(0,start-1);
                // console.log("在最后 val:" + val)
              }
              //更新隐藏域中的urls
              $("#hidden").val(val);
              // console.log("更新后的val:"+val)
            }
            let div = document.createElement('div')
            div.appendChild(img);
            div.appendChild(a);
            div.id='img'+obj.id;
            div.style="display: inline-block";
            div.className="img";
            document.getElementById('img').parentElement.appendChild(div);
          }
          , error: function () {
            //请求异常回调
            $("#url").val('上传失败!')
          }
        });
      });
    })
  }
}
</script>

<style scoped>
  .editor{
    background-color: #fff;
    border-radius: 2px;
  }
  .contain{
    width: 600px;
    overflow: hidden;
    margin: 15px 0;
    box-sizing: border-box;
    padding: 10px;
  }
  /*字体*/
  .art{
    font-family: Geneva, sans-serif;
    display: inline-block;
    font-size: 17px;
    /*font-weight: bold;*/
    color: #e02e2e;
    text-shadow: #bfbcbc -1px -1px 3px;
  }
  /*输入框*/
  .body{
    margin: 10px 0;
  }
  .body textarea{
    width: 580px;
    height: 70px;
    resize: none;
    border: 1px #d9d8d8 solid;
    outline: none;
    box-sizing: border-box;
    box-shadow: inset 0 0 5px #d9d8d8;
    padding: 10px;
  }
  .body textarea:focus{
    border: 1px #fa7d3c solid;
    box-shadow: none;
  }

  /*底部*/
  .fl{
    float: left;
  }
  .laugh{
    color: #fa7d3c;
    font-size: 15px;
    display: inline-block;
  }
  .image{
    color: #339229;
    font-size: 15px;
    display: inline-block;
  }
  .video{
    color: #32cade;
    font-size: 15px;
    display: inline-block;
  }
  .tag{
    color: #bc81d0;
    font-size: 16px;
    display: inline-block;
    font-weight: bold;
  }
  span{
    font-size: 10px;
  }
  li{
    display: inline-block;
    margin-right: 20px;
  }
  /*提交按钮*/
  .fr{
    float: right;
  }
  .btn{
    display: block;
    height: 28px;
    line-height: 29px;
    width: 60px;
    font-size: 14px;
    background: #f3a38b;
    color: #fff;
    text-align: center;
    padding: 0 10px;
    border-radius: 2px;
  }
  .btn:hover{
    background: #eb7350;
  }

</style>
