import React, { Component } from 'react';

export default class PassaggioParametriClasse extends Component {
    
    constructor (props){
        super(props);
        console.log(props)
        this.persona = "SDAD";
        // props.x = 2 non si può 
    }

    render() { 
        console.log(this.persona)
        return (
            <>
                <h1>{this.props.nome}, {this.props.cognome}, {this.props.eta}</h1>
            </>
        );
    }
}