import React, { Component } from 'react';

class RigaComponent extends Component {
    constructor(props) {
        super(props);

        this.persona = new Object(); // {}
        this.persona.nome = props.nome ? props.nome : "N.D.";
        this.persona.cognome = props.cognome ? props.cognome : "N.D.";
        this.persona.eta = props.eta ? props.eta : "N.D.";
    }
    
    render() { 
        return (
            <tr>
                <td>{this.persona.nome}</td>
                <td>{this.persona.cognome}</td>
                <td>{this.persona.eta}</td>
            </tr>
        );
    }
}
 
export default RigaComponent;