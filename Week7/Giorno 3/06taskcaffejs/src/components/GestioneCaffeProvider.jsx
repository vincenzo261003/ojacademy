import React, { useState } from 'react';
import GestioneCaffeContext from './GestioneCaffeContext';

const GestioneCaffeProvider = ({children}) => {

    const [elenco, aggiornaElenco] = useState([]);

    const aggiorna = () => {
        fetch("http://localhost:8080/caffe/all")
            .then(res => res.json())
            .then(dati => {
                aggiornaElenco(dati)
            })
            .catch(err => console.log(err))
    } 

    const elimina = (varCodice) => {
        fetch("http://localhost:8080/caffe/" + varCodice, {
                method: "DELETE"
            })
            .then(res => res.json())
            .then(dati => {
                if (dati)
                    aggiorna()
                else
                    alert("Errore")
            })
            .catch(err => console.log(err))
    }


    return (
        <GestioneCaffeContext.Provider value={ {elenco, aggiorna, elimina} }>
            {children}
        </GestioneCaffeContext.Provider>
    )
}

export default GestioneCaffeProvider;