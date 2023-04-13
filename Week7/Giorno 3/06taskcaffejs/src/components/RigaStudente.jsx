import React, { useContext } from 'react';
import GestioneCaffeContext from './GestioneCaffeContext';

function RigaStudente(props) {

    const {elimina } = useContext(GestioneCaffeContext);


    const { codice, nome, cognome, caffe, moltiplicatori } = props.studente;

    const tastoElimina = (varCodice) => {
        elimina(varCodice);
    }

    return (
        <>
            <tr>
                <td>{codice}</td>
                <td>{nome}</td>
                <td>{cognome}</td>
                <td>{caffe}</td>
                <td>{moltiplicatori}</td>
                <td></td>
                <td>
                    <button type="button" className="btn btn-danger" onClick={() => tastoElimina(codice)}>Elimina</button>
                </td>
            </tr>
        </>
    );
}

export default RigaStudente;