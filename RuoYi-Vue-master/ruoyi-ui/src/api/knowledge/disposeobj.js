import request from '@/utils/request'

// 查询处置对象列表
export function listDisposeobj(query) {
  return request({
    url: '/knowledge/disposeobj/list',
    method: 'get',
    params: query
  })
}

// 查询处置对象详细
export function getDisposeobj(objid) {
  return request({
    url: '/knowledge/disposeobj/' + objid,
    method: 'get'
  })
}

// 新增处置对象
export function addDisposeobj(data) {
  return request({
    url: '/knowledge/disposeobj',
    method: 'post',
    data: data
  })
}

// 修改处置对象
export function updateDisposeobj(data) {
  return request({
    url: '/knowledge/disposeobj',
    method: 'put',
    data: data
  })
}

// 删除处置对象
export function delDisposeobj(objid) {
  return request({
    url: '/knowledge/disposeobj/' + objid,
    method: 'delete'
  })
}

// 导出处置对象
export function exportDisposeobj(query) {
  return request({
    url: '/knowledge/disposeobj/export',
    method: 'get',
    params: query
  })
}