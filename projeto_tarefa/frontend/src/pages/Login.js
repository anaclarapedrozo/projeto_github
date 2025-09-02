import { useState } from "react";
import { useNavigate } from "react-router-dom";
import styles from "./Login.module.css";
import { FaEye } from "react-icons/fa";
import { HiEyeOff } from "react-icons/hi";

function Login() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [showPassword, setShowPassword] = useState(true);
  
  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const navigate = useNavigate();

  function handleEntrar() {
    navigate("/Pagina");
  }

  function handleCriar() {
    navigate("/");
  }

  return (
    <div className={styles.divona}>
      <div className={styles.divinputs}>
        <h2>FAZER LOGIN</h2>
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
        <button className={styles.btnEye} onClick={handleClickShowPassword}>
          {showPassword ? <FaEye /> : <HiEyeOff />}
        </button>
        <img
          src="/images/tarefa.png"
          alt="mc gorila"
          className={styles.mcgorila}
        />
        <div className={styles.infos}>
          <p>A senha deve conter no minímo 8 caracteres.</p>
          <p>O e-mail deve conter @ e ".com"</p>
        </div>
        <div>
          <button className={styles.btnAcoes} onClick={handleEntrar}>
            Entrar
          </button>
          <button className={styles.btnAcoes} onClick={handleCriar}>
            Criar conta
          </button>
        </div>
      </div>
    </div>
  );
}

export default Login;
