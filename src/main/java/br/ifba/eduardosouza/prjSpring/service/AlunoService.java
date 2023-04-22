package br.ifba.eduardosouza.prjSpring.service;


import br.ifba.eduardosouza.prjSpring.model.Aluno;
import br.ifba.eduardosouza.prjSpring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Random;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository repository;


    public boolean cadastraNovoAluno(Aluno aluno) {
        //antes de salvar, tenho verificar a matricula para evitar duplicidades de dados

        //verificar se a matricula do novo aluno já existe no banco de dados

        Aluno matriculaBuscada = repository.findByMatricula(aluno.getMatricula());

        if(matriculaBuscada == null) {
            repository.save(aluno);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, aluno.getMatricula() + " já existe. Informe uma matrícula diferente.");
            return false;
        }
    }

    // verificar se na tela todos os dados foram preenchido
    public boolean verificarCampos(Aluno aluno) {
        return aluno != null && !aluno.getFirst_name().isEmpty() && !aluno.getLast_name().isEmpty() &&
                !aluno.getUser_name().isEmpty() &&
                !aluno.getEmail().isEmpty() &&
                !aluno.getPhone().isEmpty() &&
                !aluno.getMatricula().isEmpty();
    }


    //Retornar todos os alunos
    public List<Aluno> todosOsAlunos() {
        return repository.findAll();
    }

    //Remover um aluno
    public boolean removeAluno(Long id) {
        //Verificar se o id existe
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }


//    Para editar um aluno eu preciso chamar meu método save informando o id a ser alterado
    public boolean editarAluno(Aluno aluno, Long id) {
        //verificar se a nova matricula do novo aluno já existe no banco de dados
        Aluno matriculaBuscada = repository.findByMatricula(aluno.getMatricula());

        if(matriculaBuscada == null){
            //o spring Data vai verificar se o id já existe e se existir siginifica que o dado será atualizado
            repository.save(aluno);
            return true;
        }
        return false;
    }


    //Buscar um aluno por id
    public Aluno buscarPorId(Long id) {
        if(repository.existsById(id))
            return repository.getReferenceById(id);
        return null;
    }


    //Gerar um aluno para facilitar o desenvolvimento
    public Aluno gerarAluno() {
        Random random = new Random();
        String[] firstNames = {"Lucas", "Mariana", "Pedro", "Juliana", "Gustavo", "Ana", "Felipe", "Larissa", "Rafael", "Carla", "Thiago", "Isabela", "Rodrigo", "Marina", "Bruno", "Camila", "Leandro", "Bianca", "Diego", "Gabriela", "Vinícius", "Fernanda", "Eduardo", "Márcia", "Renato", "Cintia", "André", "Júlia", "Alexandre", "Luana", "Victor", "Renata"};
        String[] lastNames = {"Silva", "Souza", "Oliveira", "Ferreira", "Santos", "Gomes", "Pereira", "Almeida", "Rodrigues", "Costa", "Martins", "Sampaio", "Andrade", "Barbosa", "Mendes", "Freitas", "Lima", "Araújo", "Monteiro", "Sousa", "Cavalcante", "Carvalho", "Nascimento", "Mendes", "Fernandes", "Ribeiro", "Cardoso", "Gonçalves", "Teixeira", "Cruz", "Farias", "Pires"};
        String[] telefones = {"(11) 91234-5678", "(21) 98765-4321", "(31) 99876-5432", "(41) 98765-1234", "(51) 91234-5678", "(61) 99876-5432", "(71) 98765-1234", "(81) 91234-5678"};
        String[] emails = {"@gmail.com", "@hotmail.com", "@yahoo.com", "@outlook.com", "@uol.com.br", "bol.com.br", "@globo.com", "@ig.com"};
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String userName = firstName + "_" + lastName;
        String telefone = telefones[random.nextInt(telefones.length)];
        String email = (firstName + lastName + emails[random.nextInt(emails.length)]).toLowerCase();

        String matricula = "";
        for (int i = 0; i < 2; i++) {
            matricula += letras[random.nextInt(letras.length)];
            matricula += random.nextInt(10000);
        }

        Aluno aluno = new Aluno(userName,firstName, lastName, email, telefone, matricula);
        return aluno;
    }
}
