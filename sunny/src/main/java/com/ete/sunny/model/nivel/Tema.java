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

public class Tema {

    @Id
    private String titulo;

    @Column (nullable = false)
    private int fase;

    @Column (nullable = false)
    private  String nome;

    @ManyToMany(mappedBy = "temas")
    private List <com.ete.sunny.model.Aluno> jogador;

}
