import { router, addRoutes } from '@/router'
// 全局前置导航守卫
let hasGetInfo = false
router.beforeEach(async (to, from, next) => {
  // 显示全局进度条
  showFullLoading()

  const token = getToken()
  // 没有登录，强制跳转回登录页
  if (!token && to.path != '/login') {
    toast('请先登录', 'error')
    return next({ path: '/login' })
  }

  // 防止重复登录
  if (token && to.path == '/login') {
    toast('请勿重复登录', 'error')
    return next({ path: from.path ? from.path : '/' })
  }

  if (to.path == '/login') {
    hasGetInfo = false
  }

  const { getStoreInfo } = useAdminStore()

  //  如果登录了，就获取用户信息（三部分内容），存储到 pinia
  let hasNewRoutes = false
  if (token && !hasGetInfo) {
    console.log('come')
    const res = await getStoreInfo()
    hasGetInfo = true
    // 动态添加路由
    hasNewRoutes = addRoutes(res.nav)
  }

  // 设置页面标题
  let title = '后台系统-' + to.meta.title ? to.meta.title : ''
  document.title = title

  hasNewRoutes ? next(to.fullPath) : next()
})

// 全局后置守卫
router.afterEach(() => hideFullLoading())
