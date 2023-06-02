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
public class ExFon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Nnivel;

    @Column(nullable = false)
    private int numtentativas;

    @Column(nullable = false)
    private String dicas;

    @Column(nullable = false)
    private boolean resposta;

    @OneToOne
    @JoinColumn(name = "numero")
    private Nivel nivel;
}
