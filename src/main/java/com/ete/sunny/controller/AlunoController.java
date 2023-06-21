package com.ete.sunny.controller;


import com.ete.sunny.model.aluno.DadosAlunoRecord;
import com.ete.sunny.model.aluno.DetalhesAlunoRecord;
import com.ete.sunny.model.responsavel.Responsavel;
import com.ete.sunny.services.AlunoService;
import com.ete.sunny.services.ResponsavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity criar(@Valid @RequestBody DadosAlunoRecord alunoRecord, UriComponentsBuilder uriBuilder){
        var alun = alunoService.createAluno(alunoRecord);
        var uri = uriBuilder.path("/alunos/post/{id}").buildAndExpand(alun.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesAlunoRecord(alun));
    }
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        var com = alunoService.buscarAlunoId(id);
        if (com == null) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhesAlunoRecord(com));
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id,@Valid @RequestBody DadosAlunoRecord alunoRecord){
        var alunaux = alunoRecord.toAluno();
        if (alunoService.existeAluno(id)) return  ResponseEntity.notFound().build();
        var alunoAtualizado = alunoService.atualizarAluno(id, alunaux);
       return  ResponseEntity.ok(new DetalhesAlunoRecord(alunoAtualizado));
    }//
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if (alunoService.existeAluno(id)) return ResponseEntity.notFound().build();
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable page){
        return ResponseEntity.ok(alunoService.findAll(page));
    }


}
