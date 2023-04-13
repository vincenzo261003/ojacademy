import React, { useState } from 'react';

function TodoListComponent() {

    const [todos, setTodos] = useState([]);

    const aggiungiTodo = () => {
        const newTodo = {
            id: Date.now(),
            text: "Test todo",
            completato: false
        }
        
        setTodos([...todos, newTodo])
    }

    return (
        <>
        <div>
            <h1 className='mb-3'>Lista cose da fare</h1>
            <button className='btn btn-primary btn-block mb-4' onClick={aggiungiTodo}>Aggiungi todo</button>
            <ul>
                {todos.map((obj, idx) => (
                    <li key={idx}>{obj.id} - {obj.text} - {obj.completato ? "Fatto" : "Da fare"}</li>
                ))}
            </ul>
        </div>
        </>
    );
}

export default TodoListComponent;