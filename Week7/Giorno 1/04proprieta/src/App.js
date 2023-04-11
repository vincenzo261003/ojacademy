import logo from './logo.svg';
import './App.css';
import Passaggioparametri from './components/Passaggioparametri';
import PassaggioParametriClasse from './components/Passaggioparametriclasse';
import RigaComponent from './components/RigaComponent';
import RigaComponentFunction from './components/RigaComponentFunction';

function App() {
  return (
    <>
      {/* <Passaggioparametri nome="test" cognome="a" /> */}

      {/* <PassaggioParametriClasse nome="test" cognome="a" /> */}

      <div className='container mt-5'>
        <table className='table table-striped'>
          <thead>
            <tr>
              <th>Nome</th>
              <th>Cognome</th>
              <th>Eta</th>
            </tr>
          </thead>

          <tbody>
            {/* <RigaComponent nome="uno" cognome="unoo" />
            <RigaComponent cognome="duee" eta="2" />
            <RigaComponent nome="tre" cognome="tree" eta="3" />
            <RigaComponent nome="quattro" eta="4" /> */}

            <RigaComponentFunction nome="uno" cognome="unoo" />
            <RigaComponentFunction  cognome="duee" eta="2" />
            <RigaComponentFunction nome="tre" cognome="tree" eta="3" />
            <RigaComponentFunction nome="quattro"  eta="4" />
          </tbody>
        </table>
      </div>
    </>
  );
}

export default App;
