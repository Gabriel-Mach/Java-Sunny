package com.ete.sunny.controller;

import com.ete.sunny.model.responsavel.DadosResponsavelRecord;
import com.ete.sunny.model.responsavel.DetalhesReponsavelRecord;
import com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelControler {
    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity findAll(@PageableDefault(size = 10,sort = {"nome"}) Pageable page){
        return ResponseEntity.ok(responsavelService.findAll(page));
    }

    @PostMapping("/criar")
    public ResponseEntity criar(@RequestBody DadosResponsavelRecord user, UriComponentsBuilder uriBuilder){
        var userAux = responsavelService.create(user.toResp());
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
