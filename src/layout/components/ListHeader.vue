<script setup>
import { computed } from 'vue'

const props = defineProps({
  layout: {
    type: String,
    default: 'create,delete,refresh'
  }
})

const btns = computed(() => props.layout.split(','))

defineEmits(['create', 'refresh', 'delete'])
</script>

<template>
  <div class="f-between mb-4">
    <div>
      <el-button
        v-if="btns.includes('create')"
        type="primary"
        size="small"
        class="px-5 py-4 rounded-full"
        @click="$emit('create')"
        >新增数据
      </el-button>
      <el-popconfirm
        v-if="btns.includes('delete')"
        title="是否要删除选中记录"
        confirm-button-text="确认"
        cancel-button-text="取消"
        @confirm="$emit('delete')"
      >
        <template #reference>
          <el-button type="danager" size="small" class="px-5 py-4 rounded-full">批量删除</el-button>
        </template>
        <el-button type="link"></el-button>
      </el-popconfirm>
    </div>
    <div>
      <el-tooltip effect="dark" content="刷新数据" placement="top">
        <el-button size="small" text @click="$emit('refresh')">
          <el-icon :size="15">
            <Refresh />
          </el-icon>
        </el-button>
      </el-tooltip>
    </div>
  </div>
</template>

<style lang="scss" scoped></style>
