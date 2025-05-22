package com.edutech.msvc.evaluaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcEvaluacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcEvaluacionesApplication.class, args);
	}

}
