import { User } from "./user.interface";

export interface Ad {
    titolo: string,
    codice: string,
    testo: string,
    pubblicazione: string,
    utente: User;
}