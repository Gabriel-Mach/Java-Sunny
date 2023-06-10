package com.ete.sunny.controller;


import com.ete.sunny.model.aluno.DadosAlunoRecord;
import com.ete.sunny.model.aluno.DetalhesAlunoRecord;
import com.ete.sunny.services.ComumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private ComumService comumService;

    @PostMapping("/criar")
    public ResponseEntity criar(@Valid @RequestBody DadosAlunoRecord alunoRecord, UriComponentsBuilder uriBuilder){
        var alun = comumService.create(alunoRecord.toAluno(alunoRecord));
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(alun.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesAlunoRecord(alun));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        var com = comumService.buscarAlunoId(id);
        if (com == null) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhesAlunoRecord(com));
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id,@Valid @RequestBody DadosAlunoRecord alunoRecord){
        var alunaux = alunoRecord.toAluno(alunoRecord);
        if (comumService.existeAluno(id)) return  ResponseEntity.notFound().build();
        var alunoAtualizado = comumService.atualizarAluno(id, alunaux);
       return  ResponseEntity.ok(new DetalhesAlunoRecord(alunoAtualizado));
    }//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if (comumService.existeAluno(id)) return ResponseEntity.notFound().build();
        comumService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }


}
