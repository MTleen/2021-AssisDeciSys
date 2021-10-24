import request from '@/utils/request'

// 查询队站信息管理列表
export function listDept(query) {
  return request({
    url: '/information/dept/list',
    method: 'get',
    params: query
  })
}

// 查询队站信息管理详细
export function getDept(deptId) {
  return request({
    url: '/information/dept/' + deptId,
    method: 'get'
  })
}

// 新增队站信息管理
export function addDept(data) {
  return request({
    url: '/information/dept',
    method: 'post',
    data: data
  })
}

// 修改队站信息管理
export function updateDept(data) {
  return request({
    url: '/information/dept',
    method: 'put',
    data: data
  })
}

// 删除队站信息管理
export function delDept(deptId) {
  return request({
    url: '/information/dept/' + deptId,
    method: 'delete'
  })
}

// 导出队站信息管理
export function exportDept(query) {
  return request({
    url: '/information/dept/export',
    method: 'get',
    params: query
  })
}