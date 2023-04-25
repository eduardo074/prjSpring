package br.ifba.eduardosouza.prjSpring.facade;

import br.ifba.eduardosouza.prjSpring.model.User;

public interface IUserFacade {
    /*______ Minhas regras de negócio para os Usuário ______*/

    //Validação de campos

    //Dados do user logado
    public abstract User userLogado();


    //------- Repository -------

    //salvar um usuário
    public abstract boolean saveUser(User user);

    //Buscar um user pelo email e senha
    public abstract User findByEmailAndPassword(User user);


}
