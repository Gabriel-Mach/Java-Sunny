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
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavel;

    public Aluno(Long id, String CPF, String nome, String email, String password, Responsavel responsavel) {
        super(id, CPF, nome, email, password);
        this.responsavel = responsavel;
    }
}
