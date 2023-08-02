export interface LoginFormData {
    username?: string
    password?: string
}

export interface ResponseData {
    code?: number
    message?: string
}
export  interface  LoginResponseData extends  ResponseData{
    data:{
        token?:string
    }
}
export interface  UserInfoResponseData extends  ResponseData{
   data:{
       button:[],
       role:[],
       name:string,
       avatar:string,
       routers:[{
           routeName:string,
           component:string
           children:[
               { routeName: string }
           ]
       }]

   }

}
