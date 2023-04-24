<template>
	<el-card shadow="never" class="border-0">
		<!-- 新建/刷新 -->
		<div class="f-between mb-4">
			<div>
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

		<el-table :data="tableData" stripe v-loading="loading" class="w-full">
			<el-table-column label="用户名" prop="username" />
			<el-table-column label="登录ip" prop="ip" />
			<el-table-column label="登录地点" prop="address" />
			<el-table-column label="登录设备" prop="userAgent" />
			<el-table-column label="登录状态" prop="status" />
			<el-table-column label="操作信息" prop="operation" />
			<el-table-column label="创建时间" prop="createTime" />
			<el-table-column label="操作" width="200" align="center">
				<el-button type="primary" size="small">修改</el-button>
				<el-button type="danger" size="small">删除</el-button>
			</el-table-column>
		</el-table>

		<div class="f-center mt-5">
			<el-pagination
				:total="total"
				:current-page="currentPage"
				:page-size="limit"
				@current-change="getData"
				layout="prev, pager, next"
			/>
		</div>
	</el-card>
</template>

<script setup>
import { useLogLogin } from '../../composables/useLogLogin'

const { tableData, loading, currentPage, total, limit, getData } = useLogLogin()
</script>

<style scoped></style>
