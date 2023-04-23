package br.ifba.eduardosouza.prjSpring.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Users")
public class User extends AbstractEntity{


    @Column(nullable = false)
    private String full_name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String address;
    private boolean active;
}
