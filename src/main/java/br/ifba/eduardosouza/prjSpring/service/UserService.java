package br.ifba.eduardosouza.prjSpring.service;

import br.ifba.eduardosouza.prjSpring.model.User;
import br.ifba.eduardosouza.prjSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    //User logado
    private User userLogado;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveUser(User user) {
        //Para salvar um user tem que ter um email diferente dos demais

        User userBuscado = userRepository.findByEmail(user.getEmail());
        // se userBuscado for null siginifca que o email do user ainda não existe, então posso cadastra o novo usuário
        if(userBuscado == null){
            userRepository.save(user);
            return true;
        }else {
            System.out.println("O email já exite");
            return false;
        }
    }


    //Verificação para o login
    @Override
    public User findByEmailAndPassword(User user) {
        //Vou pegar o usuário que quer fazer login e verificar se o email e senha exitem no banco de dados
        User userLogin = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        //O usuário que fez o login

        if(userLogin == null){
            return null;
        }else {
            userLogado = userLogin;
            return userLogin;
        }
    }

    @Override
    public User userLogado() {
        return userLogado;
    }
}
