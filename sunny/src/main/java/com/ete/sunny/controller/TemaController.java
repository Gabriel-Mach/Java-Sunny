package com.ete.sunny.controller;

import com.ete.sunny.model.Tema;
import com.ete.sunny.services.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
