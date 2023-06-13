package com.ete.sunny.model.professor;

import com.ete.sunny.model.abstrato.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Usuario {
    @Column(nullable = false)
    private String telefoneProf;

    @Column(nullable = false)
    private String escola;


    public Professor(Long id, String cpf, String nome, String email, String password, String telefoneProf, String escola) {
        super(id,cpf,nome,email,password);
        this.telefoneProf = telefoneProf;
        this.escola = escola;
    }
}
