package com.ete.sunny.controller;

import com.ete.sunny.model.aluno.Aluno;

import com.ete.sunny.services.ComumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")

public class AlunoController {
    @Autowired
    private ComumService comumService;

    @PostMapping("/criar")
    public ResponseEntity<Aluno> criar(@Valid @RequestBody Aluno usuario){
        comumService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        var com = comumService.buscarAlunoId(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id,@RequestBody Aluno comum){
        comumService.atualizarAluno(id,comum);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if (comumService.existeAluno(id)) return ResponseEntity.notFound().build();
        comumService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }


}
