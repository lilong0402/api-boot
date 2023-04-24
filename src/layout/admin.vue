<script setup>
// import top-nav from '../'
import { useAdminStore } from '../stores'
// import {  } from '../stores'

// import top-nav form '../'
import sidemenu from './components/SideMenu.vue'
import topnav from './components/TopNav.vue'
import breadcrumbs from './components/BreadCrumbs.vue'
// import sidemenu from './components/FormDrawer.vue'

const store = useAdminStore()

const { sideWidth } = storeToRefs(store)
</script>

<template>
  <el-container>
    <el-header>
      <topnav />
    </el-header>

    <el-container>
      <el-aside :style="{ width: sideWidth }">
        <sidemenu />
      </el-aside>

      <el-main>
        <breadcrumbs />
        <router-view v-slot="{ Component }">
          <transition name="fade">
            <keep-alive :max="10">
              <component :is="Component"></component>
            </keep-alive>
          </transition>
        </router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.el-main {
  @apply w-full h-screen text-left;
  padding: 0;
}
.el-aside {
  transition: all 0.2s;
}
.fade-enter-from {
  opacity: 0;
}
.fade-enter-to {
  opacity: 1;
}
.fade-leave-from {
  opacity: 1;
}
.fade-leave-to {
  opacity: 0;
}
.fade-enter-active,
.fade-leave-active {
  transition: all 0.3s;
}
.fade-enter-active {
  transition-delay: 0.3s;
}
</style>
