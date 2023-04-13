import React, { Component, useState } from 'react';

function InserimentoStudente() {

    const [success, setSuccess] = useState(false);

    const submitForm = (evt) => {
        evt.preventDefault();
    
        const stud = {
            nominativo: evt.target.inputNominativo.value,
            matricola: evt.target.inputMatricola.value
        }


        fetch("http://localhost:8080/studente", {
            method: "POST",
            body: JSON.stringify(stud),
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(res => res.json())
        .then(data => {
            setSuccess(data === true ? 1 : -1);
        })
        .catch(err => {
            console.log(err);
            setSuccess(-1);
        })
    }

    return (
        <>
            <h1>Form di inserimento</h1>

            <form onSubmit={submitForm}>
                <div className="form-group">
                    <label htmlFor="inputNominativo">Nominativo</label>
                    <input type="text" className='form-control' id="inputNominativo" />
                </div>

                <div className="form-group">
                    <label htmlFor="inputMatricola">Matricola</label>
                    <input type="text" className='form-control' id="inputMatricola" />
                </div>

                <button type="submit" className='btn btn-primary btn-block mt-3'>Salva</button>
            </form>

            {success === 1 && (
                <div className="alert alert-success mt-4" role="alert">
                    Inserimento avvenuto con successo
                </div>
            )} 

            {success === -1 && (
                <div className="alert alert-danger mt-4" role="alert">
                    Inserimento non avvenuto
                </div>
            )}
        </>
    );
}

export default InserimentoStudente;