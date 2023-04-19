import { NavigateFunction } from "react-router-dom";
import { User } from "./user.interface";

export interface Ad {
    titolo: string,
    codice: string,
    testo: string,
    publicazione: string,
    utente: User,
    navigate: NavigateFunction
}