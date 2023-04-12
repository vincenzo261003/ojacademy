import React from 'react';
import { Component } from 'react';

class FormComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            persona: {
                nome: "N.D.",
                cognome: "N.D."
            }
        }
    }

    submitForm = (evt) => {
        evt.preventDefault();
    
        const p = {
            nome: evt.target.inputNome.value,
            cognome: evt.target.inputCognome.value
        }

        this.setState((state, props) => { return {
                persona: p
            }
        })
    }

    componentDidUpdate() {
        console.log(this.state.persona)
    }

    render() { 
        return (
            <>
                <h1>Form di inserimento</h1>

                <form onSubmit={this.submitForm}>
                    <div className="form-group">
                        <label htmlFor="inputNome">Nome</label>
                        <input type="text" className='form-control' id="inputNome" />
                    </div>

                    <div className="form-group">
                        <label htmlFor="inputCognome">Cognome</label>
                        <input type="text" className='form-control' id="inputCognome" />
                    </div>

                    <button type="" className='btn btn-primary btn-block mt-3'>Salva</button>
                </form>

            </>
        );
    }
}
 
export default FormComponent;