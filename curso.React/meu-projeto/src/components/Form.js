function Form () {

    function cadastrar (evt) {
        evt.preventDefault()
        console.log('Cadastrou o usuário')
    }

    return(
        <div>
            <h1>Meu cadastro</h1>
            <form onSubmit={cadastrar}>
                <div>
                    <input type='text' placeholder="Digite o seu nome"/>
                </div>
                <div>
                    <input type='submit' value='Cadastro'/>
                </div>
            </form>
        </div>
    )
}

export default Form