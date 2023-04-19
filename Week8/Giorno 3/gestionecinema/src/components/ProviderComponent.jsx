import React, { useState } from 'react';
import Context from './Context';

const ProviderComponent = ({children}) => {

    const url = "https://deploy.braintech.app/cinema/cinema.php?access_key=1dada2bece5869c689bf638a31b7f809";
    const imgurl = "https://secure.webtic.it/angwt/";

    const [elenco, aggiornaElenco] = useState([]);

    const aggiorna = () => {
        fetch(url)
            .then(res => res.json())
            .then(dati => {
                aggiornaElenco(dati);
            })
            .catch(err => console.log(err))
    }

    const getImgUrl = (code) => {
        return imgurl + code;
    }  
 
    return (
        <Context.Provider value={ {elenco, aggiorna, getImgUrl} }>
            {children}
        </Context.Provider>
    )
}

export default ProviderComponent;