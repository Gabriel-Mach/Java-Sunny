package com.ete.sunny.controller;

import com.ete.sunny.model.Nivel;

import com.ete.sunny.services.NivelService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveis")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @PostMapping("/criar")
    public ResponseEntity<Nivel> criar(Nivel nivel){
        nivelService.create(nivel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/bucar")
    public ResponseEntity <Nivel> buscar(int id){
        return ResponseEntity.ok(nivelService.busca(id));
    }
    @PutMapping("/atualizar")
    public ResponseEntity <Nivel> atualizar(int id, Nivel nivel){
        nivelService.atualizar(id,nivel);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete")
    public ResponseEntity <Nivel> delete(int id){
        nivelService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
