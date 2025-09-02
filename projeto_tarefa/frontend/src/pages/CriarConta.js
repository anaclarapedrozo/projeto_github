import { useState } from "react";
import styles from "./CriarConta.module.css";
import { useNavigate } from "react-router-dom";
import { FaEye } from "react-icons/fa";
import { HiEyeOff } from "react-icons/hi";

function Criar() {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [confirmarSenha, setConfirmarSenha] = useState("");
  const [showPassword, setShowPassword] = useState(true);
  const [showPassword2, setShowPassword2] = useState(true);

  const handleClickShowPassword = () => setShowPassword((show) => !show);
  const handleClickShowPassword2 = () => setShowPassword2((show) => !show);

  const navigate = useNavigate();

  function handleCriar() {
    navigate("/Pagina", {
      state: {
        nome: nome,
      },
    });
  }

  function handleLogar() {
    navigate("/Login");
  }

  return (
    <div className={styles.divona}>
      <div className={styles.divinputs}>
        <h2>CRIAR CONTA</h2>
        <label>Nome completo</label>
        <input
          placeholder="Digite o seu nome"
          onChange={(e) => setNome(e.target.value)}
        />
        <label>E-mail</label>
        <input
          placeholder="Digite o seu e-mail"
          onChange={(e) => setEmail(e.target.value)}
        />
        <label>Senha</label>
        <input
          placeholder="Digite a sua senha"
          onChange={(e) => setSenha(e.target.value)}
          type={showPassword ? "text" : "password"}
        />
        <button
          className={styles.btnEye}
          onClick={handleClickShowPassword}
        >
          {showPassword ? <FaEye /> : <HiEyeOff />}
        </button>
        <label>Confirmar a senha</label>
        <input
          placeholder="Confirme a senha"
          onChange={(e) => setConfirmarSenha(e.target.value)}
          type={showPassword2 ? "text" : "password"}
        />
        <button
          className={styles.btnEye2}
          onClick={handleClickShowPassword2}
        >
          {showPassword2 ? <FaEye /> : <HiEyeOff/> }
        </button>
        <img
          src="/images/tarefa.png"
          alt="mc gorila"
          className={styles.mcgorila}
        />
        <hr />
        <div>
          <button className={styles.btnAcoes} onClick={handleCriar}>
            Entrar
          </button>
          <button className={styles.btnAcoes} onClick={handleLogar}>
            Fazer login
          </button>
        </div>
      </div>
    </div>
  );
}

export default Criar;
