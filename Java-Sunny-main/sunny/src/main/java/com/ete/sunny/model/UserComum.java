package com.ete.sunny.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data

public class UserComum extends Usuario{
    /*@Id
    private String CPF;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;*/

    @Column(nullable = false)
    private int pontuacao;

    @ManyToOne
    @JoinColumn(name = "reponsavel")
    private UserResponsavel responsavel;

    @ManyToMany
    @JoinTable(name = "usuario_tema",
    joinColumns = @JoinColumn (name = "CPF"),
            inverseJoinColumns = @JoinColumn(name = "titulo")
    )
    private List <Tema> temas;

}
