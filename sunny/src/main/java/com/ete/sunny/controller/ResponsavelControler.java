package com.ete.sunny.controller;

import com.ete.sunny.model.DetalhesReponsavelRecord;
import com.ete.sunny.model.Responsavel;
import com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelControler {
    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping("/criar")
    public ResponseEntity criar(@RequestBody Responsavel user, UriComponentsBuilder uriBuilder){
        var userAux = responsavelService.create(user);
        var uri = uriBuilder.path("responsavel/criar/{cpf}").buildAndExpand(userAux.getCPF()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesReponsavelRecord(userAux));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Responsavel> atualizar(String CPF, Responsavel responsavel){
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
