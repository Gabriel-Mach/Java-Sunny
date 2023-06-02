package com.ete.sunny.model.abistrato;

import com.ete.sunny.model.Usuario;
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


}
