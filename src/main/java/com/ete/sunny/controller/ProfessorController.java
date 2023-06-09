package com.ete.sunny.controller;

import com.ete.sunny.model.professor.DadosProfessorRecord;
import com.ete.sunny.model.professor.DetalhesProfessorRecord;
import com.ete.sunny.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    @PostMapping
    public ResponseEntity criarProfessor(@Valid @RequestBody DadosProfessorRecord professorRecord, UriComponentsBuilder uriBuilder ){
        var professor = professorService.criarProf(professorRecord.toProfessor(professorRecord));
        var uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(professor);

    }
    @GetMapping
    public ResponseEntity findAll(@PageableDefault (size = 10,sort = {"nome"}) Pageable page){
        return ResponseEntity.ok(professorService.findAll(page));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarProfessor(@PathVariable Long id, @Valid @RequestBody DadosProfessorRecord professorRecord ){
        var profaux = professorRecord.toProfessor(professorRecord);
        if (professorService.existeProfessor(id)) return ResponseEntity.notFound().build();
        var profAtualizado = professorService.atualizarProfessor(id,profaux);
        return ResponseEntity.ok(new DetalhesProfessorRecord(profAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProfessor(@PathVariable Long id){
        if (professorService.existeProfessor(id)) return ResponseEntity.notFound().build();
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarProfId(@PathVariable Long id){
        var prof = professorService.buscarProfId(id);
        if (prof == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhesProfessorRecord(prof));
    }

}
