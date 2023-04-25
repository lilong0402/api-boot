import axios from "@/utils/axios";

export function getStatistics1() {
    return axios.get('/sys/index/statistics1')
}

export function getStatistics2() {
    return axios.get('/sys/index/statistics2')
}

export function getStatistics3(){
    return axios.get('/sys/index/statistics3')
}
