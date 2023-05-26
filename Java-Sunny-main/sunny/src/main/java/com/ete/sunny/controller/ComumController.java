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
    public ResponseEntity<UserComum> criar(@RequestBody UserComum usuario){
        comumService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/buscar/{CPF}")
    public ResponseEntity buscar(@PathVariable String CPF){
        var com = comumService.buscar(CPF);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/atualizar/{CPF}")
    public ResponseEntity atualizar(@PathVariable String CPF,@RequestBody UserComum comum){
        comumService.atualizar(CPF,comum);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{CPF}")
    public ResponseEntity delete(@PathVariable String CPF){
        comumService.delete(CPF);
        return  ResponseEntity.noContent().build();
    }


}
