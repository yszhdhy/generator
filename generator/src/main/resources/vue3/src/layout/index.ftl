<script setup lang="ts">
import Logo from './logo/index.vue'
import Menu from '@/layout/menu/index.vue'
import TabBar from './tabbar/index.vue'
import Main from './main/index.vue'
import useLayOutSettingStore from '@/store/modules/setting'
import useUserStore from '@/store/modules/user'
import { useRoute } from 'vue-router'


let userStore = useUserStore()
let $route = useRoute()
let LayOutSettingStore = useLayOutSettingStore()
</script>
<template>
  <el-container class="layout-container-demo" style="height: 100vh">
    <el-aside
        width="200px"
        :class="{ isCollapse: LayOutSettingStore.isCollapse ? true : false }"
    >
      <el-scrollbar>
        <el-menu
            :default-active="$route.path"
            active-text-color="#fff"
            background-color="#001529"
            text-color="#959ea6"
            :collapse="LayOutSettingStore.isCollapse"
            :router="true"
        >
          <Logo />
          <Menu :menuList="userStore.menuRoutes" />
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container class="container">
      <TabBar style="width: 100%" />
      <el-main
          :style="{
          left: !LayOutSettingStore.isCollapse ? '200px' : '56px',
          width: LayOutSettingStore.isCollapse
            ? 'calc(100% - 56px)'
            : 'calc(100% - 200px)',
        }"
      >
        <el-scrollbar>
          <Main />
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
</template>
<style lang="scss" scoped>
.layout-container-demo {
  height: 100%;
}
.layout-container-demo .el-menu {
  border-right: none;

   :deep .el-menu-item.is-active{
     color: black;
   }
  :deep  .el-menu-item:hover{
    background-color: #EEEEEE !important;
    border-radius: 8px !important;
    color: #ffffff;
  }
  :deep .el-sub-menu__title{
    background-color: #ffffff !important;
    color: black !important;
  }
  :deep .el-sub-menu__title:hover{
    background-color: #EEEEEE !important;
    border-radius: 8px !important;
    color: #ffffff !important;  ;
  }

}
.layout-container-demo .el-main {
  position: absolute;
  padding: 20px;
  left: 200px;
  top: 60px;
  transition: all 0.3s;
  width: calc(100% - $base-menu-width);
  height: calc(100vh - 60px);
  background: #f0f2f5;
}

.el-aside {
  background-color: #ffffff!important;
  transition: all 0.3s;
}
 :deep .el-menu{
  background-color: #ffffff!important;
}

.el-header {
  background-color: #fff !important;
  z-index: 999;
}

.isCollapse {
  width: 56px;
}

</style>