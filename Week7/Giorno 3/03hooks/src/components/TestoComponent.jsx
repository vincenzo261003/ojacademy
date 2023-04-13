import React from 'react';
import { useRef } from 'react';

function TestoComponent() {

    const inputRef = useRef(null);

    const verificaTesto = () => {
        //inputRef.current.focus();
        console.log(inputRef.current.value)
    }

    return (
        <>
            <label htmlFor="inputTesto">Inserisci il testo</label>
            <input type="text" name="inputTesto" id="inputTesto" ref={inputRef} />
            <button onClick={verificaTesto}>Inserisci</button>
        </>
    );
} 

export default TestoComponent;