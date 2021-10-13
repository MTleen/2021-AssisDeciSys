import request from '@/utils/request'

// 查询详细类型表列表
export function listDetailType(query) {
  return request({
    url: '/system/DetailType/list',
    method: 'get',
    params: query
  })
}

// 查询详细类型表详细
export function getDetailType(typeid) {
  return request({
    url: '/system/DetailType/' + typeid,
    method: 'get'
  })
}

// 新增详细类型表
export function addDetailType(data) {
  return request({
    url: '/system/DetailType',
    method: 'post',
    data: data
  })
}

// 修改详细类型表
export function updateDetailType(data) {
  return request({
    url: '/system/DetailType',
    method: 'put',
    data: data
  })
}

// 删除详细类型表
export function delDetailType(typeid) {
  return request({
    url: '/system/DetailType/' + typeid,
    method: 'delete'
  })
}

// 导出详细类型表
export function exportDetailType(query) {
  return request({
    url: '/system/DetailType/export',
    method: 'get',
    params: query
  })
}
