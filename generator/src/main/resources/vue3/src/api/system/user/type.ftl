export  interface  ResponseData{
    code: number
    message: string
}

export interface User{//用户数据类型
    id?: number
    username?: string
    password?:string
    name?: string
    phone?: null
    createTime?: string
    status?:number| boolean
}
export type Records = User[]
export interface UserResponseData extends ResponseData {//用户页数据类型
    data: {
        records: Records
        total: number
        size: number
        current: number
        pages: number
    }
}

export interface RoleData {//角色类型
    id?: number
    createTime?: string
    updateTime?: string
    roleName: string
    roleCode?:string
}
export type AllRole = RoleData[]
export interface AllRoleResponseData extends ResponseData {
    data: {
        allRolesList: AllRole//全部角色类型
        assginRoleList: AllRole//设置角色类型
    }
}
export interface SetRoleData {
    roleIdList: number[]
    userId: number
}
