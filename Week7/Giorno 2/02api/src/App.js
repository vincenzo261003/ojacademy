import logo from './logo.svg';
import './App.css';
import ElencoStudenti from './components/ElencoStudenti';
import { useState } from 'react';
import InserimentoStudente from './components/InserimentoStudente';


function App() {

  const [vis, setVis] = useState(false);

  const toggleVisuali = () => {
    setVis(!vis);
  }
  return (
    <div className='container mt-5'>
      <button type='button' className='btn btn-primary mb-3' onClick={toggleVisuali}>Inserisci / Elenca</button>
      {vis ? <ElencoStudenti /> : <InserimentoStudente />}
    </div>
  );
}

export default App;
