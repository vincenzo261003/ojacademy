import React from 'react';

const elenco = [
    {
        id: 2,
        nome: "Giovanni"
    },
    {
        id: 12,
        nome: "Valerio"
    },
    {
        id: 122,
        nome: "Mario"
    },
    {
        id: 23,
        nome: "Marika"
    }
]

function ElencoComponent() {

    const cliccato = (indice) => {
        console.log("Hai cliccato " + indice)
    }

    return (
        <>
            <h1>Elenco</h1>
            <ul>
                {elenco.map((obj,idx) => (
                    <li key={idx} onClick={() => cliccato(obj.id)}>{obj.nome}</li>
                ))}
            </ul>
        </>
    );
}

export default ElencoComponent;