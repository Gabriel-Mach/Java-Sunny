package com.ete.sunny.repository;

import com.ete.sunny.model.Aluno;
import com.ete.sunny.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComumRepository extends JpaRepository<Aluno,Long> {
    Usuario findByEmail(String email);
    Optional<Aluno> findByCPF(String CPF);

}
