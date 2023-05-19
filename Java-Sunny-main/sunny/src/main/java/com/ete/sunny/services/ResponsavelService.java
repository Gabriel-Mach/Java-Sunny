package com.ete.sunny.services;

import com.ete.sunny.model.UserComum;
import com.ete.sunny.model.UserResponsavel;
import com.ete.sunny.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {
    @Autowired
    private ResponsavelRepository responsavelRepository;

    public void create(UserResponsavel responsavel){responsavelRepository.save(responsavel);}

    public List<UserResponsavel> findAll(){
        return responsavelRepository.findAll();
    }

}
