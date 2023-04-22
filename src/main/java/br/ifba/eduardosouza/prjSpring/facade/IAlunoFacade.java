package br.ifba.eduardosouza.prjSpring.facade;

import br.ifba.eduardosouza.prjSpring.model.Aluno;

import java.util.List;

public interface IAlunoFacade {
    /*______ Minhas regras de negócio ______*/

    //Restrição de acesso


    //Validação de campos
    public abstract boolean verificarCampos(Aluno aluno);

    //Restrições de formato e tamanho de arquivos

    //Gerenciamento de permissões

    //Gerar um aluno aleatório para testes
    public abstract Aluno gerarAluno();



    /*    CRUD    */

    //retornar todos os alunos do sistema
    public abstract List<Aluno> todosOsAlunos();

    //Cadastro de aluno e Verificação de duplicidade
    public abstract boolean cadastraNovoAluno(Aluno aluno);

    //Remover aluno do sitema
    public abstract boolean removeAluno(Long id);

    //editar aluno
    public abstract boolean editarAluno(Aluno aluno, Long id);

    //buscar aluno por id
    public abstract Aluno buscarPorId(Long id);
}
