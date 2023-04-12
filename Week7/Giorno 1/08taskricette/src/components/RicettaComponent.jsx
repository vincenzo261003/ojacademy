import React from 'react';
import ProdottoComponent from './ProdottoComponent';

function RicettaComponent(props) {
    const ricetta = props;

    const {nome, prodotti} = ricetta.ricetta;

    console.log(prodotti)

    return (
        <>
        <h1 className='mt-4'>{nome}</h1>
        <table className="table table-striped">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrizione</th>
                    <th>Quantità</th>
                    <th>Unità di misura</th>
                </tr>
            </thead>
            <tbody>
                {prodotti.map((obj, idx) => <ProdottoComponent key={idx} prodotti={obj} />)}
            </tbody>
        </table>
        </>
    );
}

export default RicettaComponent;