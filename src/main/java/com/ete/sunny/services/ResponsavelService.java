package com.ete.sunny.services;


import com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsavelService {
    @Autowired
    private ResponsavelRepository responsavelRepository;

    public Responsavel create(Responsavel responsavel){
        return responsavelRepository.save(responsavel);}

    public Page<Responsavel> findAll(Pageable page) {
        return responsavelRepository.findAll(page);

    }

    public void delete(Long id){
        Optional<Responsavel> responsavel = responsavelRepository.findById(id);
        responsavel.ifPresent(userResponsavel -> responsavelRepository.delete(userResponsavel));

    }
    public Responsavel atualizar(Long id, Responsavel responsavel1) {
        var respp = responsavelRepository.findById(id);
        respp.get().setNome(responsavel1.getNome());
        respp.get().setEmail(responsavel1.getEmail());
        respp.get().setPassword(responsavel1.getPassword());
        respp.get().setTelefoneResp(responsavel1.getTelefoneResp());
        return responsavelRepository.save(respp.get());

    }
        public Responsavel buscar(Long id){
            Optional<Responsavel> resp = responsavelRepository.findById(id);
            return resp.orElse(null);
        }

}
