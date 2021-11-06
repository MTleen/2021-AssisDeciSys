import request from '@/utils/request'

// 查询安全知识库列表
export function listSecurity(query) {
  return request({
    url: '/knowledge/security/list',
    method: 'get',
    params: query
  })
}

// 查询安全知识库详细
export function getSecurity(informid) {
  return request({
    url: '/knowledge/security/' + informid,
    method: 'get'
  })
}

// 新增安全知识库
export function addSecurity(data) {
  return request({
    url: '/knowledge/security',
    method: 'post',
    data: data
  })
}

// 修改安全知识库
export function updateSecurity(data) {
  return request({
    url: '/knowledge/security',
    method: 'put',
    data: data
  })
}

// 删除安全知识库
export function delSecurity(informid) {
  return request({
    url: '/knowledge/security/' + informid,
    method: 'delete'
  })
}

// 导出安全知识库
export function exportSecurity(query) {
  return request({
    url: '/knowledge/security/export',
    method: 'get',
    params: query
  })
}