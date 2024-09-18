<template>
  <div id="app">
    <el-container>
      <!-- 头部 -->
      <el-header class="el-header">
        <el-container>
          <div>
            <!--引入一张图片-->
            <img src="@/assets/export.png" class="header-img"/>
          </div>
          <el-menu
            :default-active="activeIndex2"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="white"
            active-text-color="#ffd04b"
            style="margin-left: auto;">
            <el-menu-item index="1">处理中心</el-menu-item>
            <el-submenu index="2">
              <template slot="title">我的工作台</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-submenu>
            <el-menu-item index="3"><a href="../index.html" target="_self">首页</a></el-menu-item>
          </el-menu>
        </el-container>
      </el-header>

    <el-container>
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1']">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu">学工部</i></template>
            <el-menu-item index="1-1"><i class="el-icon-help"> <a href="#/user/stuList">在校学生管理</a></i></el-menu-item>
            <el-menu-item index="1-2"><i class="el-icon-help">学生升级/留级</i></el-menu-item>
            <el-menu-item index="1-3"><i class="el-icon-help">学生就业情况</i></el-menu-item>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu">咨询部</i></template>
            <el-menu-item index="2-1"><i class="el-icon-help">意向学生管理</i></el-menu-item>
            <el-menu-item index="2-2"><i class="el-icon-help">未报名学生管理</i></el-menu-item>
            <el-menu-item index="2-3"><i class="el-icon-help">已报名学生管理</i></el-menu-item>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title"><i class="el-icon-menu">教研部</i></template>
            <el-menu-item index="3-1"><i class="el-icon-help">已有课程管理</i></el-menu-item>
            <el-menu-item index="3-2"><i class="el-icon-help">正在研发课程管理</i></el-menu-item>
            <el-menu-item index="3-3"><i class="el-icon-help">新技术课程管理</i></el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-main>
          <div style="top:80px;left: 120px; width: 100%;height:500px">
                      <!-- 路由：组件导入的位置 -->
                      <router-view/>
          </div>
        </el-main>
      </el-container>

    </el-container>      
    </el-container>
  </div>
</template>

<script>
export default {
  name:"App"
}
</script>

<style>
  .el-header{
            background-color: #545c64;
        }
  .header-img{
            width: 100px;
            margin-top: 20px;
        }
</style>
