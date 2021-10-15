import request from '@/utils/request'

// 查询规则表列表
export function listRule(query) {
  return request({
    url: '/knowledge/rule/list',
    method: 'get',
    params: query
  })
}

// 查询规则表详细
export function getRule(ruleid) {
  return request({
    url: '/knowledge/rule/' + ruleid,
    method: 'get'
  })
}

// 新增规则表
export function addRule(data) {
  return request({
    url: '/knowledge/rule',
    method: 'post',
    data: data
  })
}

// 修改规则表
export function updateRule(data) {
  return request({
    url: '/knowledge/rule',
    method: 'put',
    data: data
  })
}

// 删除规则表
export function delRule(ruleid) {
  return request({
    url: '/knowledge/rule/' + ruleid,
    method: 'delete'
  })
}

// 导出规则表
export function exportRule(query) {
  return request({
    url: '/knowledge/rule/export',
    method: 'get',
    params: query
  })
}