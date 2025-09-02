import axios from "axios";

const instance = axios.create({
  baseURL: "http://10.0.0.29:8083/categoria",
});

const instance2 = axios.create({
  baseURL: "http://10.0.0.29:8083",
});

export async function getCategories() {
  const dados = await instance.get("/todas");
  console.log('dados :>> ', dados.data);
  return dados.data;
}

export async function postTarefas(obj) {
    const dados = await axios.post("http://10.0.0.29:8083/tarefa/salvar", obj);
    console.log("Enviado pro Json com sucesso", obj);
    return dados.data;
 
}

export async function getTarefas() {
  const resposta = await axios.get("http://10.0.0.29:8083/tarefa");
  return resposta.data;
}

export async function getDeletar(id) {
  console.log('id :>> ', id);
  await axios.delete(`http://10.0.0.29:8083/tarefa/${id}`);
}

export async function editarStatus(id) {
  await instance2.patch(`/tarefa/concluir/${id}`, { status: "concluido" });
}

export async function voltarStatus(id) {
  await instance2.patch(`/tarefa/concluir/${id}`, { status: "pendente" });
}

export async function editarTarefa(id, obj) {
  await instance2.patch(`/tarefa/${id}`, obj);
}
