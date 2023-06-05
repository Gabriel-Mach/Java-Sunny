package com.ete.sunny.services;

import com.ete.sunny.model.nivel.Tema;
import com.ete.sunny.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService {
    @Autowired
    private TemaRepository temaRepository;

    public void create(Tema tema){ temaRepository.save(tema); }

    public List<Tema> findAll(){
        return temaRepository.findAll();
    }

    public void delete(String id){
        Optional<Tema> tema = temaRepository.findById(id);
        tema.ifPresent(tema1 -> temaRepository.delete(tema1));
    }

    public Tema busca(String id){
        Optional<Tema> tema = temaRepository.findById(id);
        return tema.orElse(null);
    }
    public Tema atualizar(String id, Tema temaA){
        Optional<Tema> tema = temaRepository.findById(id);
        if(tema.isPresent()){
            tema.get().setNome(temaA.getNome());
            tema.get().setFase(temaA.getFase());
            tema.get().setJogador(temaA.getJogador());
            return temaRepository.save(tema.get());
        }else {
            return null;
        }
    }

}
