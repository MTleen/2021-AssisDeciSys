import request from '@/utils/request'

// 查询消防车类型管理列表
export function listTrucktype(query) {
  return request({
    url: '/information/trucktype/list',
    method: 'get',
    params: query
  })
}

// 查询消防车类型管理详细
export function getTrucktype(typeid) {
  return request({
    url: '/information/trucktype/' + typeid,
    method: 'get'
  })
}

// 新增消防车类型管理
export function addTrucktype(data) {
  return request({
    url: '/information/trucktype',
    method: 'post',
    data: data
  })
}

// 修改消防车类型管理
export function updateTrucktype(data) {
  return request({
    url: '/information/trucktype',
    method: 'put',
    data: data
  })
}

// 删除消防车类型管理
export function delTrucktype(typeid) {
  return request({
    url: '/information/trucktype/' + typeid,
    method: 'delete'
  })
}

// 导出消防车类型管理
export function exportTrucktype(query) {
  return request({
    url: '/information/trucktype/export',
    method: 'get',
    params: query
  })
}