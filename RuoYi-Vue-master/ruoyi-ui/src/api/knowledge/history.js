import request from '@/utils/request'

// 查询历史表列表
export function listHistory(query) {
  return request({
    url: '/knowledge/history/list',
    method: 'get',
    params: query
  })
}

// 查询历史表详细
export function getHistory(index) {
  return request({
    url: '/knowledge/history/' + index,
    method: 'get'
  })
}

// 新增历史表
export function addHistory(data) {
  return request({
    url: '/knowledge/history',
    method: 'post',
    data: data
  })
}

// 修改历史表
export function updateHistory(data) {
  return request({
    url: '/knowledge/history',
    method: 'put',
    data: data
  })
}

// 删除历史表
export function delHistory(index) {
  return request({
    url: '/knowledge/history/' + index,
    method: 'delete'
  })
}

// 导出历史表
export function exportHistory(query) {
  return request({
    url: '/knowledge/history/export',
    method: 'get',
    params: query
  })
}