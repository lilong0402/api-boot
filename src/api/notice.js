import axios from '@/utils/axios'


export function getNoticePage(page, limit, title) {
  console.log("准备执行notice")
	return axios.get(`/sys/notice/page?page=${page}&limit=${limit}&title=${title}`)
}


export function saveNotice(data) {
  return axios.post('/sys/notice', data)
}

export function updateNotice(data) {
  return axios.put('/sys/notice', data)
}

export function deleteNotice(ids) {
  ids = !Array.isArray(ids) ? [ids] : ids
  return axios.post('/sys/notice/delete', ids)
}
