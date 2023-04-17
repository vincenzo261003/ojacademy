import { Ad } from "../interfaces/ad.interface"
import { Response } from "../interfaces/response.interface"

export function getAll(): Promise<Response<Ad[]>>{
    const requestOption = {
        method: "GET",
        headers: {"Content-Type": "application/json"}
    }

    return fetch("http://172.16.237.206:8080/Annunci", requestOption).then(res => res.json())
}