import * as React from 'react';

interface Persona{
    nome?: string, //Stessa cosa di sotto, nullable
    cognome: string | null | undefined;
}

const SecondoParametriComponent: React.FC<Persona> = (props: Persona) => {

    //let test: [string, string, number] = ["a", "b", 11]

    return (
        <>
            <h1>Ciao {props.nome} {props.cognome}</h1>
        </>
    )
}

export default SecondoParametriComponent;