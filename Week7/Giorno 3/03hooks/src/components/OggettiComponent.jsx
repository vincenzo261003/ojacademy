import React, { useReducer } from 'react';

function OggettiComponent() {

    /*
    let action = {
        type: "...",
        payload: {}
    }
    */

    function reducer(state, action) {
        switch (action.type){
            case "ADD_ITEM":
                return [...state, action.payload]
                break;
            case "REMOVE_ITEM":
                return state.filter((item) => item != action.payload)
                break;
            default:
                return state;
        }
    }

    const [items, dispatch] = useReducer( reducer, []);

    const inserisciOggetto = (evt) => {
        evt.preventDefault();

        const ogg = evt.target.inputOggetto.value;

        dispatch({type: "ADD_ITEM", payload: ogg})

        console.log(ogg);
    }

    return (
        <>
            <form onSubmit={inserisciOggetto}>
                <input type="text" name="inputOggetto" />
                <button type='submit'>Inserisci</button>
            </form>

            <ul>
                {items.map((obj, idx) => (
                    <li key={idx}>{obj}</li>
                ))}
            </ul>
        </>
    );
}

export default OggettiComponent;