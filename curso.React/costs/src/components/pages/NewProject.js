import ProjectForm from '../project/ProjectForm';
import styles from './NewProjects.module.css'

function NewProject() {
  return (
    <div className={styles.newprojects_container}>
      <h1>Criar projeto</h1>
      <p>Crie o seu projeto para depois adicionar os serviços</p>
      <ProjectForm/>
    </div>
  );
}

export default NewProject;
