package br.ifba.eduardosouza.prjSpring.controller;


import br.ifba.eduardosouza.prjSpring.facade.IAlunoFacade;
import br.ifba.eduardosouza.prjSpring.facade.IUserFacade;
import br.ifba.eduardosouza.prjSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class LoginController {

    @Autowired
    private IUserFacade userFacade;
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("prjspring/login");
        mv.addObject("msg", "Mensagem do controller");
        return mv;
    }
    @PostMapping("/login")
    public RedirectView verifcarLogin(@ModelAttribute User user){
        if(userFacade.findByEmailAndPassword(user) != null){
            System.out.println("Login feito como sucesso");
            return new RedirectView("/dashboard");
        }else{
            System.out.println("ERRoOLogin");
            return new RedirectView("/login");
        }
    }
}
