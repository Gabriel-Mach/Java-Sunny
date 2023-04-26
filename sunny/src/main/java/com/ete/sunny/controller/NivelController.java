package com.ete.sunny.controller;

import com.ete.sunny.model.Nivel;

import com.ete.sunny.services.NivelService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/niveis")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @PostMapping("/criar")
    public ResponseEntity<Nivel> criar(Nivel nivel){
        nivelService.create(nivel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
