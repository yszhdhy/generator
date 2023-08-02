import request from '@/utils/request'

const api_name = '/admin/system/sysRole'

export default {
    //角色列表-条件分页查询
    getPageList(current,limit,searchObj) {
        return request({
            url: `${r"${"}api_name${r"}"}/${r"${"}current${r"}"}/${r"${"}limit${r"}"}`,
method: 'get',
            //如果普通对象参数写法 params:对象参数名称
            //如果使用json格式传递，data:对象参数名称
            params:searchObj
        })
    },
    //角色删除
    removeById(id) {
        return request({
            url: `${r"${"}api_name${r"}"}/remove/${r"${"}id${r"}"}`,
            method: 'delete'
        })
    },
    //角色添加
    saveRole(role) {
        return request({
            url: `${r"${"}api_name${r"}"}/save`,
            method: 'post',
            data:role
        })
    },
    //根据id查询
    getById(id) {
        return request({
          url: `${r"${"}api_name${r"}"}/get/${r"${"}id${r"}"}`,
          method: 'get'
        })
    },
    //修改
    updateById(role) {
        return request({
            url: `${r"${"}api_name${r"}"}/update`,
            method: 'put',
            data: role
        })
    },
    //批量删除
    batchRemove(idList) {
        return request({
            url: `${r"${"}api_name${r"}"}/batchRemove`,
            method: 'delete',
            data: idList
        })
    },
    getRoles(adminId) {
        return request({
          url: `${r"${"}api_name${r"}"}/toAssign/${r"${"}adminId${r"}"}`,
          method: 'get'
        })
      },

    assignRoles(assginRoleVo) {
        return request({
            url: `${r"${"}api_name${r"}"}/doAssign`,
            method: 'post',
            data: assginRoleVo
        })
    }
}
