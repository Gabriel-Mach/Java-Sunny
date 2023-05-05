package com.ete.sunny.services;

import com.ete.sunny.model.ExFon;
import com.ete.sunny.repository.ExFonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ExFonService {
    @Autowired
    private ExFonRepository exFonRepository;

    public void create(ExFon exFon){
        exFonRepository.save(exFon);
    }
    public List<ExFon> findAll(){
        return exFonRepository.findAll();
    }

    public void delete(Long id){
        Optional<ExFon> exFon = exFonRepository.findById(id);
        exFon.ifPresent(fon -> exFonRepository.delete(fon));
    }
    public ExFon busca(Long id){
        Optional<ExFon> exFon = exFonRepository.findById(id);
        return exFon.orElse(null);
    }
    public ExFon atualizar(Long id, ExFon exFonA){
        Optional<ExFon> exFon = exFonRepository.findById(id);
        if(exFon.isPresent()) {
            //o exFon.get() vai trazer o objeto ExFon de dentro do Optional
            exFon.get().setNumtentativas(exFonA.getNumtentativas());
            exFon.get().setDicas(exFonA.getDicas());
            exFon.get().setNumnvl(exFonA.getNumnvl());
            return exFonRepository.save(exFon.get());
        }else{
            return null;
        }



    }


}
