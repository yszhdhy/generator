import request from '@/utils/request.ts'
import  type{
    LoginFormData,
    LoginResponseData,
    UserInfoResponseData
} from './type.ts'
enum API{
    LOGIN_URL = '/admin/system/index/login',
    USERINFO_URL = '/admin/system/index/info',
    LOGOUT_URL = '/admin/system/index/logout',
}

export  const reqLogin=(data:LoginFormData)=>
    request.post<any,LoginResponseData>(API.LOGIN_URL,data)

export  const reqUserInfo=()=>
    request.get<any, UserInfoResponseData>(API.USERINFO_URL)

export  const reqLogOut=()=>
    request.post<any,any>(API.LOGOUT_URL)

