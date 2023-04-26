package com.ete.sunny.controller;

import com.ete.sunny.model.ExFon;
import com.ete.sunny.services.ExFonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ExFon")
public class ExFonController {
    @Autowired
    private ExFonService exFonService;

    @PostMapping("/criar")
    public ResponseEntity<ExFon> criar(ExFon exFon){
        exFonService.create(exFon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}