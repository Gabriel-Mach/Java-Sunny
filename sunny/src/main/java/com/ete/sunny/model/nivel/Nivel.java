package com.ete.sunny.model.nivel;


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
    private Long numero;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int numtentativas;

    @Column(nullable = false)
    private String dicas;

    @Column(nullable = false)
    private boolean resposta;


}
