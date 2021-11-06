import request from '@/utils/request'

// 查询专项知识库列表
export function listSpecial(query) {
  return request({
    url: '/knowledge/special/list',
    method: 'get',
    params: query
  })
}

// 查询专项知识库详细
export function getSpecial(informid) {
  return request({
    url: '/knowledge/special/' + informid,
    method: 'get'
  })
}

// 新增专项知识库
export function addSpecial(data) {
  return request({
    url: '/knowledge/special',
    method: 'post',
    data: data
  })
}

// 修改专项知识库
export function updateSpecial(data) {
  return request({
    url: '/knowledge/special',
    method: 'put',
    data: data
  })
}

// 删除专项知识库
export function delSpecial(informid) {
  return request({
    url: '/knowledge/special/' + informid,
    method: 'delete'
  })
}

// 导出专项知识库
export function exportSpecial(query) {
  return request({
    url: '/knowledge/special/export',
    method: 'get',
    params: query
  })
}