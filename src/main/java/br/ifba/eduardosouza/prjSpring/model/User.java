package br.ifba.eduardosouza.prjSpring.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name="Users")
public class User extends AbstractEntity{
    private final String MASSAGE_ERRO_CAMPO = "Campo não informado";
    private final String MASSAGE_ERRO_CAMPO_INVALIDO = "Campo inválido";
    private final String MASSAGE_ERRO_CAMPO_TAMANHO = "Min 5, max 255 caracteres";

    @Column(nullable = false)
    @NotBlank(message = MASSAGE_ERRO_CAMPO)
    @Size(min = 5, max = 255, message = MASSAGE_ERRO_CAMPO_TAMANHO)
    private String full_name;

    @Column(unique = true, nullable = false)
    @Email(message = MASSAGE_ERRO_CAMPO_INVALIDO)
    @Size(min = 5, max = 255, message = MASSAGE_ERRO_CAMPO_TAMANHO)
    @NotBlank(message = MASSAGE_ERRO_CAMPO)
    private String email;

    @Size(min = 5, max = 255, message = MASSAGE_ERRO_CAMPO_TAMANHO)
    @NotBlank(message = MASSAGE_ERRO_CAMPO)
    private String password;

    @Column(nullable = false)
    @Size(min = 5, max = 255, message = MASSAGE_ERRO_CAMPO_TAMANHO)
    @NotBlank(message = MASSAGE_ERRO_CAMPO)
    private String address;

    private boolean active;
}
