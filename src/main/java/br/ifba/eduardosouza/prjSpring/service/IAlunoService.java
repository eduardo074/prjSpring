package br.ifba.eduardosouza.prjSpring.service;

import br.ifba.eduardosouza.prjSpring.model.Aluno;

import java.util.List;

public interface IAlunoService {

    //Cadastro de aluno e Verificação de duplicidade
    public abstract boolean cadastraNovoAluno(Aluno aluno);

    //Validação de campos
    public abstract boolean verificarCampos(Aluno aluno);

    //retornar todos os alunos do sistema
    public abstract List<Aluno> todosOsAlunos();

    //remover aluno
    public abstract boolean removeAluno(Long id);

    //editar aluno
    public abstract boolean editarAluno(Aluno aluno, Long id);

    //buscar aluno por id
    public abstract Aluno buscarPorId(Long id);

    //Gerar um aluno aleátorio para testes
    public abstract Aluno gerarAluno();
}
