import request from '@/utils/request'

// 查询详细类型表列表
export function sendMessage(data) {
  return request({
    url: '/knowledge/match/distribution',
    method: 'post',
    data: data
  })
}
