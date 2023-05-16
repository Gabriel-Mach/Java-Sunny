package com.ete.sunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SunnyApplication {
	//Atualizar: desfazer as heranças de "usuario", e adaptar para sendo dois objetos diferentes
	// CRIAR REPOSITORY, CONTROLER E SERVICE PARA A NOVA FORMA!
	public static void main(String[] args) {
		SpringApplication.run(SunnyApplication.class, args);
	}

}
