package com.ete.sunny.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data

public class Aluno extends Usuario{
    @Column(nullable = false)
    private int pontuacao;

    @ManyToOne
    @JoinColumn(name = "id")
    private Responsavel responsavel;

    @ManyToMany
    @JoinTable(name = "usuario_tema",
    joinColumns = @JoinColumn (name = "id"),
            inverseJoinColumns = @JoinColumn(name = "titulo")
    )
    private List <Tema> temas;

}
