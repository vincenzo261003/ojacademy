import React from 'react';

function Passaggioparametri(props) {
    console.log(props)

    return ( 
        <>
        <h1>Ciao {props.nome}, {props.cognome}</h1>
        </>
     );
}

export default Passaggioparametri;