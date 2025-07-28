import { useEffect, useState } from "react";
import styles from "./Tabela.module.css";
import { FaPencil } from "react-icons/fa6";
import { FaTrashAlt } from "react-icons/fa";
import Modal from "./Modal";

function Tabela({ lista }) {
  useEffect(() => {
    console.log("useEffect -> ", lista);
  }, [lista]);

  const [i, setI] = useState(null)

  function deletar() {
    lista.splice(i, 4);
  }

  return (
    <div>
      <div className={styles.tabela_div}>
        <table className={styles.tabela}>
          <thead>
            <tr>
              <th>NOME</th>
              <th>IDADE</th>
              <th>CPF</th>
              <th>ESTADO CIVIL</th>
              <th>EDITAR</th>
              <th>REMOVER</th>
            </tr>
          </thead>
          <tbody>
            {lista.length === 0 ? (
              <tr className={styles.semDados}>
                <tr>Sem dados</tr>
              </tr>
            ) : (
              lista.map((pessoa, setI) => {
                return (
                  <tr key={setI}>
                    <td>{pessoa.nome}</td>
                    <td>{pessoa.idade}</td>
                    <td>{pessoa.cpf}</td>
                    <td>{pessoa.estadoCivil}</td>
                    <td>
                      <Modal
                        valueName={pessoa.nome}
                        valueIdade={pessoa.idade}
                        valueCpf={pessoa.cpf}
                        valueEstado={pessoa.estadoCivil}
                        index={setI}
                      />
                    </td>
                    <td>
                      <button className={styles.btnLixo} onClick={deletar}>
                        <FaTrashAlt />
                      </button>
                    </td>
                  </tr>
                );
              })
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default Tabela;
