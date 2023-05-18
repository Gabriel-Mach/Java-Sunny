package com.ete.sunny.controller;

import com.ete.sunny.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelControler {
    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping

}
