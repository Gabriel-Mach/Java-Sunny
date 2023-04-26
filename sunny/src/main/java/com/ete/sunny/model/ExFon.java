package com.ete.sunny.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long numnvl;

    @Column(nullable = false)
    private int numtentativas;

    @Column(nullable = false)
    private String dicas;

    @Column(nullable = false)
    private boolean resposta;
}
