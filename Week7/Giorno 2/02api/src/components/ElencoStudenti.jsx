import React, { Component } from 'react';
import RigaStudente from './RigaStudente';

class ElencoStudenti extends Component {
    constructor(props) {
        super(props);

        this.state = {
            elenco: []
        }
    }

    componentDidMount() {
        fetch("http://localhost:8080/studente/all")
            .then(res => res.json())
            .then(dati => {
                this.setState((state, props) => { return { elenco: dati} })
            })
            .catch(err => console.log(err))
    }

    render() { 
        return (
            <>
                <table className='table table-striped'>
                    <thead>
                        <tr>
                            <th>Nominativo</th>
                            <th>Matricola</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.elenco.map((obj, idx) => (
                            <tr>
                                <RigaStudente key={idx} studente={obj}/>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </>
        );
    }
}
 
export default ElencoStudenti;