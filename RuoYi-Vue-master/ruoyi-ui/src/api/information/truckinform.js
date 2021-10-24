import request from '@/utils/request'

// 查询消防车信息管理列表
export function listTruckinform(query) {
  return request({
    url: '/information/truckinform/list',
    method: 'get',
    params: query
  })
}

// 查询消防车信息管理详细
export function getTruckinform(license) {
  return request({
    url: '/information/truckinform/' + license,
    method: 'get'
  })
}

// 新增消防车信息管理
export function addTruckinform(data) {
  return request({
    url: '/information/truckinform',
    method: 'post',
    data: data
  })
}

// 修改消防车信息管理
export function updateTruckinform(data) {
  return request({
    url: '/information/truckinform',
    method: 'put',
    data: data
  })
}

// 删除消防车信息管理
export function delTruckinform(license) {
  return request({
    url: '/information/truckinform/' + license,
    method: 'delete'
  })
}

// 导出消防车信息管理
export function exportTruckinform(query) {
  return request({
    url: '/information/truckinform/export',
    method: 'get',
    params: query
  })
}