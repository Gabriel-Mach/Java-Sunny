package com.ete.sunny.model.aluno;
import com.ete.sunny.model.Usuario;
import jakarta.persistence.*;
import lombok.*;
import  com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.model.nivel.Tema;
import java.util.List;

@Entity
@Data

public class Aluno extends Usuario {
    @Column(nullable = false)
    private int pontuacao;

    @ManyToOne
    @JoinColumn(name = "id")
    private Responsavel responsavel;

    @ManyToMany
    @JoinTable(name = "usuario_tema",
    joinColumns = @JoinColumn (name = "id_tema"),
            inverseJoinColumns = @JoinColumn(name = "titulo")
    )
    private List <Tema> temas;

}
