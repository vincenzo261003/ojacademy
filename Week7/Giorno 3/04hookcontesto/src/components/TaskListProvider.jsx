import React, { useState } from 'react';
import TaskListContext from './TaskListContext';

const TaskListProvider = ({children}) => {

    const [tasks, setTasks] = useState([]);

    const inserisciTask = (newTask) => {
        setTasks([...tasks, newTask])
    }

    const eliminaTask = (varId) => {
        setTasks(tasks.filter((task) => task.id != varId));
    }

    return (
        <TaskListContext.Provider value={ {tasks, inserisciTask, eliminaTask} }>
            {children}
        </TaskListContext.Provider>
    )
}

export default TaskListProvider;