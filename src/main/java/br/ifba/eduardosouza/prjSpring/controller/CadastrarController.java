package br.ifba.eduardosouza.prjSpring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastrarController {

    @GetMapping("/cadastrar")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("prjspring/cadastrar");
        return mv;
    }
}
