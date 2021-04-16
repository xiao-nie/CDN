<template>
  <!--热门话题-->
  <div class="hot">
    <div class="head">
      <span>热门话题</span>
      <a href="javascript:;">
        <font-awesome-icon :icon="['fas','sync-alt']"></font-awesome-icon> 换一批
      </a>
    </div>
    <div class="hots">
      <ul>
        <li><a href="">#马斯克称不向美政府提...#</a> 1751</li>
        <li><a href="">#马斯克称不向美政府提...#</a> 1751</li>
        <li><a href="">#马斯克称不向美政府提...#</a> 1751</li>
        <li><a href="">#马斯克称不向美政府提...#</a> 1751</li>
        <li><a href="">#马斯克称不向美政府提...#</a> 1751</li>
      </ul>
    </div>
    <div class="foot">
      <a href="">查看更多 ></a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Hot"
}
</script>

<style scoped>
  /*热门话题*/
  .hot{
    background-color: #FFFFFF;
    margin-top: 15px;
    box-sizing: border-box;
    padding: 10px;
    font-size: 14px;
  }
  .hot .head{
    margin-bottom: 10px;
    padding-bottom: 10px;
    border-bottom: 1px #d9d5d5 solid;
  }
  .hot .head a{
    font-size: 13px;
    float: right;
    text-align: right;
  }
  .hots{
    border-bottom: 1px #d9d5d5 solid;
    padding-bottom: 10px;
  }
  .hots li{
    margin-bottom: 5px;
  }
  .hot .foot{
    padding-top: 10px;
    text-align: right;
  }
</style>
