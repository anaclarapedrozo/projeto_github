import Message from "../layout/Message";
import { useLocation } from "react-router-dom";
import Container from '../layout/Container'
import styles from "./Projects.module.css";
import LinkButtom from "../layout/LinkButtom";

function Projects() {
  const location = useLocation();
  let message = "";
  if (location.state) {
    message = location.state.message;
  }

  return (
    <div className={styles.project_container}>
      <div className={styles.title_container}>
        <h1>Meus projetos</h1>
        <LinkButtom to='/newproject' text='Criar Projeto'/>
      </div>
      {message && <Message type="success" msg={message} />}
      <Container customClass='start'><p>Projetos...</p></Container>
    </div>
  );
}

export default Projects;
