import request from '@/utils/request'

// 查询险情类型列表
export function listDisastertype(query) {
  return request({
    url: '/knowledge/disastertype/list',
    method: 'get',
    params: query
  })
}

// 查询险情类型详细
export function getDisastertype(typeid) {
  return request({
    url: '/knowledge/disastertype/' + typeid,
    method: 'get'
  })
}

// 新增险情类型
export function addDisastertype(data) {
  return request({
    url: '/knowledge/disastertype',
    method: 'post',
    data: data
  })
}

// 修改险情类型
export function updateDisastertype(data) {
  return request({
    url: '/knowledge/disastertype',
    method: 'put',
    data: data
  })
}

// 删除险情类型
export function delDisastertype(typeid) {
  return request({
    url: '/knowledge/disastertype/' + typeid,
    method: 'delete'
  })
}

// 导出险情类型
export function exportDisastertype(query) {
  return request({
    url: '/knowledge/disastertype/export',
    method: 'get',
    params: query
  })
}