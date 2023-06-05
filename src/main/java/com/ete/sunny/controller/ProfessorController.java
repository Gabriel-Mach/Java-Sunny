package com.ete.sunny.controller;

import com.ete.sunny.model.professor.DadosProfessorRecord;
import com.ete.sunny.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    public ResponseEntity criar(@RequestBody DadosProfessorRecord professorRecord, UriComponentsBuilder uriBuilder ){
        var professor = professorService.criar(professorRecord.toProfessor(professorRecord));
        var uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(professor);

    }

}
