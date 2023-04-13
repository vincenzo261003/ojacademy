import React, { useContext, useEffect } from 'react';
import BottoneAggiungi from './BottoneAggiungi';
import GestioneCaffeContext from './GestioneCaffeContext';
import RigaStudente from './RigaStudente';

function ElencoStudenti() {

    const { elenco, aggiorna } = useContext(GestioneCaffeContext);

    useEffect(() => {
        aggiorna();
    }, [])

    return (
        <>
            <div className="row mb-4">
                <div className="col-9">
                    <h1>Lista caffé shuanni</h1>
                </div>
                <div className="col-3">
                    <BottoneAggiungi />
                </div>
            </div>
            <table className="table table-striped table-dark">
                <thead>
                    <tr>
                        <th>Codice</th>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>Caffe</th>
                        <th>Moltiplicatori</th>
                    </tr>
                </thead>
                <tbody>
                    {elenco.map((obj, idx) => (
                        <RigaStudente key={idx} studente={obj} />
                    ))}
                </tbody>
            </table>
        </>
    );
}

export default ElencoStudenti;