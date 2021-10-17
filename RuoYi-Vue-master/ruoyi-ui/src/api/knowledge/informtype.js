import request from '@/utils/request'

// 查询提示信息类型表列表
export function listInformtype(query) {
  return request({
    url: '/knowledge/informtype/list',
    method: 'get',
    params: query
  })
}

// 查询提示信息类型表详细
export function getInformtype(typeid) {
  return request({
    url: '/knowledge/informtype/' + typeid,
    method: 'get'
  })
}

// 新增提示信息类型表
export function addInformtype(data) {
  return request({
    url: '/knowledge/informtype',
    method: 'post',
    data: data
  })
}

// 修改提示信息类型表
export function updateInformtype(data) {
  return request({
    url: '/knowledge/informtype',
    method: 'put',
    data: data
  })
}

// 删除提示信息类型表
export function delInformtype(typeid) {
  return request({
    url: '/knowledge/informtype/' + typeid,
    method: 'delete'
  })
}

// 导出提示信息类型表
export function exportInformtype(query) {
  return request({
    url: '/knowledge/informtype/export',
    method: 'get',
    params: query
  })
}