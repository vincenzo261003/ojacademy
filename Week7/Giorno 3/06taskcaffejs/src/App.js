import 'bootstrap/dist/css/bootstrap.min.css'
import ElencoStudenti from './components/ElencoStudenti';
import GestioneCaffeProvider from './components/GestioneCaffeProvider';

function App() {
  return (
    <>
      <div className="container mt-5 bg-dark text-light">
        <GestioneCaffeProvider>
          <ElencoStudenti />
        </GestioneCaffeProvider>
      </div>
    </>
  );
}

export default App;
