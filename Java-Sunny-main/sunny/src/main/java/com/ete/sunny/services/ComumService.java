package com.ete.sunny.services;

import com.ete.sunny.model.UserComum;

import com.ete.sunny.repository.ComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComumService {

    @Autowired
    private ComumRepository comumRepository;

    public void create(UserComum comum){
        comumRepository.save(comum);
    }

    public List<UserComum> findAll(){
        return comumRepository.findAll();
    }

    public void delete(String id){
        Optional<UserComum> comum = comumRepository.findById(id);
        comum.ifPresent(userComum -> comumRepository.delete(userComum));
    }
    public UserComum buscar(String id){
        Optional<UserComum> usuario = comumRepository.findById(id);
        return usuario.orElse(null);
    }
    public UserComum atualizar(String id, UserComum comum1){
        Optional<UserComum> comum = comumRepository.findById(id);
        if (comum.isPresent()){
            comum.get().setNome(comum1.getNome());
            comum.get().setEmail(comum1.getEmail());
            comum.get().setPassword(comum1.getPassword());
            comum.get().setPontuacao(comum1.getPontuacao());
            return comumRepository.save(comum.get());
        }else {
            return null;
        }
    }
}
