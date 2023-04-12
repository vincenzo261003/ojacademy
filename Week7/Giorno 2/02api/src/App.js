import logo from './logo.svg';
import './App.css';
import ElencoStudenti from './components/ElencoStudenti';
import { useState } from 'react';


function App() {

  const [vis, setVis] = useState(false);

  const toggleVisuali = () => {
    setVis(!vis);
  }

  const elenco = (<ElencoStudenti />);
  const inserisci = (<h1>Inserimento</h1>);

  return (
    <div className='container mt-5'>
      <button type='button' className='btn btn-primary mb-3' onClick={toggleVisuali}>Inserisci / Elenca</button>
      {vis ? elenco : inserisci}
    </div>
  );
}

export default App;
