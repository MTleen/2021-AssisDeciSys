import request from '@/utils/request'

// 查询岗位信息表管理列表
export function listUserposition(query) {
  return request({
    url: '/information/userposition/list',
    method: 'get',
    params: query
  })
}

// 查询岗位信息表管理详细
export function getUserposition(positionid) {
  return request({
    url: '/information/userposition/' + positionid,
    method: 'get'
  })
}

// 新增岗位信息表管理
export function addUserposition(data) {
  return request({
    url: '/information/userposition',
    method: 'post',
    data: data
  })
}

// 修改岗位信息表管理
export function updateUserposition(data) {
  return request({
    url: '/information/userposition',
    method: 'put',
    data: data
  })
}

// 删除岗位信息表管理
export function delUserposition(positionid) {
  return request({
    url: '/information/userposition/' + positionid,
    method: 'delete'
  })
}

// 导出岗位信息表管理
export function exportUserposition(query) {
  return request({
    url: '/information/userposition/export',
    method: 'get',
    params: query
  })
}