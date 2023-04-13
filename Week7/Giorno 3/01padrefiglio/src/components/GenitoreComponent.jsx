import React, { useState } from 'react';
import FiglioComponent from './FiglioComponent';

function GenitoreComponent() {

    const [contatore, setContatore] = useState(0);

    const eventoGenitore = () => {
        console.log("Sono la funzione del genitore")

        setContatore(contatore + 1)
    }

    return (
        <>
            <h1>{contatore}</h1>
            <FiglioComponent saluta={eventoGenitore} cont={contatore} />
        </>
    );
}

export default GenitoreComponent;