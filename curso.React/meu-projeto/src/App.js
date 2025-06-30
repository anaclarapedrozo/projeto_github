import './App.css';
import HelloWord from './components/HelloWord';
import SayMyName from './components/SayMyName';
import Frase from './components/Frase';
import Pessoa from './components/pessoa';
import List from './components/List'


function App() {
  return (
    <div className="App">
      <h1>Testando CSS</h1>
      <></>
      <HelloWord></HelloWord>
      <Frase></Frase>
      <List></List>
      <SayMyName nome = 'Ana Clara'></SayMyName>
      <Pessoa nome='Ronaldo' idade="27" profissão = "Programador"></Pessoa>

    </div>
  );
}

export default App;
