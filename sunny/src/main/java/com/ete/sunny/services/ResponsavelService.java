package com.ete.sunny.services;

import com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService {
    @Autowired
    private ResponsavelRepository responsavelRepository;

    public Responsavel create(Responsavel responsavel){ return responsavelRepository.save(responsavel);}

    public List<Responsavel> findAll(){
        return responsavelRepository.findAll();
    }

    public void delete(String CPF){
        Optional<Responsavel> responsavel = responsavelRepository.findById(CPF);
        responsavel.ifPresent(userResponsavel -> responsavelRepository.delete(userResponsavel));

    }
    public Responsavel atualizar(String CPF, Responsavel responsavel1) {
        Optional<Responsavel> responsavel = responsavelRepository.findById(CPF);
        if (responsavel.isPresent()) {
            responsavel.get().setNome(responsavel1.getNome());
            responsavel.get().setEmail(responsavel1.getEmail());
            responsavel.get().setPassword(responsavel1.getPassword());
            responsavel.get().setTelefone(responsavel1.getTelefone());
            return responsavelRepository.save(responsavel.get());
        } else {
            return null;
        }
    }
        public Responsavel buscar(String CPF){
            Optional<Responsavel> resp = responsavelRepository.findById(CPF);
            return resp.orElse(null);
        }

}
