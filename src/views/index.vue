<script setup>
import { useLogout } from '../hook/useAuth'
import admincop from '../layout/admin.vue'
const { handleLogout } = useLogout()
</script>

<template>
  <div>
    <admincop></admincop>
    <el-button type="primary" @click="handleLogout">登出</el-button>
  </div>
</template>
