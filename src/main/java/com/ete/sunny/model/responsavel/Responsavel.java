package com.ete.sunny.model.responsavel;

import com.ete.sunny.model.abstrato.Usuario;
import com.ete.sunny.model.aluno.Aluno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel extends Usuario {

    @Column(nullable = false)
    private String telefoneResp;

    public Responsavel(Long id, String cpf, String nome, String email, String password, String telefoneResp){
        super(id,cpf,nome,email,password);
        this.telefoneResp = telefoneResp;
    }
}
