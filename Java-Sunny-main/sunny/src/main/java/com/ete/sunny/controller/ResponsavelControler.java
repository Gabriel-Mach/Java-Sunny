package com.ete.sunny.controller;

import com.ete.sunny.model.DetalhesReponsavelRecord;
import com.ete.sunny.model.UserResponsavel;
import com.ete.sunny.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelControler {
    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping("/criar")
    public ResponseEntity criar(UserResponsavel user, UriComponentsBuilder uriBuilder){
        var userAux = responsavelService.create(user);
        var uri = uriBuilder.path("responsavel/criar/{cpf}").buildAndExpand(userAux.getCPF());
        return ResponseEntity.created(uri.toUri()).body(new DetalhesReponsavelRecord(userAux));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<UserResponsavel> atualizar(String CPF, UserResponsavel responsavel){
        responsavelService.atualizar(CPF, responsavel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public  ResponseEntity delete(String CPF){
        responsavelService.delete(CPF);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity buscar(String CPF){
        var cam = responsavelService.buscar(CPF);
        return ResponseEntity.ok().build();
    }


}
