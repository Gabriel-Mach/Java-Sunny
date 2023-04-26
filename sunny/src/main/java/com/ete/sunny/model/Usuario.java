package com.ete.sunny.model;

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
@Table(name = "User")
public abstract class Usuario {
    @Id
    private String CPF;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;


}
