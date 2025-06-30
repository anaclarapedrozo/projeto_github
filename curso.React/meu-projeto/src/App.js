import './App.css';
import HelloWord from './components/HelloWord';
import SayMyName from './components/SayMyName';
import Frase from './components/Frase';
import Pessoa from './components/pessoa';
import List from './components/List'
import Evento from './components/Evento'
import Form from './components/Form'


function App() {
  return (
    <div className="App">
      <h1>Testando Eventos</h1>
      <Evento/>
      <Form/>
    </div>
  );
}

export default App;
