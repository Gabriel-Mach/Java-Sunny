package com.ete.sunny.services;


import com.ete.sunny.model.nivel.Nivel;
import com.ete.sunny.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class NivelService {
        @Autowired
        private NivelRepository nivelRepository;

        public  Nivel criarNvl(Nivel nivel){
            return nivelRepository.save(nivel);
        }
        public Nivel buscarNvl(Long id){
            Optional<Nivel> nivel = nivelRepository.findById(id);
            return nivel.orElse(null);
        }

    public Nivel atualizarNvl(Long id, Nivel nivelAux) {
            var nvl = nivelRepository.findById(id);
            nvl.get().setNome(nivelAux.getNome());
            nvl.get().setTema(nivelAux.getTema());
            nvl.get().setNumtentativas(nivelAux.getNumtentativas());
            nvl.get().setDicas(nivelAux.getDicas());
            return nivelRepository.save(nvl.get());
    }
    public void deleteNvl(Long id){
            nivelRepository.deleteById(id);
    }
    public  boolean existeNvl(Long id){
            return !nivelRepository.existsById(id);
    }

    public Page<Nivel> findAll(Pageable page) {
        return nivelRepository.findAll(page);}
}

