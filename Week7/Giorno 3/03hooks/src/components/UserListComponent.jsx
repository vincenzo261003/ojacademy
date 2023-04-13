import React, { useEffect, useState } from 'react';

function UserListComponent() {
    const [elenco, setElenco] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/studente/all")
            .then(res => res.json())
            .then(dati => {
                setElenco(dati)
            })
            .catch(err => console.log(err))
    })

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
                    {elenco.map((obj, idx) => (
                        <tr key={idx}>
                            <td>{obj.nominativo}</td>
                            <td>{obj.matricola}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    );
}

export default UserListComponent;