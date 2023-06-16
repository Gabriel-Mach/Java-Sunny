package com.ete.sunny.controller;

import com.ete.sunny.model.responsavel.DadosResponsavelRecord;
import com.ete.sunny.model.responsavel.DetalhesReponsavelRecord;
import com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ResponseEntity criar(@RequestBody DadosResponsavelRecord responsavelRecord, UriComponentsBuilder uriBuilder){
        var userAux = responsavelService.create(responsavelRecord.toResp(responsavelRecord));
        var uri = uriBuilder.path("responsavel/{id}").buildAndExpand(userAux.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesReponsavelRecord(userAux));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualizar(Long id, Responsavel responsavel){
        responsavelService.atualizar(id, responsavel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity delete(Long id){
        responsavelService.delete(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(Long id){
        var cam = responsavelService.buscar(id);
        return ResponseEntity.ok().build();
    }


}
