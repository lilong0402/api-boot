import axios from "@/utils/axios";
// import { type } from "windicss/utils";

export function getStatistics1() {
    return axios.get('/sys/index/statistics1')
}

export function getStatistics2(type) {
    return axios.get('/sys/index/statistics2?type='+type)
}

export function getStatistics3(){
    return axios.get('/sys/index/statistics3')
}
