import * as React from 'react';
import { Studente } from '../interfaces/Studente';
import axios from 'axios';
import { Form, Button } from 'react-bootstrap'


interface Props {
    aggiorna: aggiornaTabella
}

type aggiornaTabella = () => void;

const InserisciComponent : React.FC<Props> = (props : Props) => {

    const nominativo = React.useRef<HTMLInputElement>(null);
    const matricola = React.useRef<HTMLInputElement>(null);

    const inserisci = () => {
        const studente = {
            nominativo: nominativo.current?.value,
            matricola: matricola.current?.value
        }

        if (studente.nominativo && studente.matricola && studente.matricola?.length <= 10){
            axios.post<boolean>("http://localhost:8080/studente", studente)
                .then((res) => {
                    props.aggiorna();
                    if (matricola.current)
                        matricola.current.value=""
                    if (nominativo.current)
                        nominativo.current.value=""
                    alert("OK")
                })
        }else
            alert("KO")
    }

    return (
        <>
            <Form.Group>
                <Form.Label>Nominativo</Form.Label>
                <Form.Control type='text' ref={nominativo}/>
            </Form.Group>

            <Form.Group>
                <Form.Label>Matricola</Form.Label>
                <Form.Control type='text' ref={matricola}/>
            </Form.Group>

            <Button className='my-3' onClick={inserisci}>Salva</Button>
        </>
    )

}

export default InserisciComponent;