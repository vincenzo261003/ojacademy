import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import { Container } from 'react-bootstrap'
import ElencoStudentiComponent from './components/ElencoStudentiComponent';


function App() {
  return (
    <>
      <Container className='mt-5'>
        <ElencoStudentiComponent />
      </Container>
    </>
  );
}

export default App;
