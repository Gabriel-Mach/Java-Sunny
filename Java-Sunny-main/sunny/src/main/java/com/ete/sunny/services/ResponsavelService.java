package com.ete.sunny.services;

import com.ete.sunny.model.UserComum;
import com.ete.sunny.model.UserResponsavel;
import com.ete.sunny.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService {
    @Autowired
    private ResponsavelRepository responsavelRepository;

    public UserResponsavel create(UserResponsavel responsavel){ return responsavelRepository.save(responsavel);}

    public List<UserResponsavel> findAll(){
        return responsavelRepository.findAll();
    }

    public void delete(String CPF){
        Optional<UserResponsavel> responsavel = responsavelRepository.findById(CPF);
        responsavel.ifPresent(userResponsavel -> responsavelRepository.delete(userResponsavel));

    }
    public UserResponsavel atualizar(String CPF, UserResponsavel responsavel1) {
        Optional<UserResponsavel> responsavel = responsavelRepository.findById(CPF);
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
        public UserResponsavel buscar(String CPF){
            Optional<UserResponsavel> resp = responsavelRepository.findById(CPF);
            return resp.orElse(null);
        }

}
