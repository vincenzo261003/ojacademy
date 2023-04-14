import * as React from 'react';
import { Studente } from '../interfaces/Studente';
import axios from 'axios';
import InserisciComponent from './InserisciComponent';

interface Props {

}

const ElencoStudentiComponent : React.FC = (props : Props) => {

    const [elenco, setElenco] = React.useState<Studente[]>([]);

    React.useEffect(() => {
        aggiornaTabella();
    }, [])
    
    const aggiornaTabella = () => {
        axios.get<Studente[]>("http://localhost:8080/studente/all")
        .then((res) => {
            setElenco(res.data);
        });
    }

    return (
        <>
            <InserisciComponent aggiorna={aggiornaTabella} />
            <table className="table table-striped">
                <thead>
                    <th>Nominativo</th>
                    <th>Matricola</th>
                </thead>
                <tbody>
                    {elenco.map((obj, idx) => (
                        <tr>
                            <td>{obj.matricola}</td>
                            <td>{obj.nominativo}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    )

}

export default ElencoStudentiComponent;