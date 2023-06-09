package com.ete.sunny.repository;

import com.ete.sunny.model.aluno.Aluno;
import com.ete.sunny.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Usuario findByEmail(String email);
    Optional<Aluno> findByCPF(String CPF);

}
