import './App.css';
import HelloWord from './components/HelloWord';
import SayMyName from './components/SayMyName';
import Frase from './components/Frase';
import Pessoa from './components/pessoa';


function App() {
  return (
    <div className="App">
      <h1>Testando CSS</h1>
      <Frase></Frase>
      <HelloWord></HelloWord>
      <SayMyName nome = 'Ana Clara'></SayMyName>
      <Pessoa nome='Ronaldo' idade="17" profissão = "Programador"></Pessoa>

    </div>
  );
}

export default App;
