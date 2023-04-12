import React from 'react';
import RicettaComponent from './RicettaComponent';

const elenco = [
    {
        nome: "Tortilla",
        prodotti: [
            {
                nome: "Uova",
                descrizione: "Uova biologiche",
                quantita: 2,
                udm: "pz"
            },
            {
                nome: "Patata",
                descrizione: "Patata nostrana",
                quantita: 500,
                udm: "g"
            }
        ]
    },
    {
        nome: "Pasta aglio e olio",
        prodotti: [
            {
                nome: "Pasta",
                descrizione: "Pasta artigianale",
                quantita: 500,
                udm: "g"
            },
            {
                nome: "Olio",
                descrizione: "Olio casereccio",
                quantita: 0.2,
                udm: "l"
            }
        ]
    }
]

function ListaRicetteComponent(props) {
    return (
        <div className='container mt-5'>
            {elenco.map((obj, idx) => <RicettaComponent key={idx} ricetta={obj} />)}
        </div>
    );
}

export default ListaRicetteComponent;