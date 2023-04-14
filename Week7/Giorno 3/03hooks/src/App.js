import 'bootstrap/dist/css/bootstrap.min.css';
import TodoListComponent from './components/TodoListComponent';
import UserListComponent from './components/UserListComponent';
import TestoComponent from './components/TestoComponent';
import ElencoComponent from './components/ElencoComponent';
import GrandiArrayComponent from './components/GrandiArrayComponent';
import OggettiComponent from './components/OggettiComponent';
//import {Col, Container, Row} from 'react-bootstrap';

//npm i bootstrap
//npm i react-bootstrap

function App() {
  return (
    <>
      <div className='container mt-5'>
        {/* <TodoListComponent />  USE STATE */}
        {/* <UserListComponent /> USE EFFECT */}
        {/* <TestoComponent /> USE REF */}
        {/* <ElencoComponent /> ON CALLBACK */}
        {/* <GrandiArrayComponent/> USE MEMO */}
        <OggettiComponent />
      </div>
    </>
  );
}

export default App;
