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

    @Column(nullable = false)
    @NotBlank()
    @Size(min = 5, max = 255)
    private String full_name;

    @Column(unique = true, nullable = false)
    @Email
    @NotBlank
    private String email;

    @Size(min = 5, max = 255)
    @NotBlank()
    private String password;

    @Column(nullable = false)
    @Size(min = 5, max = 255)
    @NotBlank()
    private String address;

    private boolean active;
}
