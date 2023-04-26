package com.ete.sunny.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

public class UserResponsavel extends Usuario {
    @Column(nullable = false)
    private String telefone;


    @OneToMany (mappedBy = "UserResponsavel")
    private List <UserComum> Aluno;
}
