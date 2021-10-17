import request from '@/utils/request'

// 查询提示信息表列表
export function listKnowledge(query) {
  return request({
    url: '/knowledge/knowledge/list',
    method: 'get',
    params: query
  })
}

// 查询提示信息表详细
export function getKnowledge(informid) {
  return request({
    url: '/knowledge/knowledge/' + informid,
    method: 'get'
  })
}

// 新增提示信息表
export function addKnowledge(data) {
  return request({
    url: '/knowledge/knowledge',
    method: 'post',
    data: data
  })
}

// 修改提示信息表
export function updateKnowledge(data) {
  return request({
    url: '/knowledge/knowledge',
    method: 'put',
    data: data
  })
}

// 删除提示信息表
export function delKnowledge(informid) {
  return request({
    url: '/knowledge/knowledge/' + informid,
    method: 'delete'
  })
}

// 导出提示信息表
export function exportKnowledge(query) {
  return request({
    url: '/knowledge/knowledge/export',
    method: 'get',
    params: query
  })
}