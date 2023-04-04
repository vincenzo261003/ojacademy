function controlla() {
    var temp = document.getElementById("inputNome").value;

    if (isNaN(temp) || temp > 42 || temp < 34){
        document.getElementById("risultato").innerText = "Formato errato";
        return;
    }

    console.log(temp)

    if (temp < 37.5)
        document.getElementById("risultato").innerText = "Ammesso";
    else
        document.getElementById("risultato").innerText = "Non ammesso";

}
