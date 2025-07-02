import { useState } from "react";

function ProjectForm() {
  return (
    <form>
      <div>
        <input type="text" placeholder="Digite o nome do projeto" />
      </div>
      <div>
        <input type="number" placeholder="Digite o orçamento do total" />
      </div>
      <div>
        <select>
          <option disabled selected>Selecione a categoria</option>
        </select>
      </div>
      <div>
        <input type="submit" value="Criar projeto" />
      </div>
    </form>
  );
}

export default ProjectForm;
