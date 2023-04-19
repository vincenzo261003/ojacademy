import { Routes, Link, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.js'
import HomeComponent from './components/HomeComponent';
import DetailComponent from './components/DetailComponent';
import OrdinatiGiorno from './components/OrdinatiGiorno';

function App() {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <div className="container-fluid">
            <Link className="navbar-brand" to="/">Gestione cinema</Link>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <Link className="nav-link" to="/all">Tutti i film</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/contatti">Contatti</Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>

        <div className='container-fluid mx-0 px-0'>
            <Routes>
              <Route path="/" element={<OrdinatiGiorno />}></Route>
              <Route path="/all" element={<HomeComponent />}></Route>
              <Route path="/contatti" element={<HomeComponent />}></Route>
              <Route path="/:id" element={<DetailComponent />}></Route>
            </Routes>
        </div>
      </>
  );
}

export default App;
