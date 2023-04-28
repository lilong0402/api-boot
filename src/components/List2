<script setup>
const showDrawer = ref(false)
defineProps({
  title: String,
  size: {
    type: String,
    default: '45%'
  },
  destroyOnClose: {
    type: Boolean,
    default: false
  },
  confirmText: {
    type: String,
    default: '提交'
  }
})
const loading = ref(false)
const showLoading = () => (loading.value = true)
const hideLoading = () => (loading.value = false)
// 打开
const open = () => (showDrawer.value = true)
// 关闭
const close = () => (showDrawer.value = false)
// 提交
const emit = defineEmits(['submit'])
const submit = () => emit('submit')
// 向父组件暴露以下方法
defineExpose({
  open,
  close,
  showLoading,
  hideLoading
})
</script>

<template>
  <!-- 新建/刷新 -->
  <div class="f-between mb-4">
    <div>
      <el-button
        class="px-8 py-4 bg-blue-500 text-light-50 rounded-full"
        @click="handleCreate"
        v-permission="['sys:notice:save']"
        >新增</el-button
      >
      <el-button
        class="px-8 py-4 bg-green-500 text-light-50 rounded-full"
        @click="importNotice"
        v-permission="['sys:notice:import']"
        >导入</el-button
      >
      <el-button
        class="px-8 py-4 bg-indigo-500 text-light-50 rounded-full"
        @click="exportNotice"
        v-permission="['sys:notice:export']"
        >导出</el-button
      >
      <input
        type="text"
        v-model="keyword"
        placeholder="请搜索"
        class="text-gray-500 border-gray-300 border-solid border-1 outline-none rounded-2xl py-1 ml-3 w-60 pl-2 text-sm"
      />
      <el-button class="px-8 py-4 bg-sky-500 text-light-50 rounded-full ml-2" @click="getData">搜索</el-button>
    </div>
    <el-tooltip content="刷新数据" placement="top" effect="dark">
      <el-button text @click="getData">
        <IEpRefresh />
      </el-button>
    </el-tooltip>
  </div>
</template>

<style scoped>
.form-drawer {
  @apply flex flex-col w-full h-[100%] relative;
}
.form-drawer .body {
  @apply flex-1 absolute top-0 left-0 right-0 bottom-10 overflow-y-auto;
}
.form-drawer .actions {
  @apply mt-auto flex items-center h-20;
}
</style>
