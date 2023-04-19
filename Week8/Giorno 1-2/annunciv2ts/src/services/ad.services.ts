import { Ad } from "../interfaces/ad.interface"
import { Response } from "../interfaces/response.interface"
import { User } from "../interfaces/user.interface"

export function getAll(): Promise<Response<Ad[]>>{
    const requestOption = {
        method: "GET",
        headers: {"Content-Type": "application/json"}
    }

    return fetch("http://172.16.237.206:8080/Annunci", requestOption).then(res => res.json())
}

export function getByCode(code : string | undefined) : Promise<Response<Ad>> {
    const requestOption = {
        method: "GET",
        headers: {"Content-Type": "application/json"}
    }

    return fetch("http://172.16.237.206:8080/Annunci/" + code, requestOption).then(res => res.json())
}

export function doLogin(username: string, pass: string) : Promise<Response<User>> {
    const requestOption = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username,pass})
    }

    return fetch("http://172.16.237.206:8080/Annunci/utente/login", requestOption).then(res => res.json())
}

export function doSignin(username: string, pass: string,telefono: string, email: string) : Promise<Response<User>>{
    const requestOption={
        method:"POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username , pass,telefono, email})
    }

    return fetch("http://172.16.237.206:8080/Annunci/utente/signUp",requestOption).then(res=>res.json())
}