import './App.css';
import Saudacao from './components/Saudacao';
import SeuNome from './components/SeuNome';
// import HelloWord from './components/HelloWord';
// import SayMyName from './components/SayMyName';
// import Frase from './components/Frase';
// import Pessoa from './components/pessoa';
// import List from './components/List'
// import Evento from './components/Evento'
// import Form from './components/Form'
// import Condicional from './components/Condiconal';
// import OutraLista from './components/OutraLista';
import { useState } from 'react'



function App() {

  const [nome, setNome] = useState()
    
  return (
    <div className="App">
      <h1>State Lift</h1>
      <SeuNome setNome={setNome}/>
      <Saudacao nome={nome}/>
    </div>
  );
}

export default App;
