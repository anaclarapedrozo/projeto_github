import './App.css';
import HelloWord from './components/HelloWord';
import SayMyName from './components/SayMyName';
import Frase from './components/Frase';
import Pessoa from './components/pessoa';


function App() {
  return (
    <div className="App">
      <Frase></Frase>
      <HelloWord></HelloWord>
      <SayMyName nome = 'Ana Clara'></SayMyName>
      <Pessoa nome='Ana Clara' idade="17" profissão = "Programador" foto = 'https://via.placeholder.com/150'></Pessoa>

    </div>
  );
}

export default App;
