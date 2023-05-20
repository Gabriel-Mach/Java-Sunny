package com.ete.sunny.controller;

import com.ete.sunny.model.UserComum;

import com.ete.sunny.services.ComumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class ComumController {
    @Autowired
    private ComumService comumService;

    @PostMapping("/criar")
    public ResponseEntity<UserComum> criar(UserComum usuario){
        comumService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/buscar")
    public ResponseEntity buscar(String CPF){
        var com = comumService.buscar(CPF);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/atualizar")
    public ResponseEntity atualizar(String CPF, UserComum comum){
        comumService.atualizar(CPF,comum);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(String CPF){
        comumService.delete(CPF);
        return  ResponseEntity.noContent().build();
    }


}
