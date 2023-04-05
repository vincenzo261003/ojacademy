function stampa(){
    let corpoTabella = "";
    let elenco = localStorage.getItem("articoli") != null ? JSON.parse(localStorage.getItem("articoli")) : [];

    for (let item of elenco){
        corpoTabella += `
            <tr>
                <td>${item.codice}</td>
                <td>${item.tipo}</td>
                <td>${item.nome}</td>
                <td>${item.desc}</td>
                <td>${item.prezzo}</td>
                <td>
                    <button type="button" class="btn btn-block btn-warning" onclick="update('${item.codice}')">Aggiorna</button>
                    <button type="button" class="btn btn-block btn-danger" onclick="elimina('${item.codice}')">Elimina</button>
                </td>
            </tr>
        `
    }



    document.getElementById("tablebody").innerHTML = corpoTabella;
}

stampa();

function elimina(codice){
    let elenco = localStorage.getItem("articoli") != null ? JSON.parse(localStorage.getItem("articoli")) : [];

    for (let [idx, item] of elenco.entries()){
        if (item.codice == codice){
            elenco.splice(idx, 1);
            break;
        }
    }

    localStorage.setItem("articoli", JSON.stringify(elenco));
    stampa();
    return;
}

function update(codice){
    let elenco = localStorage.getItem("articoli") != null ? JSON.parse(localStorage.getItem("articoli")) : [];

    for (let [idx, item] of elenco.entries()){
        if (item.codice == codice){
            elenco.splice(idx, 1);
            break;
        }
    }

    localStorage.setItem("articoli", JSON.stringify(elenco));
    stampa();
    return;
}

function checkValues(tipo, nome, desc, codice, prezzo) {
    if (tipo == "" || nome == "" || desc == "" || codice == "")
        return false;

    if (tipo != "Rivista" && tipo != "Libro" && tipo != "Giocattolo")
        return false;
    
    if (Number(prezzo) < 0)
        return false;

    return true;
}

`
<div class="row">
    <div class="col">

        <h1 class="mb-3">Aggiornamento articolo</h1>

        <div class="form-group">
            <label for="inputTipo">Tipo</label>
            <select name="inputTipo" id="inputTipo" class="form-control">
                <option value="Rivista">Rivista</option>
                <option value="Libro">Libro</option>
                <option value="Giocattolo">Giocattolo</option>
            </select>
        </div>

        <div class="form-group">
            <label for="inputNome">Nome</label>
            <input type="text" id="inputNome" class="form-control" placeholder="Inserisci il nome"/>
        </div>

        <div class="form-group">
            <label for="inputDesc">Descrizione</label>
            <input type="text" id="inputDesc" class="form-control" placeholder="Inserisci la descrizione"/>
        </div>

        <div class="form-group">
            <label for="inputPrez">Prezzo</label>
            <input type="number" min="0" id="inputPrez" class="form-control" placeholder="Inserisci il prezzo"/>
        </div>

        <button type="button" class="btn btn-primary btn-block" onclick="aggiorna()">Salva</button>

    </div>
</div>
`