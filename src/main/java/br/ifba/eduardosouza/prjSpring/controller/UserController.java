package br.ifba.eduardosouza.prjSpring.controller;

import br.ifba.eduardosouza.prjSpring.facade.IUserFacade;
import br.ifba.eduardosouza.prjSpring.model.User;
import br.ifba.eduardosouza.prjSpring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private IUserFacade userFacade;
    @PostMapping("/cadastrar")
    public RedirectView salvarUser(@ModelAttribute User user){
        if(userFacade.saveUser(user)){
            return new RedirectView("/login");
        }else{
            return new RedirectView("/cadastrar");
        }
    }
}
