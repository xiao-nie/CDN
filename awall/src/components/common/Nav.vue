<template>
  <div class="nav">
    <div class="content">
      <ul>
        <a href="javascript:;">
          <li>
            <div class="item">
              <div class="icon-l left">
                <img width="14" height="22" src="@/assets/icon/首页.svg" alt="首页">
              </div>
              <span><a href="#/">首页</a></span>
              <div class="icon-r"></div>
            </div>
          </li>
        </a>
        <a href="javascript:;">
          <li>
            <div class="item">
              <div class="icon-l left">
                <img width="14" height="22" src="@/assets/icon/组织.svg" alt="组织">
              </div>
              <span>组织</span>
              <div class="icon-r"></div>
            </div>
          </li>
        </a>
        <a href="javascript:;">
          <li>
           <div class="item">
             <div class="icon-l left">
               <img width="14" height="22" src="@/assets/icon/流程.svg" alt="流程">
             </div>
             <span>办事流程</span>
             <div class="icon-r"></div>
           </div>
          </li>
        </a>
        <a href="javascript:;">
          <li>
            <div class="item">
              <div class="icon-l left">
                <img width="14" height="22" src="@/assets/icon/聊天.svg" alt="聊天">
              </div>
              <span><a href="#/room">聊天室</a></span>
              <div class="icon-r"></div>
            </div>
          </li>
        </a>
        <a href="javascript:;">
          <li>
            <div class="item">
              <div class="icon-l left">
                <img width="14" height="22" src="@/assets/icon/维权.svg" alt="维权">
              </div>
              <span>维权平台</span>
              <div class="icon-r">

              </div>
            </div>
          </li>
        </a>
        <a href="javascript:;">
          <li>
            <div class="item">
              <div class="icon-l left">
                <img width="14" height="22" src="@/assets/icon/团队.svg" alt="团队">
              </div>
              <span>组团</span>
              <div class="icon-r"></div>
            </div>
          </li>
        </a>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Nav"
}
</script>

<style scoped>
 .nav{
   height: 100vh;
   margin-top: 20px;
 }
 .content{
 }
  li{
    width: 150px;
    height: 34px;
    font-size: 14px;
    font-weight: bold;
    /*border: 1px #a11 solid;*/
  }
  li:hover{
    background: rgba(255,255,255,.3);
  }
  .item{
    box-sizing: border-box;
    padding: 5px 0 10px 10px;
    /*border: 1px #000 solid;*/
  }
  .item .icon-l{
    margin-right: 10px;
  }
  .item span{
    max-width: 82px;
  }
  a{
    color: #fff;
  }
</style>
