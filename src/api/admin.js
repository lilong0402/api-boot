import axios from '@/utils/axios'

export function getInfo() {
  console.log("getInfo被执行了")
  return axios.post('/sys/user/info')
}

export function rePassword(data) {
  return axios.post('/sys/user/password', data)
}
