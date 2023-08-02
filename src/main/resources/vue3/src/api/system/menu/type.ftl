export  interface  ResponseData{
    code:number,
    message:string
}


export interface  Permission {
    id: number|string
    icon:string
    type:number
    name:string
    path:string
    parentId:number|string
    parentName?:string
    status:number|boolean
    children?:PermissionList[]
    routeName?:string
    component:string
    createTime?:string
    updateTime?:string
    sortValue:number
    select?:boolean
    perms?:string|null
}
export type PermissionList = Permission[]


export interface PermissionResponseData extends ResponseData {
    data: PermissionList
}



