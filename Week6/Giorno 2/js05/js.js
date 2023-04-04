function salva(){
    let nome = document.getElementById("inputNome").value;
    let cognome = document.getElementById("inputCognome").value;
    let matricola = document.getElementById("inputMatricola").value;

    let riga = `<tr>
                    <td>${nome}</td>
                    <td>${cognome}</td>
                    <td>${matricola}</td>
                </tr>`;

    document.getElementById("bodytable").innerHTML += riga;
}