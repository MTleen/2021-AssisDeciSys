import request from '@/utils/request'

// 查询反馈表列表
export function listFeedback(query) {
  return request({
    url: '/knowledge/feedback/list',
    method: 'get',
    params: query
  })
}

// 查询反馈表详细
export function getFeedback(feedid) {
  return request({
    url: '/knowledge/feedback/' + feedid,
    method: 'get'
  })
}

// 新增反馈表
export function addFeedback(data) {
  return request({
    url: '/knowledge/feedback',
    method: 'post',
    data: data
  })
}

// 修改反馈表
export function updateFeedback(data) {
  return request({
    url: '/knowledge/feedback',
    method: 'put',
    data: data
  })
}

// 删除反馈表
export function delFeedback(feedid) {
  return request({
    url: '/knowledge/feedback/' + feedid,
    method: 'delete'
  })
}

// 导出反馈表
export function exportFeedback(query) {
  return request({
    url: '/knowledge/feedback/export',
    method: 'get',
    params: query
  })
}