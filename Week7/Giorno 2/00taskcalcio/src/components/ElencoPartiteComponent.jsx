import React from 'react';
import PartitaComponent from './PartitaComponent';

const elenco = [
    {
        s1: "Napoli",
        s2: "Milan"
    },
    {
        s1: "Inter",
        s2: "Fiorentina"
    },
    {
        s1: "Palermo",
        s2: "Juventus"
    }
]

function ElencoPartiteComponent() {
    return (
        <div className='container mt-5'>
            {elenco.map((obj, idx) => <PartitaComponent key={idx} partita={obj} />)}
        </div>
    );
}

export default ElencoPartiteComponent;