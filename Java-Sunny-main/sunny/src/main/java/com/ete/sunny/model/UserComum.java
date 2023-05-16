package com.ete.sunny.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserComum{
    @Id
    private String CPF;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;
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
