package com.ete.sunny.repository;

import com.ete.sunny.model.UserComum;
import com.ete.sunny.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UserComum,String> {
    Usuario findByEmail(String email);

}
