function saluta(){
    console.log("Ciao")
}

function iscrivi(){
    var nome = document.getElementById("inputNome").value
    console.log(nome)

    document.getElementById("risultato").innerText = "Ciao " + nome;

}