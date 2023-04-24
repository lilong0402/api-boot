<script setup>
import { login } from '@/api/auth'
const form = reactive({
  username: 'admin',
  password: '123456'
})

const handleLogin = () => {
  login(form).then((res) => {
    console.log(res)
  })
}
</script>

<template>
  <div>
    <el-button type="primary" size="default" @click="handleLogin">登录</el-button>
  </div>
</template>
