package com.ete.sunny.model.responsavel;

import com.ete.sunny.model.Usuario;
import com.ete.sunny.model.abistrato.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel extends Usuario {

    @Column(nullable = false)
    private String telefone;


    @OneToMany (mappedBy = "responsavel")
    private List <com.ete.sunny.model.Aluno> aluno;
}
