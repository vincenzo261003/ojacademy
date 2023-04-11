import React from 'react';
import ElementoComponent from './ElementoComponent';

const automobili = [
    "BMW",
    "Lamborghini",
    "Maserati",
    "Fiat",
    "Mazda"
]

function Listacomponent(props) {
    return ( 
        <ul>
            {automobili.map((obj, idx) => <ElementoComponent key={idx} indice={idx} auto={obj} />)}
        </ul>
    );
}

export default Listacomponent;