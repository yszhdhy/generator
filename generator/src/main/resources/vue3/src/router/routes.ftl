export  const constantRoute=[
    {
        path: '/',
        component:()=>import('@/layout/index.vue'),
        name:'Layout',
        hidden:false,
        meta:{
           title:'',

        },
        redirect:'/dashboard',
        children:[
            {
                path: '/dashboard',
                component:()=>import('@/views/dashboard/index.vue'),
                name:"Dashboard",
                hidden: false,
                meta: {
                    title: '首页',
                    icon:"HomeFilled"
                },
            }
        ]
    },
    {
        path: '/login',
        component: () => import('@/views/login/index.vue'),
        name: 'Login',
        hidden: true,
        meta: {
            title: '登录',
        },
    },
    {
        path: '/404',
        component: () => import('@/views/404/index.vue'),
        name: '404',
        hidden: true,
        meta: {
            title: '404',
        },
    }

]
export const anyRoute = {
    path: '/:pathMatch(.*)*',
    redirect: '/404',
    name: 'Any',
    hidden: true,
    meta: {
        title: '任意路由',
    },
}
