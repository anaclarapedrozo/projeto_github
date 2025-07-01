import './App.css';
import HelloWord from './components/HelloWord';
import SayMyName from './components/SayMyName';
import Frase from './components/Frase';
import Pessoa from './components/pessoa';
import List from './components/List'
import Evento from './components/Evento'
import Form from './components/Form'
import Condicional from './components/Condiconal';
import OutraLista from './components/OutraLista';


function App() {

  const meusItens = ['CSS', 'React', 'JavaScript', 'MySQL']
  return (
    <div className="App">
      <h1>Renderização de Listas</h1>
      <OutraLista itens={meusItens}/>
      <OutraLista itens={''}/>
    </div>
  );
}

export default App;
