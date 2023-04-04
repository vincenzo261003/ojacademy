function saluta() {
    console.log("ciao");
}

const saluta = () => {
    console.log("ciao");
}

saluta();


const salutaParametri = (nome, cognome) => {
    console.log(nome + " " +  cognome)
}

salutaParametri("prova", "uno");


setTimeout(()=>{
    console.log("test")
}, 3000);


setInterval(()=>{
    console.log("ciao")
}, 1000)