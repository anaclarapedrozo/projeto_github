import './App.css';

function App() {

  const nome = 'Ana Clara'

  const soma=(a, b)=>{
    return a+b
  }

  const url  ='https://via.placeholder.com/150'

  return (
    <div className="App">
      <h1>Alternando o JSX</h1>
      <p>Olá {nome}</p>
      <p>Soma: {soma(3, 5)}</p>
      <img src={url} alt='Minha imagem'></img>
    </div>
  );
}

export default App;
