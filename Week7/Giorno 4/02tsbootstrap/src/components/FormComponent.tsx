import React, { useRef } from 'react';
import { Form, Button } from 'react-bootstrap'

interface Props{

}

const FormComponent: React.FC = (props: Props) => {

    const inputNome = useRef<HTMLInputElement>(null);
    const inputCognome = useRef<HTMLInputElement>(null);

    const inserisci = () => {
        console.log(inputCognome.current?.value)
        console.log(inputCognome.current?.value)
    }

    return (
        <>
            <Form.Group>
                <Form.Label>Nome</Form.Label>
                <Form.Control type='text' ref={inputNome}/>
            </Form.Group>

            <Form.Group>
                <Form.Label>Cognome</Form.Label>
                <Form.Control type='text' ref={inputCognome}/>
            </Form.Group>

            <Button onClick={inserisci}>Cliccami</Button>
        </>
    )
}

export default FormComponent;