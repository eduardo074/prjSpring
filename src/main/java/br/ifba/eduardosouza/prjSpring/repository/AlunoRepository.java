package br.ifba.eduardosouza.prjSpring.repository;

import br.ifba.eduardosouza.prjSpring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//essa vai ser minha classe que vai manipular meu banco de dados
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

//    convenção de nomeação de método do Spring Data JPA
    Aluno findByMatricula(String matricula);

}
