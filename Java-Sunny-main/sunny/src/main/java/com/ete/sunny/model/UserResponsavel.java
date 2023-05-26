package com.ete.sunny.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Data


public class UserResponsavel extends Usuario {

    /*@Id
    private String CPF;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;*/
    @Column(nullable = false)
    private String telefone;


    @OneToMany (mappedBy = "responsavel")
    private List <UserComum> aluno;
}
