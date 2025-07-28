import React, { useState } from "react";
import { FaPencil } from "react-icons/fa6";
import styles from "./Modal.module.css";

function Modal({ valueName, valueIdade, valueCpf, valueEstado, index, lista }) {
  const [modalAberto, setModalAberto] = useState(false);

  const [nome, setNome] = useState(`${valueName}`);
  const [idade, setIdade] = useState(`${valueIdade}`);
  const [estadoCivil, setEstadoCivil] = useState(`${valueEstado}`);
  const [cpf, setCpf] = useState(`${valueCpf}`);

  function handleSalvar() {
    console.log("salvo")
  }

  function SetModal() {
    setModalAberto(true);
  }

  function closeModal() {
    setModalAberto(false);
  }

  return (
    <>
      <button className={styles.btnEditar} onClick={SetModal}>
        <FaPencil />
      </button>
      {modalAberto && (
        <div className={styles.container_modal}>
          <div className={styles.modal}>
            <button onClick={closeModal} className={styles.sair_btn}>
              X
            </button>
            <h2>Atualizar Cadastro</h2>
            <div className={styles.inputs}>
              <label>Nome</label>
              <input
                className={styles.input}
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              ></input>

              <label>Idade</label>
              <input
                className={styles.input}
                value={idade}
                onChange={(e) => setIdade(e.target.value)}
              ></input>

              <label>Estado civil</label>
              <input
                className={styles.input}
                value={estadoCivil}
                onChange={(e) => setEstadoCivil(e.target.value)}
              ></input>

              <label>CPF</label>
              <input
                className={styles.input}
                value={cpf}
                onChange={(e) => setCpf(e.target.value)}
              ></input>

              <div className={styles.btn}>
                <button onClick={handleSalvar}>Salvar</button>
                <button onClick={closeModal}>Cancelar</button>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
}

export default Modal;
