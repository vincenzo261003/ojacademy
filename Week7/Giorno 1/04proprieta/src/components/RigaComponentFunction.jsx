import React from 'react';

function RigaComponentFunction(props) {
    const { nome, cognome, eta } = props;

    return (
        <tr>
            <td>{nome ? nome : "N.D."}</td>
            <td>{cognome ? cognome : "N.D."}</td>
            <td>{eta ? eta : "N.D."}</td>
        </tr>
    );
}

export default RigaComponentFunction;