package com.ete.sunny.repository;

import com.ete.sunny.model.Aluno;
import com.ete.sunny.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Aluno,String> {
    Usuario findByEmail(String email);

}
