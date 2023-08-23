import router from '@/router'
import setting from './setting'
import nprogress from 'nprogress'
import 'nprogress/nprogress.css'
import pinia from './store'
import useUserStore from './store/modules/user'
nprogress.configure({ showSpinner: false })
const userStore = useUserStore(pinia)
// 全局前置守卫
router.beforeEach(async (to, from, next) => {
    console.log(from)
    document.title = to.meta.title + ` | ${r"${"}setting.title${r"}"}`
    nprogress.start()
    const token = userStore.token
    const username = userStore.username
    if (token) {
        if (to.path === '/login') {
            next({ path: '/' })
        } else {
            if (username) {
                next()
            } else {
                try {
                    await userStore.userInfo() //刷新的时候是异步路由，有可能获取到用户信息，异步路由还没有加载完毕，出现空白效果
                    next({ ...to }) //先不放行，先保留路由信息在放行
                } catch (error) {
                    await userStore.userLogout()
                    next({ path: '/login', query: { redirect: to.path } })
                }
            }
        }
    } else {
        if (to.path == '/login') {
            next()
        } else {
            next({ path: '/login', query: { redirect: to.path } })
        }
    }
})
// 全局后置守卫

// eslint-disable-next-line @typescript-eslint/no-unused-vars
router.afterEach((route) => {
    console.log(route)
    nprogress.done()
})
