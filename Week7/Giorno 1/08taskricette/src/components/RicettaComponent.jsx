import React from 'react';
import ProdottoComponent from './ProdottoComponent';

function RicettaComponent(props) {
    const ricetta = props;

    return (
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
                {ricetta.map((obj, idx) => <ProdottoComponent key={idx} prodotto={obj} />)}
            </tbody>
        </table>
    );
}

export default RicettaComponent;