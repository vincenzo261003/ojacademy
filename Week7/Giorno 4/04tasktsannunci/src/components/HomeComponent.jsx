import * as React from 'react';
import AnnuncioComponent from './AnnuncioComponent';
import Context from './Context';

function HomeComponent() {

    const { elenco, aggiorna } = React.useContext(Context);

    React.useEffect(() => {
        aggiorna();
    }, [])

    return (
        <>
            <h1>Elenco annunci</h1>
            <table className="table table-striped">
                <thead>
                    <th>Codice</th>
                    <th>Titolo</th>
                    <th>Descrizione</th>
                    <th>Data inserimento</th>
                    <th>Autore</th>
                </thead>
                <tbody>
                    {elenco.map((obj, idx) => (
                        <AnnuncioComponent key={idx} annuncio={obj} />
                    ))}
                </tbody>
            </table>
        </>
    );
}

export default HomeComponent;