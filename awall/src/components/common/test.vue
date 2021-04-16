<template>
  <div id="demo">

  </div>
</template>

<script>
export default {
  name: 'test',
  data () {
    return {
      items:[]
    }
  },
  mounted: function () {
    this.$nextTick(function () {
      layui.use('flow', function(){
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
          elem: '#demo' //指定列表容器
          ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
            var lis = [];
            //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
            $.get("http://localhost/test/"+page+"/10", function(res){
              //假设你的列表返回在data集合中
              layui.each(res.data, function(index, item){
                let urls = []
                urls = item.imgs.split(",");

                lis.push(
                  `<div class="litem panel-shadow">
                    <!--举报控件-->
                    <div class="ltool">
                      <a href="javascript:;">
                        <b @click="tool(item.id)">...</b>
                      </a>
                        <ul v-show="item.show">
                          <a href=""><li>举报</li></a>
                          <a href=""><li>关注</li></a>
                        </ul>
                    </div>
                    <!--头部信息-->
                    <div class="lhead">
                      <div class="img">
                        <img src="${item.user.url}" alt="头像">
                      </div>
                      <div class="linfo">
                        <span><a href="">${item.user.nikeName}</a></span>
                        <li><span class="btn-info">认证</span></li>
                        <li><span class="btn-hot">热门</span></li>
                        <p>${item.date}</p>
                      </div>
                    </div>
                    <!--主体文章内容-->
                    <div class="lart" id="art">
                      <p>${item.text}</p>
                      <img src="${item.imgs.split(',')[0]===''?'./static/imgs/空白.png':item.imgs.split(',')[0]}" alt="头像" style="margin-right: 5px">
                    </div>
                    <div class="lfoot">
                      <li>
                        <a href="${item.url}">阅读全文</a>
                      </li>
                      <li>
                        <a href="">评论</a>
                      </li>
                      <li>
                        <a href=""><font-awesome-icon :icon="['fas','thumbs-up']"></font-awesome-icon>点赞(<span>${item.star}</span>)</a>
                      </li>
                    </div>
                  </div>`
                );
                console.log(item)
              });

              //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
              //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
              next(lis.join(''), page < res.pages);
            });
          }
        });
      });
    })
  }
}
</script>

<style scoped>
.test{
  background-color: #FFFFFF;
  height: 100vh;
  padding: 50px;
}
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
