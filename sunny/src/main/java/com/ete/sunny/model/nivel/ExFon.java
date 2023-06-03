package com.ete.sunny.model.nivel;

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
public class ExFon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Nnivel;

}
