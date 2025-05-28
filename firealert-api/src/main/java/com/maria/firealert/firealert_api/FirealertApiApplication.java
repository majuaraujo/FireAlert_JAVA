package com.maria.firealert.firealert_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //  Habilita tarefas automáticas
public class FirealertApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirealertApiApplication.class, args);
	}
}


