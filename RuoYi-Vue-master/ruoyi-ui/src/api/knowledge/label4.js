import request from '@/utils/request'

// 查询四级标签列表
export function listLabel4(query) {
  return request({
    url: '/knowledge/label4/list',
    method: 'get',
    params: query
  })
}

// 查询四级标签详细
export function getLabel4(labelid) {
  return request({
    url: '/knowledge/label4/' + labelid,
    method: 'get'
  })
}

// 新增四级标签
export function addLabel4(data) {
  return request({
    url: '/knowledge/label4',
    method: 'post',
    data: data
  })
}

// 修改四级标签
export function updateLabel4(data) {
  return request({
    url: '/knowledge/label4',
    method: 'put',
    data: data
  })
}

// 删除四级标签
export function delLabel4(labelid) {
  return request({
    url: '/knowledge/label4/' + labelid,
    method: 'delete'
  })
}

// 导出四级标签
export function exportLabel4(query) {
  return request({
    url: '/knowledge/label4/export',
    method: 'get',
    params: query
  })
}