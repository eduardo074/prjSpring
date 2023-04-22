package br.ifba.eduardosouza.prjSpring.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

// data vai gerar todos os get e set automático
@Data
@Entity
@Table(name="alunos")
public class Aluno extends AbstractEntity{
    private String user_name;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String senha;

    @Column(unique = true)
    private String matricula;

    public Aluno() {
    }

    public Aluno(String userName, String firstName, String lastName, String email, String phone,
                  String matricula) {
        this.user_name = userName;
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.phone = phone;
        this.matricula = matricula;
    }
}
