import request from "@/utils/request.ts";
import {RoleData,RoleResponseData,MenuResponseData} from "./type.ts";
enum API{
   GETROLELIST_URL="/admin/system/sysRole/" ,//获取角色
   REMOVELIST_URL="/admin/system/sysRole/batchRemove",//批量删除角色
   REMOVEROLE_URL="/admin/system/sysRole/remove/",//根据id删除
   ADDROLE_URL="/admin/system/sysRole/save",//增加角色
   UPDATEROLE_URL="/admin/system/sysRole/update",//修改角色信息
   GETMENULIST_URL="/admin/system/sysMenu/toAssign/",//根据id获取菜单信息
   SETMENULIST_URL="/admin/system/sysMenu/doAssign"//修改菜单权限
}

export const getRoleList = (page: number, limit: number, roleName: string) =>
    request.get<any, RoleResponseData>(
        API.GETROLELIST_URL + `${r"${"}page${r"}"}/${r"${"}limit${r"}"}/?roleName=${r"${"}roleName${r"}"}`,
    )
export const reqAddOrUpdateRole = (data: RoleData) => {
   if (data.id) {
      return request.put<any, any>(API.UPDATEROLE_URL, data)
   } else {
      return request.post<any, any>(API.ADDROLE_URL, data)
   }
}
export const RemoveRole = (roleId: number) =>
    request.delete<any, any>(API.REMOVEROLE_URL + roleId)

export const getMenuList = (roleId: number) =>
    request.get<any, MenuResponseData>(API.GETMENULIST_URL + roleId)

export const setMenuList = (roleId: number, permissionId: number[]) =>
    request.post(
        API.SETMENULIST_URL ,{roleId,menuIdList:permissionId},
    )
export const RemoveList = (idList: number[]) =>
    request.delete(API.REMOVELIST_URL, { data: idList })
