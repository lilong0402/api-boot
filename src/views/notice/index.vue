<script setup>
const { tableData, loading, currentPage, total, limit, getData, handleDelete } = useInitTable({
  getList: getNoticePage,
  delete: deleteNotice
})

const { formDrawerRef, formRef, form, rules, drawerTitle, handleSubmit, handleCreate, handleEdit } = useInitForm({
  form: {
    title: '',
    content: ''
  },
  rules: {
    title: [
      {
        required: true,
        message: '通知标题不能为空',
        trigger: 'blur'
      }
    ],
    content: [
      {
        required: true,
        message: '通知内容不能为空',
        trigger: 'blur'
      }
    ]
  },
  getData,
  update: updateNotice,
  create: saveNotice
})
</script>

<template>
  <el-card shadow="never" class="border-0">
    <!-- 新增|刷新 -->
    <ListHeader @create="handleCreate" @refresh="getData" />

    <el-table :data="tableData" stripe v-loading="loading" class="w-full">
      <el-table-column prop="title" label="通知标题" />
      <el-table-column prop="content" label="通知内容" />
      <el-table-column prop="createTime" label="发布时间" width="380" />
      <el-table-column label="操作" width="180" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click="handleEdit(scope.row)" v-permission="['sys:notice:update']"
            >修改</el-button
          >
          <el-popconfirm
            title="是否要删除该通知？"
            confirmButtonText="确认"
            cancelButtonText="取消"
            @confirm="handleDelete(scope.row.id)"
          >
            <template #reference>
              <el-button v-permission="['sys:notice:delete']" size="small" class="bg-red-400 text-light-50"
                >删除</el-button
              >
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <div class="fixed bottom-8 left-[45%]">
      <el-pagination
        background
        layout="prev, pager ,next"
        :total="total"
        :current-page="currentPage"
        :page-size="limit"
        @current-change="getData"
      />
    </div>

    <FormDrawer ref="formDrawerRef" :title="drawerTitle" @submit="handleSubmit">
      <el-form :model="form" ref="formRef" :rules="rules" label-width="80px" :inline="false">
        <el-form-item label="通知标题" prop="title">
          <el-input v-model="form.title" placeholder="通知标题"></el-input>
        </el-form-item>
        <el-form-item label="通知内容" prop="content">
          <el-input v-model="form.content" placeholder="通知内容" type="textarea" :rows="5"></el-input>
        </el-form-item>
      </el-form>
    </FormDrawer>
  </el-card>
</template>
