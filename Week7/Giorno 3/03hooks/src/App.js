import 'bootstrap/dist/css/bootstrap.min.css';
import TodoListComponent from './components/TodoListComponent';
import UserListComponent from './components/UserListComponent';
import TestoComponent from './components/TestoComponent';
//import {Col, Container, Row} from 'react-bootstrap';

//npm i bootstrap
//npm i react-bootstrap

function App() {
  return (
    <>
      <div className='container mt-5'>
        {/* <TodoListComponent />  USE STATE */}
        {/* <UserListComponent /> USE EFFECT */}
        <TestoComponent />
      </div>
    </>
  );
}

export default App;
