import React, { Component } from 'react';
import SquadraComponent from './SquadraComponent';
import SquadraComponent2 from './SquadraComponent2';

class PartitaComponent extends Component {
    constructor(props) {
        super(props);

        this.squadre = props.partita;
    }

    componentDidMount(){
        
    }

    state = {  }
    render() { 
        return (
            <div className="row">
                <div className="col-5">
                    <SquadraComponent2 squadra={this.squadre.s1} />
                </div>
                <div className="col-2 text-center mt-5">
                    <h1>VS</h1>
                </div>
                <div className="col-5">
                    <SquadraComponent2 squadra={this.squadre.s2} />
                </div>
            </div>
        );
    }
}
 
export default PartitaComponent;