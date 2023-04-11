import React from 'react';

function FlamerComponent(props) {
    const {persona} = props;
    const {nome, cognome, rateo} = persona;

    return (
        <>
            <tr>
                <td>{nome}</td>
                <td>{cognome}</td>
                <td>{rateo}</td>
            </tr>
        </>
    );
}

export default FlamerComponent;