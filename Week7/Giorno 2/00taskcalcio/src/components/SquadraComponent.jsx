import React, { Component } from 'react';

class SquadraComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            contatore: 0
        }

    }

    incrementaPunteggio = () => {
        this.setState((state, props) => {return { contatore: state.contatore + 1 }})
    }

    decrementaPunteggio = () => {
        this.setState((state, props) => {return { contatore: (state.contatore === 0 ? state.contatore : state.contatore - 1) }})
    }

    render() { 
        return (
            <div className="row text-center">
                <h3 className='mt-5'>{this.props.squadra}</h3>
                <div className="col-4 mt-4">
                    <button type='button' className='btn btn-primary' onClick={this.decrementaPunteggio}>-</button>
                </div>
                <div className="col-4 mt-4"><h1>{this.state.contatore}</h1></div>
                <div className="col-4 mt-4">
                    <button type='button' className='btn btn-primary' onClick={this.incrementaPunteggio}>+</button>
                </div>
            </div>
        );
    }

    componentDidMount(){
    }
}
 
export default SquadraComponent;