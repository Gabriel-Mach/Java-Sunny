package com.ete.sunny.model.aluno;
import com.ete.sunny.model.abstrato.Usuario;
import jakarta.persistence.*;
import lombok.*;
import  com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.model.nivel.Tema;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Aluno extends Usuario {
    @Column(nullable = false)
    private int pontuacao;

    @ManyToOne
    Responsavel responsavel;


    public Aluno(Long id, String CPF, String nome, String email, String password) {
        super(id, CPF, nome, email, password);

    }
}
