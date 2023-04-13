import logo from './logo.svg';
import './App.css';
import {Link, Route, Router, Routes} from 'react-router-dom';
import HomeComponent from './components/HomeComponent';
import ChisiamoComponent from './components/ChisiamoComponent';
import ContattiComponent from './components/ContattiComponent';

//npm i react-router-dom

function App() {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">Navbar</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item">
                <Link className="nav-link" to="/">Home</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/chisiamo">Chi siamo</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/contatti">Contatti</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div className='container mt-5'>
          <Routes>
            <Route path="/" element={<HomeComponent />}></Route>
            <Route path="/chisiamo" element={<ChisiamoComponent />}></Route>
            <Route path="/contatti" element={<ContattiComponent />}></Route>
          </Routes>
      </div>
    </>
  );
}

export default App;
