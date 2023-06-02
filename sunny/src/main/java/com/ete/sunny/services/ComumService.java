package com.ete.sunny.services;

import com.ete.sunny.model.Aluno;

import com.ete.sunny.repository.ComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComumService {

    @Autowired
    private ComumRepository comumRepository;

    public void create(Aluno comum){
        comumRepository.save(comum);
    }

    public List<Aluno> findAll(){
        return comumRepository.findAll();
    }

    public void delete(String id){
        Optional<Aluno> comum = comumRepository.findByCPF(id);
        comum.ifPresent(userComum -> comumRepository.delete(userComum));
    }
    public Aluno buscar(String id){
        Optional<Aluno> usuario = comumRepository.findByCPF(id);
        return usuario.orElse(null);
    }
    public Aluno atualizar(String id, Aluno comum1){
        Optional<Aluno> comum = comumRepository.findByCPF(id);
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
