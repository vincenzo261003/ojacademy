import React from 'react';

function ProdottoComponent(props) {
    const {prodotto} = props;
    const {nome, descrizione, quantita, udm} = prodotto;

    return (
        <tr>
            <td>{nome}</td>
            <td>{descrizione}</td>
            <td>{quantita}</td>
            <td>{udm}</td>
        </tr>
    );
}

export default ProdottoComponent;