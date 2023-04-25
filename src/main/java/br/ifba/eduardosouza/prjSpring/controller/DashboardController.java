package br.ifba.eduardosouza.prjSpring.controller;

import br.ifba.eduardosouza.prjSpring.facade.IUserFacade;
import br.ifba.eduardosouza.prjSpring.model.User;
import br.ifba.eduardosouza.prjSpring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @Autowired
    private IUserFacade userFacade;



    @GetMapping("/dashboard")
    public ModelAndView dashboard(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("prjspring/dashboard");

        User userLogado = userFacade.userLogado();
        mv.addObject("nomeUsuarioLogado", userLogado.getFull_name());


        return mv;
    }

}
