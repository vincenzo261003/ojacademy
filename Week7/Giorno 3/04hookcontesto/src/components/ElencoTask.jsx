import React, { useContext } from 'react';
import TaskListContext from './TaskListContext';

function ElencoTask() {
    const { tasks, eliminaTask } = useContext(TaskListContext);

    const tastoElimina = (varId) => {
        eliminaTask(varId);
    }

    return (
        <>
            <ul>
                {tasks.map((obj, idx) => (
                    <li key={idx}>
                        {obj.id} - {obj.descrizione} - 
                        <button onClick={() => tastoElimina(obj.id)}>Elimina</button>
                    </li>
                ))}
            </ul>
        </>
    );
}

export default ElencoTask;