package com.ete.sunny.services;

import com.ete.sunny.model.UserComum;
import com.ete.sunny.model.Usuario;
import com.ete.sunny.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void create(UserComum usuario){
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public void delete(String id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        usuario.ifPresent(usuario1 -> usuarioRepository.delete(usuario1));
    }
    public Usuario buscar(String id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }
    public Usuario atualizar(String id, Usuario usuarioA){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            usuario.get().setNome(usuarioA.getNome());
            usuario.get().setEmail(usuarioA.getEmail());
            usuario.get().setPassword(usuarioA.getPassword());
            return usuarioRepository.save(usuario.get());
        }else {
            return null;
        }
    }
}
