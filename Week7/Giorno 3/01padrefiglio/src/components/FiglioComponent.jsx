import React, { useEffect } from 'react';

function FiglioComponent(props) {

    const cliccaPulsante = () => {
        console.log("Il figlio ha cliccato")

        props.saluta();
    }

    useEffect(() => {
        console.log("Effetto")
    }, []);

    return (
        <>
        <h1>Contatore: {props.cont}</h1>
        <button onClick={cliccaPulsante}>Clicca</button>
        </>
    );
}

export default FiglioComponent;