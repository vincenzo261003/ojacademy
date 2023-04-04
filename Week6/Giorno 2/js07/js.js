let elencoStudenti = [
    {
        nome: "Giovanni",
        cognome: "Pace",
        matricola: "AB36"
    },
    {
        nome: "Mario",
        cognome: "Rossi",
        matricola: "AB38",
    },
    {
        nome: "Valeria",
        cognome: "Verdi",
        matricola: "AB42"
    },
    {
        nome: "Marika",
        cognome: "Mariko",
        matricola: "AB25"
    },
]

function elimina(varMatricola){

    for(let [idx, item] of elencoStudenti.entries()){
        if(item.matricola === varMatricola){
            elencoStudenti.splice(idx, 1)
            
            stampaStudenti();
            return;
        }
    }

}

function stampaStudenti(){
    let corpoTabella = "";

    for(let [idx, item] of elencoStudenti.entries()){
        corpoTabella += `
            <tr>
                <td>${item.nome}</td>
                <td>${item.cognome}</td>
                <td>${item.matricola}</td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="elimina('${item.matricola}')">Eli.</button>
                </td>
            </tr>
        `
    }

    document.getElementById("corpo-tabella").innerHTML = corpoTabella;
}

function inserisci(){
    let nome = document.getElementById("inputNome").value;
    let cogn = document.getElementById("inputCognome").value;
    let matr = document.getElementById("inputMatricola").value;

    let studente = {
        nome: nome,
        cognome: cogn,
        matricola: matr
    }

    elencoStudenti.push(studente)
    stampaStudenti()

    document.getElementById("inputNome").value = "";
    document.getElementById("inputCognome").value = "";
    document.getElementById("inputMatricola").value = "";
}


stampaStudenti();