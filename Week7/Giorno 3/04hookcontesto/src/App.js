import logo from './logo.svg';
import './App.css';
import TaskListProvider from './components/TaskListProvider';
import AggiungiTask from './components/AggiungiTask';
import ElencoTask from './components/ElencoTask';

function App() {
  return (
    <>
      <TaskListProvider>
        {/* Tutti i componenti ereditano tutti i metodi e le variabili del provider */}
        <AggiungiTask />
        <ElencoTask />
      </TaskListProvider>
    </>
  );
}

export default App;
