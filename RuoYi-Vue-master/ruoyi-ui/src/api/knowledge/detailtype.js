import request from '@/utils/request'

// 查询详细类型表列表
export function listDetailtype(query) {
  return request({
    url: '/knowledge/detailtype/list',
    method: 'get',
    params: query
  })
}

// 查询详细类型表详细
export function getDetailtype(typeid) {
  return request({
    url: '/knowledge/detailtype/' + typeid,
    method: 'get'
  })
}

// 新增详细类型表
export function addDetailtype(data) {
  return request({
    url: '/knowledge/detailtype',
    method: 'post',
    data: data
  })
}

// 修改详细类型表
export function updateDetailtype(data) {
  return request({
    url: '/knowledge/detailtype',
    method: 'put',
    data: data
  })
}

// 删除详细类型表
export function delDetailtype(typeid) {
  return request({
    url: '/knowledge/detailtype/' + typeid,
    method: 'delete'
  })
}

// 导出详细类型表
export function exportDetailtype(query) {
  return request({
    url: '/knowledge/detailtype/export',
    method: 'get',
    params: query
  })
}