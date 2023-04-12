import React, { Component } from 'react';

class RigaStudente extends Component {
    constructor(props) {
        super(props);
        this.studente = props.studente;
    }

    render() { 

        const {nominativo, matricola} = this.studente;

        return (
            <>
                <td>{nominativo}</td>
                <td>{matricola}</td>
            </>
        );
    }
}
 
export default RigaStudente;