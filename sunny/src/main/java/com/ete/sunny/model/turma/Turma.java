package com.ete.sunny.model;

import com.ete.sunny.model.abistrato.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
package com.ete.sunny.model.;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id")
    private Professor professor;






}
