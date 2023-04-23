package br.ifba.eduardosouza.prjSpring.service;

import br.ifba.eduardosouza.prjSpring.model.User;
import br.ifba.eduardosouza.prjSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

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

    @Override
    public boolean findByEmailPassword(User user) {
        return false;
    }
}
