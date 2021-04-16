<template>
  <!--公告-->
  <div class="notice">
    <div class="head">
      <span>公告栏</span>
    </div>
    <div class="items">
      <ul>
        <a href=""><li>《首都互联网协会发布坚守七条底线倡议书》</li></a>
        <a href=""><li>DMCA投诉/Report</li></a>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notice"
}
</script>

<style scoped>
  .notice{
    font-size: 15px;
    background-color: #FFFFFF;
    margin-top: 15px;
    padding: 10px;
  }
  .notice .head{
    font-weight: bold;
    border-bottom: 1px #d9d5d5 solid;
    padding-bottom: 10px;
  }
  .notice .items{
    margin-top: 10px;
    font-size: 14px;
  }
  .notice .items li{
    margin-bottom: 5px;
  }
</style>
