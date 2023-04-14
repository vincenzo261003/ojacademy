import React, { useState } from 'react';

const ProviderComponent = ({children}) => {

    const [elenco, aggiornaElenco] = useState([]);

    const aggiorna = () => {
        fetch("http://localhost:8080/annunci/all")
            .then(res => res.json())
            .then(dati => {
                aggiornaElenco(dati)
            })
            .catch(err => console.log(err))
    }
 
    return (
        <ProviderComponent.Provider value={ {elenco, aggiorna} }>
            {children}
        </ProviderComponent.Provider>
    )
}

export default ProviderComponent;