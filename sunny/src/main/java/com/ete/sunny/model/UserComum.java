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
public class UserComum {
    @Column(nullable = false)
    private int pontuacao;

    @ManyToOne
    @JoinColumn(name = "CPF")
    private UserResponsavel responsavel;

    @ManyToMany
    @JoinTable(name = "usuario_tema",
    joinColumns = @JoinColumn (name = "CPF"),
            inverseJoinColumns = @JoinColumn(name = "titulo")
    )
    private List <Tema> temas;

}
