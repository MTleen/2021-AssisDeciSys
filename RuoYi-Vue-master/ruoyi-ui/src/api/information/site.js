import request from '@/utils/request'

// 查询队站信息列表
export function listSite(query) {
  return request({
    url: '/information/site/list',
    method: 'get',
    params: query
  })
}

// 查询队站信息详细
export function getSite(siteid) {
  return request({
    url: '/information/site/' + siteid,
    method: 'get'
  })
}

// 新增队站信息
export function addSite(data) {
  return request({
    url: '/information/site',
    method: 'post',
    data: data
  })
}

// 修改队站信息
export function updateSite(data) {
  return request({
    url: '/information/site',
    method: 'put',
    data: data
  })
}

// 删除队站信息
export function delSite(siteid) {
  return request({
    url: '/information/site/' + siteid,
    method: 'delete'
  })
}

// 导出队站信息
export function exportSite(query) {
  return request({
    url: '/information/site/export',
    method: 'get',
    params: query
  })
}