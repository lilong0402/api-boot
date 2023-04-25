<script setup>
defineProps({
  title: String,
  tip: String,
  btns: Array
})

const colors = ['#22d322', '#22c5c', '#d6d3d1', '#f59e0b']
</script>
<template>
  <el-card class="shadow">
    <template #header>
      <div class="f-between">
        <span class="text-sm">{{ title }}</span>
        <el-tag type="danger" effect="plain">{{ tip }}</el-tag>
      </div>
    </template>
    <el-row :gutter="20">
      <el-col :span="6" v-for="(item, index) in btns" :key="index">
        <el-card class="shadow" :style="{ backgroundColor: colors[index] }">
          <div class="f-col-center">
            <span class="text-xl mb-2">{{ item.value }}</span>
            <span class="text-xs text-gray-500">{{ item.label }}</span>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </el-card>
</template>

<style lang="scss" scoped></style>
