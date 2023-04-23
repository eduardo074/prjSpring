package br.ifba.eduardosouza.prjSpring.controller;


import br.ifba.eduardosouza.prjSpring.facade.IAlunoFacade;
import br.ifba.eduardosouza.prjSpring.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    private IAlunoFacade alunoFacade;

//    Retornar todos os alunos no meu banco de dados para meu front-end
    @GetMapping("/alunos")
    @ResponseBody
    public List<Aluno> getAlunos(){
        return alunoFacade.todosOsAlunos();
    }


//    Salvar um aluno do front-end no bnaco de dados
    @PostMapping
    public RedirectView savarDados(@ModelAttribute  Aluno aluno){
        alunoFacade.cadastraNovoAluno(aluno);
        return new RedirectView("http://127.0.0.1:5500/dashboard.html");
    }
}
