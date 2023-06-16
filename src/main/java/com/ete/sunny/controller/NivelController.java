package com.ete.sunny.controller;

import com.ete.sunny.model.nivel.Nivel;

import com.ete.sunny.model.nivel.NivelRecord;
import com.ete.sunny.services.NivelService;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/niveis")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @PostMapping
    public ResponseEntity criarN(@Valid @RequestBody NivelRecord nivelRecord, UriComponentsBuilder builder){
        var nvl = nivelService.criarNvl(nivelRecord.toNivel(nivelRecord));
        var uri = builder.path("/niveis/{id}").buildAndExpand(nvl.getNumero());
        return ResponseEntity.created(uri.toUri()).body(nvl);
        /*Nao entendi o pq de estar pedindo o toUri*/
    }
    @GetMapping("/{id}")
    public ResponseEntity buscarNivel( @PathVariable Long id){
        var nvel = nivelService.buscarNvl(id);
        if (nvel == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new NivelRecord(nvel));
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizarNivel(@PathVariable Long id,@Valid @RequestBody NivelRecord nivel){
        var nvlAux = nivel.toNivel(nivel);
        if (nivelService.existeNvl(id))return ResponseEntity.notFound().build();
        var nvlAtual = nivelService.atualizarNvl(id,nvlAux);
        return ResponseEntity.ok(new NivelRecord(nvlAtual));
    }
    @DeleteMapping("/{numero}")
    public ResponseEntity <Nivel> delete(@PathVariable Long numero){
        nivelService.deleteNvl(numero);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault(size = 10,sort = {"nome"}) Pageable page){
        return ResponseEntity.ok(nivelService.findAll(page));
    }



}
