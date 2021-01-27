package com.devsuperior.hrconfigserver;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
//CommandLineRunner serve para rodar alguns comandos
public class HrConfigServerApplication implements CommandLineRunner {

	//captura o valor da variavel de ambiente
	@Value("${spring.cloud.config.server.git.username}")
	private String username;
	@Value("${spring.cloud.config.server.git.password}")
	private String userpass;
	
	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	//imprime o valor capturado pela variavel de ambiente
/*	@Override
	public void run(String... args) throws Exception {
		System.out.println("USERNAME = " + username);
		System.out.println("USERPASS = " + userpass);
	}
*/
}
