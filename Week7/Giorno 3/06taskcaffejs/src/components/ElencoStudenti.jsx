import React from 'react';
import BottoneAggiungi from './BottoneAggiungi';

function ElencoStudenti() {
    return (
        <>
            <div class="row mb-4">
                <div class="col-9">
                    <h1>Lista caffé shuanni</h1>
                </div>
                <div class="col-3">
                    <BottoneAggiungi />
                </div>
            </div>
            <table class="table table-striped table-dark">
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

                </tbody>
            </table>
        </>
    );
}

export default ElencoStudenti;