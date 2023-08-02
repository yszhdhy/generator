import {defineStore} from 'pinia'
import {anyRoute, constantRoute} from '@/router/routes'

import {UserState} from "@/store/modules/types/types.ts";
import {reqLogin, reqLogOut, reqUserInfo} from "@/api/user";
import {LoginFormData, LoginResponseData, UserInfoResponseData} from "@/api/user/type.ts";
import {GET_TOKEN, REMOVE_TOKEN, SET_TOKEN} from "@/utils/token.ts";
import Layout from '@/layout/index.vue'
import ParentView from '@/components/ParentView/index.vue'
import router from "@/router";

const modules = import.meta.glob("../../views/**/**.vue")

const _import=(file:string)=>{
    return modules[`../../views/${r"${"}file${r"}"}.vue`]
}

function filterAsyncRoute(asyncRouterMap: any) {
    return asyncRouterMap.filter( (route: any) => {
        if (route.component) {
            if (route.component === 'layout/index') {
                route.component = Layout
            } else if (route.component === 'ParentView') {
                route.component = ParentView
            } else {
                route.component=_import(route.component)
                if(route.component==undefined){
                    route.component= ParentView
                }
            }
        }
        if (route.children && route.children.length > 0) {
            route.children = filterAsyncRoute(route.children)
        } else {
            delete route.children
        }
        return true
    })
}

const useUserStore = defineStore('User', {
    // 小仓库存储数据的地方
    state: (): UserState => {
    return {
        token:GET_TOKEN()!,
        menuRoutes: constantRoute,
        username: '',
        avatar: '',
        buttons: [],
}
},
    // 异步|逻辑的地方
    actions: {
    async userLogin(data: LoginFormData) {
        const res: LoginResponseData = await reqLogin(data)
        // success=>token
        // error=>error.message
        if (res.code === 200) {
            this.token = res.data.token as string
            // // 持久化
            SET_TOKEN(res.data.token as string)
            return 'ok'
        } else {
            return Promise.reject(new Error(res.data as string))
        }
    },
    async userInfo() {
        const res: UserInfoResponseData = await reqUserInfo()
        if (res.code === 200) {
            this.avatar=res.data.avatar
            this.username=res.data.name
            const userAsyncRoute=filterAsyncRoute(res.data.routers)
            console.log(...userAsyncRoute)
            this.menuRoutes=[...constantRoute,...userAsyncRoute,anyRoute]
            ;[...userAsyncRoute,anyRoute].forEach((route: any) => {
                router.addRoute(route)
            })
            console.log(this.menuRoutes)
            console.log(router.getRoutes())
            return 'ok'
        } else {
            return Promise.reject(new Error(res.message))
        }
    },
    async userLogout() {
        const res = await reqLogOut()
        console.log(res)
        if (res.code === 200) {
            this.token = ''
            this.username = ''
            this.avatar = ''
            REMOVE_TOKEN()
        } else {
            return Promise.reject(new Error(res.message))
        }
    },

},
getters: {},
})

export default useUserStore
