package br.ifba.eduardosouza.prjSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public ModelAndView dashboard(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("prjspring/dashboard");
        return mv;
    }
}
