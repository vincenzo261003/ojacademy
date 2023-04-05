function generaCodice(length) {
    let result = '';
    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    const charactersLength = characters.length;
    let counter = 0;
    while (counter < length) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
      counter += 1;
    }
    
    document.getElementById("inputCod").value = result;
}

function inserisci(){
    let elenco = localStorage.getItem("articoli") != null ? JSON.parse(localStorage.getItem("articoli")) : [];

    let tipo = document.getElementById("inputTipo").value;
    let nome = document.getElementById("inputNome").value;
    let desc = document.getElementById("inputDesc").value;
    let codice = document.getElementById("inputCod").value;
    let prezzo = document.getElementById("inputPrez").value;

    if (!checkValues(tipo, nome, desc, codice, prezzo)){
        error();
        return;
    }

    let articolo = {
        tipo,
        nome,
        desc,
        codice,
        prezzo
    }

    elenco.push(articolo);
    localStorage.setItem("articoli", JSON.stringify(elenco));
    success();
}

function checkValues(tipo, nome, desc, codice, prezzo) {
    if (tipo == "" || nome == "" || desc == "" || codice == "")
        return false;

    if (tipo != "Rivista" && tipo != "Libro" && tipo != "Giocattolo")
        return false;
    
    if (Number(prezzo) < 0)
        return false;
    
    if (checkDuplicates(codice))
        return false;

    return true;
}

function checkDuplicates(codice){
    let elenco = localStorage.getItem("articoli") != null ? JSON.parse(localStorage.getItem("articoli")) : [];

    for (let x of elenco){
        if (x.codice == codice)
            return true;
    }

    return false;
}

function error() {
    document.getElementById("error").classList.toggle("d-none");
    setTimeout(()=>{
        document.getElementById("error").classList.toggle("d-none")
    }, 3000);
    clearValues();
}

function success() {
    document.getElementById("success").classList.toggle("d-none");
    setTimeout(()=>{
        document.getElementById("success").classList.toggle("d-none")
    }, 3000);
    clearValues();
}

function clearValues(){
    document.getElementById("inputNome").value = "";
    document.getElementById("inputDesc").value = "";
    document.getElementById("inputCod").value = "";
    document.getElementById("inputPrez").value = "";
}