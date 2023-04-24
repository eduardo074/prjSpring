package br.ifba.eduardosouza.prjSpring.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// data vai gerar todos os get e set automático
@Data
@Entity
@Table(name="alunos")
public class Aluno extends AbstractEntity{

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 20)
    @NotBlank //a string não pode ser nula e ter espaço vazios
    private String user_name;
    @Size(min = 5, max = 20)
    @NotBlank
    private String first_name;
    @Size(min = 5, max = 20)
    @NotBlank
    private String last_name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String phone;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 6, max = 255)
    private String senha;

    @Column(unique = true, nullable = false)
    @NotBlank
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
