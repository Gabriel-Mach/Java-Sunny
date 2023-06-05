package com.ete.sunny.model.turma;

import com.ete.sunny.model.professor.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turma;
    @ManyToOne
    @JoinColumn(name = "id")
    private Professor professor;






}
