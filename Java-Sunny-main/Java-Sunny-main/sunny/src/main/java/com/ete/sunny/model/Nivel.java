package com.ete.sunny.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nivel {

    @Id
    private int numero;

    @Column(nullable = false)
    private String nome;
    @OneToOne(mappedBy = "nivel")
    private ExFon exercicio;

}
