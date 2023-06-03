package com.ete.sunny.repository;

import com.ete.sunny.model.nivel.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, String> {
}
