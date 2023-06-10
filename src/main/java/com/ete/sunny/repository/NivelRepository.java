package com.ete.sunny.repository;

import com.ete.sunny.model.nivel.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NivelRepository extends JpaRepository<Nivel, Long> {
    Nivel findByNome (String nome);

}
