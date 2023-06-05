package com.ete.sunny.controller;

import com.ete.sunny.model.nivel.Tema;
import com.ete.sunny.services.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tema")
public class TemaController {
    @Autowired
    private TemaService temaService;

    @PostMapping("/criar")
    public ResponseEntity<Tema> criar(Tema tema){
        temaService.create(tema);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/buscar")
    public ResponseEntity <Tema> buscar(String titulo){
        var tit = temaService.busca(titulo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar")
    public ResponseEntity <Tema> atualizar(String titulo, Tema tema){
        temaService.atualizar(titulo, tema);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity <Tema> delete(String titulo){
        temaService.delete(titulo);
        return ResponseEntity.noContent().build();
    }
}
