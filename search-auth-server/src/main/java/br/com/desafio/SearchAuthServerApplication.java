package br.com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAuthorizationServer //allows authentication
@EnableResourceServer
@EnableSwagger2 // allows Swagger
public class SearchAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchAuthServerApplication.class, args);
	}

}
