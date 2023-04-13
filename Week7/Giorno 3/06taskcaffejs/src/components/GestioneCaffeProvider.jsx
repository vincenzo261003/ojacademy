import React, { useState } from 'react';
import GestioneCaffeContext from './GestioneCaffeContext';

const GestioneCaffeProvider = ({children}) => {

    const [showModal, setShowModal] = useState(0);

    const mostra = (opzione) => {
        setShowModal(opzione)
    }

    return (
        <GestioneCaffeContext.Provider value={ {mostra} }>
            {children}
        </GestioneCaffeContext.Provider>
    )
}

export default GestioneCaffeProvider;