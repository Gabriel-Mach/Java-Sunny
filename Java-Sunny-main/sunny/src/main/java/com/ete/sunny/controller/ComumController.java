package com.ete.sunny.controller;

import com.ete.sunny.model.UserComum;

import com.ete.sunny.services.ComumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class ComumController {
    @Autowired
    private ComumService comumService;

    @PostMapping("/criar")
    public ResponseEntity<UserComum> criar(UserComum usuario){
        comumService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<UserComum>> findall(){
        return ResponseEntity.ok(comumService.findAll());
    }


}
