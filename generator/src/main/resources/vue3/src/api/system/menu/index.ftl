import request from "@/utils/request.ts";
import  {Permission,PermissionResponseData}  from './type.ts'
enum  API {
     GETMENULIST_URL="/admin/system/sysMenu/findNodes",
     REMOVEMENU_URL="/admin/system/sysMenu/remove/",
     ADDMENU_URL="/admin/system/sysMenu/save",
     UPDATEMENU_URL="/admin/system/sysMenu/update"
}

export const getMenuList = () =>
    request.get<any, PermissionResponseData>(API.GETMENULIST_URL)

export const reqAddOrUpdateMenu = (data: Permission) => {
     if (data.id!='') {
          return request.put<any, any>(API.UPDATEMENU_URL, data)
     } else {
          return request.post<any, any>(API.ADDMENU_URL, data)
     }
}

export const RemoveMenu = (id: number) =>
    request.delete<any, any>(API.REMOVEMENU_URL + id)

