import request from '@/utils/request'

const api_name = '/admin/system/sysUser'

export default {

  getPageList(page, limit, searchObj) {
    return request({
      url: `${r"${"}api_name${r"}"}/${r"${"}page${r"}"}/${r"${"}limit${r"}"}`,
      method: 'get',
      params: searchObj // url查询字符串或表单键值对
    })
  },
  getById(id) {
    return request({
      url: `${r"${"}api_name${r"}"}/get/${r"${"}id${r"}"}`,
      method: 'get'
    })
  },

  save(role) {
    return request({
      url: `${r"${"}api_name${r"}"}/save`,
      method: 'post',
      data: role
    })
  },

  updateById(role) {
    return request({
      url: `${r"${"}api_name${r"}"}/update`,
      method: 'put',
      data: role
    })
  },
  removeById(id) {
    return request({
      url: `${r"${"}api_name${r"}"}/remove/${r"${"}id${r"}"}`,
      method: 'delete'
    })
  },
  updateStatus(id, status) {
    return request({
      url: `${r"${"}api_name${r"}"}/updateStatus/${r"${"}id${r"}"}/${r"${"}status${r"}"}`,
      method: 'get'
    })
  }
}
