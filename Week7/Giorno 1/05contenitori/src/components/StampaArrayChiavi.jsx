import React from 'react';
import { Component } from 'react';

class StampaArrayChiavi extends Component {
    constructor(props) {
        super(props);

        this.automobili = [
            "BMW",
            "Lamborghini",
            "Maserati",
            "Fiat",
            "Mazda"
        ]
    }
    
    render() { 
        const elenco = (
            <ul>
                {this.automobili.map((obj, idx) => <li key={idx}>{obj}</li>)}
            </ul>
        )

        return (
            // <ul>
            //     {this.automobili.map((auto) => <li>{auto}</li>)}
            // </ul>
            <>
                {elenco}
            </>
        );
    }
}
 
export default StampaArrayChiavi;