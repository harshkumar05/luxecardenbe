package com.pp.luxecardenbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.pp.luxecardenbe.repository.h2"})
public class LuxecardenbeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuxecardenbeApplication.class, args);
	}

}
