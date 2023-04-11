import React from 'react';

function ProdottoComponent(props) {
    const {prodotti} = props;
    const {nome, descrizione, quantita, udm} = prodotti;

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