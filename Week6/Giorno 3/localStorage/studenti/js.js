function inserisci(){
    let elenco = localStorage.getItem("elenco") != null ? JSON.parse(localStorage.getItem("elenco")) : [];

    let nome = document.getElementById("inputNome").value;
    let cognome = document.getElementById("inputCognome").value;
    let matricola = document.getElementById("inputMatricola").value;

    let studente = {
        nome,
        cognome,
        matricola
    }

    elenco.push(studente);
    localStorage.setItem("elenco", JSON.stringify(elenco));
    stampa();

    document.getElementById("inputNome").value = "";
    document.getElementById("inputCognome").value = "";
    document.getElementById("inputMatricola").value = "";
}

function stampa(){
    let corpoTabella = "";
    let elenco = localStorage.getItem("elenco") != null ? JSON.parse(localStorage.getItem("elenco")) : [];
    for (let [idx, item] of elenco.entries()){
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

setInterval(stampa(), 1000)