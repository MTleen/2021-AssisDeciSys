import request from '@/utils/request'

// 查询出警记录表列表
export function listRecord(query) {
  return request({
    url: '/knowledge/record/list',
    method: 'get',
    params: query
  })
}

// 查询出警记录表详细
export function getRecord(cautionid) {
  return request({
    url: '/knowledge/record/' + cautionid,
    method: 'get'
  })
}

// 新增出警记录表
export function addRecord(data) {
  return request({
    url: '/knowledge/record',
    method: 'post',
    data: data
  })
}

// 修改出警记录表
export function updateRecord(data) {
  return request({
    url: '/knowledge/record',
    method: 'put',
    data: data
  })
}

// 删除出警记录表
export function delRecord(cautionid) {
  return request({
    url: '/knowledge/record/' + cautionid,
    method: 'delete'
  })
}

// 导出出警记录表
export function exportRecord(query) {
  return request({
    url: '/knowledge/record/export',
    method: 'get',
    params: query
  })
}