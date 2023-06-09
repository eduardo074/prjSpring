package br.ifba.eduardosouza.prjSpring.facade;

import br.ifba.eduardosouza.prjSpring.model.User;

import br.ifba.eduardosouza.prjSpring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacade implements IUserFacade{

    @Autowired
    private IUserService userService;

    @Override
    public User userLogado() {
        return userService.userLogado();
    }

    @Override
    public boolean saveUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    public User findByEmailAndPassword(User user) {
        return userService.findByEmailAndPassword(user);
    }
}
