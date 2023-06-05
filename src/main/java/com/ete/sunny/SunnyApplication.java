package com.ete.sunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SunnyApplication {
	//Atualizar: desfazer as heranças de "usuario", e adaptar para sendo dois objetos diferentes
	// CRIAR REPOSITORY, CONTROLER E SERVICE PARA A NOVA FORMA!
	// Usar os seguintes links
	//https://mmarcosab.medium.com/crud-em-api-rest-com-spring-boot-h2-maven-e-jpa-hibernate-e-documenta%C3%A7%C3%A3o-com-swagger-parte-1-1040e2aae0ed
	//https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html
	public static void main(String[] args) {
		SpringApplication.run(SunnyApplication.class, args);
	}
	//Fazer os as pastas e os records

}
