package com.ete.sunny.repository;

import com.ete.sunny.model.UserComum;
import com.ete.sunny.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComumRepository extends JpaRepository<UserComum,Long> {
    Usuario findByEmail(String email);
    Optional<UserComum> findByCPF(String CPF);

}
