import React from 'react';
import FlamerComponent from './FlamerComponent';

const elenco = [
    {
        nome: "Giovanni",
        cognome: "Pace",
        rateo: 99
    },
    {
        nome: "Valerio",
        cognome: "IBM",
        rateo: 9
    },
    {
        nome: "Matteo",
        cognome: "Freim",
        rateo: 8
    },
    {
        nome: "Francesco",
        cognome: "Avvocato",
        rateo: 7
    },
    {
        nome: "Mattia",
        cognome: "Rickshaw",
        rateo: 6
    }
]

function ElencoFlamerComponent() {
    return (
        <div className='container mt-5'>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>Flame/giorno</th>
                    </tr>
                </thead>
                <tbody>
                    {elenco.map((obj, idx) => <FlamerComponent key={idx} persona={obj} />)}
                </tbody>
            </table>
        </div>
    );
}

export default ElencoFlamerComponent;