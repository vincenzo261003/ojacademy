/*
Dato il seguente array, eliminare tutti gli elementi che hanno un'età compresa tra 30 e 40 anni.
*/

let elenco = [
    {
        nome: "Giovanni",
        cognome: "Pace",
        eta: 36
    },
    {
        nome: "Mario",
        cognome: "Rossi",
        eta: 38,
        data_nascita: "01/01/2022"
    },
    {
        nome: "Valeria",
        cognome: "Verdi",
        eta: 42
    },
    {
        nome: "Marika",
        cognome: "Mariko",
        eta: 25
    },
]

function pulisci(x){
    for (let i = 0; i < x.length; i++) {
        if (x[i].eta > 30 && x[i].eta < 40) {
            x.splice(i, 1);
            i--; 
        }
    }
    return x;
}

console.log(pulisci(elenco))