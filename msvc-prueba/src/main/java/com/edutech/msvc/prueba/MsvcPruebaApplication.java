package com.edutech.msvc.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcPruebaApplication.class, args);
	}

}
