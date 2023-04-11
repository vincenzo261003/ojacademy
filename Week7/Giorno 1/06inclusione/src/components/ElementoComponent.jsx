import React from 'react';
import './ElementoComponent.css'

function ElementoComponent(props) {
    const {auto, indice} = props;

    return (
        <>
            <li className='tc'>{indice} - {auto}</li>
        </>
    );
}

export default ElementoComponent;