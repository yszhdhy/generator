export  interface  ResponseData{
    code: number
    message: string
}

export interface RoleData {//角色数据类型
    id?: number
    createTime?: string
    updateTime?: string
    roleName: string
    roleCode?:string
}

export type Records = RoleData[]
export interface RoleResponseData extends ResponseData {//角色页数据类型
    data: {
        records: Records
        total: number
        size: number
        current: number
        pages: number
    }
}

export interface MenuData {//菜单数据类型
    id: number
    createTime: string
    updateTime: string
    name: string
    path:string
    component:string
    icon:string
    type: number
    status: null
    select:boolean
    routeName:string
    perms?:null | string
    sortValue:number,
    children?:[]
}

export type MenuList = MenuData[]

export interface MenuResponseData extends ResponseData {
    data: MenuList //菜单数据类型
}
