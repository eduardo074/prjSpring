package br.ifba.eduardosouza.prjSpring.facade;

import br.ifba.eduardosouza.prjSpring.model.User;

public interface IUserFacade {
    /*______ Minhas regras de negócio para os Usuário ______*/

    //Validação de campos


    //------- Repository -------

    //salvar um usuário
    public abstract boolean saveUser(User user);

    //Buscar um user pelo email e senha
    public abstract boolean findByEmailPassword(User user);


}
