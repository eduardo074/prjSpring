package br.ifba.eduardosouza.prjSpring.facade;

import br.ifba.eduardosouza.prjSpring.model.Aluno;
import br.ifba.eduardosouza.prjSpring.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoFacade implements IAlunoFacade{


    @Autowired
    private AlunoService alunoService;

    @Override
    public boolean verificarCampos(Aluno aluno) {
        return alunoService.verificarCampos(aluno);
    }

    @Override
    public Aluno gerarAluno() {
        return alunoService.gerarAluno();
    }

    @Override
    public List<Aluno> todosOsAlunos() {
        return alunoService.todosOsAlunos();
    }

    @Override
    public boolean removeAluno(Long id) {
        return alunoService.removeAluno(id);
    }

    @Override
    public boolean editarAluno(Aluno aluno, Long id) {
        return alunoService.editarAluno(aluno, id);
    }

    @Override
    public Aluno buscarPorId(Long id) {
        return alunoService.buscarPorId(id);
    }

    @Override
    public boolean cadastraNovoAluno(Aluno aluno) {
        return alunoService.cadastraNovoAluno(aluno);
    }
}
