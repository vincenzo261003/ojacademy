import React, { useContext } from 'react';
import TaskListContext from './TaskListContext';

function AggiungiTask() {

    const { inserisciTask } = useContext(TaskListContext);

    const pulsanteSubmitTask = (evt) => {
        evt.preventDefault();

        const task = {
            id: Date.now(),
            descrizione: evt.target.inputTask.value
        }

        inserisciTask(task);
    }

    return (
        <>
            <form onSubmit={pulsanteSubmitTask}>
                <input type="text" name="inputTask" id="inputTask" />
                <button type='submit'>Aggiungi</button>
            </form>
        </>
    );
}

export default AggiungiTask;