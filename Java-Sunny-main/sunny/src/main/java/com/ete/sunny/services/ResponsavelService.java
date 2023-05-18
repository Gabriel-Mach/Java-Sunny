package com.ete.sunny.services;

import com.ete.sunny.model.UserResponsavel;
import com.ete.sunny.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {
    @Autowired
    private ResponsavelRepository responsavelRepository;

    public void create(UserResponsavel responsavel){responsavelRepository.save();}

    public void
}
