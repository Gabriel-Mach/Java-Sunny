package com.ete.sunny.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Inherited;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CPF;
    @Column (nullable = false)
    private String nome;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;


}
