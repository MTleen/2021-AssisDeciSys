import request from '@/utils/request'

// 查询权限表管理列表
export function listAdmin(query) {
  return request({
    url: '/information/admin/list',
    method: 'get',
    params: query
  })
}

// 查询权限表管理详细
export function getAdmin(adminid) {
  return request({
    url: '/information/admin/' + adminid,
    method: 'get'
  })
}

// 新增权限表管理
export function addAdmin(data) {
  return request({
    url: '/information/admin',
    method: 'post',
    data: data
  })
}

// 修改权限表管理
export function updateAdmin(data) {
  return request({
    url: '/information/admin',
    method: 'put',
    data: data
  })
}

// 删除权限表管理
export function delAdmin(adminid) {
  return request({
    url: '/information/admin/' + adminid,
    method: 'delete'
  })
}

// 导出权限表管理
export function exportAdmin(query) {
  return request({
    url: '/information/admin/export',
    method: 'get',
    params: query
  })
}