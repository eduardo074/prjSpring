package br.ifba.eduardosouza.prjSpring.service;

import br.ifba.eduardosouza.prjSpring.model.User;

public interface IUserService {

    //salvar um usuário
    boolean saveUser(User user);

    //Buscar um user pelo email e senha
    User findByEmailAndPassword(User user);

    //Dados do user logado
    public abstract User userLogado();
}
