import Item from "./Item";

function List() {
  return (
    <>
      <div>
        <h1>Minha lista</h1>
        <ul>
          <Item marca="BMW"></Item>
          <Item marca="Audi"></Item>
          <Item marca="Honda"></Item>
        </ul>
      </div>
    </>
  );
}

export default List;
