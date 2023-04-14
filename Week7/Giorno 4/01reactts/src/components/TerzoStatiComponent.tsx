import React, { FC, useState } from 'react';
import { Persona } from '../interfaces/Persona';


const TerzoStatiComponent: FC<Persona> = (props: Persona) => {

    const [nome, setNome] = useState<string | null | undefined>(props.nome);
    const [cognome, setCognome] = useState<string | null | undefined>(props.cognome);

    const modificaValore = () => {
        setCognome("fewfe")
    }

    return (
        <>
            <h1>Ciao {nome}, {cognome}</h1>
            <button onClick={modificaValore}>Clicca</button>
        </>
    )
}

export default TerzoStatiComponent;