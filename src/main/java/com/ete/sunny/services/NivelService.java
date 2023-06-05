package com.ete.sunny.services;

import com.ete.sunny.model.nivel.Nivel;
import com.ete.sunny.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelService {
        @Autowired
        private NivelRepository nivelRepository;

        public void create(Nivel nivel){
            nivelRepository.save(nivel);
        }

        public List<Nivel> findAll(){
            return nivelRepository.findAll();
        }

        public void delete(int id){
            Optional<Nivel> nivel = nivelRepository.findById(id);
            nivel.ifPresent(nivel1 -> nivelRepository.delete(nivel1));
        }
        public Nivel busca(int id){
            Optional<Nivel> nivel = nivelRepository.findById(id);
            return nivel.orElse(null);
        }

        public Nivel atualizar(int id, Nivel nivelA){
            Optional<Nivel> nivel = nivelRepository.findById(id);
            if(nivel.isPresent()){
                nivel.get().setNumero(nivelA.getNumero());
                nivel.get().setNome(nivelA.getNome());
                nivel.get().setExercicio(nivelA.getExercicio());
                return nivelRepository.save(nivel.get());
            }else {
                return  null;
            }
        }

}

