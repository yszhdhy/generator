import request from "@/utils/request.ts";

import {SetRoleData, UserResponseData,User,AllRoleResponseData} from "./type.ts";
enum API{
      GETPAGELIST_URL="/admin/system/sysUser/",//获取用户信息
      REMOVEUSER_URL="/admin/system/sysUser/remove/",//删除用户
      ADDUSER_URL="/admin/system/sysUser/save",//增加用户
      UPDATEUSER_URL="/admin/system/sysUser/update",//修改用户信息
      SETUSERROLE_URL="/admin/system/sysRole/doAssign",//设置用户角色
      GETUSERROLE_URL="/admin/system/sysRole/toAssign/",//获取用户角色
      UPDATESTATUS_URL="/admin/system/sysUser/updateStatus/"//修改用户状态
}

export  const getPageList=(page:number,limit:number,keyword:string)=>
      request.get<any,UserResponseData>(API.GETPAGELIST_URL+`${r"${"}page${r"}"}/${r"${"}limit${r"}"}/?keyword=${r"${"}keyword${r"}"}`)

export const reqAddOrUpdateUser = (data: User) => {
      if (data.id) {
            return request.put<any, any>(API.UPDATEUSER_URL, data)
      } else {
            return request.post<any, any>(API.ADDUSER_URL, data)
      }
}

export const  getUserRoles=(userId:number)=>
      request.get<any,AllRoleResponseData>(API.GETUSERROLE_URL+userId)

export  const setUserRole=(data:SetRoleData)=>
      request.post<any,any>(API.SETUSERROLE_URL,data)

export  const reqRemove=(userId:number)=>
     request.delete<any,any>(API.REMOVEUSER_URL+userId)

export  const reqUpdateStatus= (userId: number , status: number)=>
    request.get<any,any>(API.UPDATESTATUS_URL+`${r"${"}userId${r"}"}/${r"${"}status${r"}"}`)
