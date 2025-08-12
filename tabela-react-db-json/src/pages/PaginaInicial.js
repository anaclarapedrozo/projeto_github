import Input from "../layout/Input";
import Tabela from "../layout/Tabela";
import { getUsuarios, postUsuarios } from "../service/api";
import styles from "./PaginaInicial.module.css";
import { useEffect, useState } from "react";

function PaginaInicial() {
  const [nome, setNome] = useState("");
  const [idade, setIdade] = useState(null);
  const [estadoCivil, setEstadoCivil] = useState("");
  const [cpf, setCpf] = useState(null);
  const [pessoas, setPessoas] = useState([]);

  async function carregarPagina() {
    try {
      const usuarios = await getUsuarios();
      setPessoas(usuarios);
    } catch (err) {
      console.error("Erro ao buscar usuário");
    }
  }
  useEffect(() => {
    carregarPagina();
  }, []);

  async function enviar() {
    try {
      const newUsuario = await postUsuarios({
        nome: nome,
        idade: idade,
        estadoCivil: estadoCivil,
        cpf: cpf,
      });
      await carregarPagina();
    } catch (erro) {
      console.error("Erro ao enviar usuario");
    }
  }

  function handleCadastro() {
    if (nome === "" || idade === "" || cpf === "" || estadoCivil === "") {
      alert("Os campos estão vazios");
      return <p>Por favor, preencha todos os campos.</p>
    } 
    // else {
    //   enviar();
    // }
    enviar()
    carregarPagina();
    setNome("");
    setIdade("");
    setEstadoCivil("");
    setCpf("");
  }

  return (
    <>
      <div className={styles.div_inicial}>
        <h1>Novo cadastro</h1>
        <Input
          type="text"
          placeholder=""
          label="Nome"
          onChange={(e) => setNome(e.target.value)}
          value={nome}
        />
        <Input
          type="number"
          placeholder=""
          label="Idade"
          onChange={(e) => setIdade(e.target.value)}
          value={idade}
        />
        <Input
          type="text"
          placeholder=""
          label="Estado civil"
          onChange={(e) => setEstadoCivil(e.target.value)}
          value={estadoCivil}
        />
        <Input
          type="number"
          placeholder=""
          label="CPF"
          onChange={(e) => setCpf(e.target.value)}
          value={cpf}
        />
        
        <button onClick={handleCadastro} className={styles.btnSalvar}>
          Salvar
        </button>
        <div className={styles.tabelinha}>
          <Tabela lista={pessoas} carregarPg={() => carregarPagina()} />
        </div>
      </div>
    </>
  );
}

export default PaginaInicial;
