//let elenco = ["A", "B", "C"];

// for (let item of elenco)
//     console.log(item);

// for (let [idx, item] of elenco.entries())
//     console.log(idx, item);

// console.log(elenco);
// elenco.push("D");
// console.log(elenco);

// elenco.splice(1, 1)
// console.log(elenco)

// console.table(elenco)

// let persona = ["Mario", "Rossi", 20];
// console.log(persona)

// let persona = {
//     nome: "Mario",
//     cognome: "Rossi",
//     eta: 20
// };

// persona.nascita = "2022-01-01";

// console.log(persona)
// console.log(persona.nome)

// console.table(persona)


let elenco = [
    {
        nome: "Mario",
        cognome: "Rossi",
        eta: 20
    },
    {
        nome: "Mario",
        cognome: "Rossi",
        eta: 20,
        data: "2022-01-01"
    },
    {
        nome: "Mario",
        cognome: "Rossi",
        eta: 20
    }
];

for (let item of elenco){
    console.log(item.nome, item.cognome, item.eta, item.data)
}