package org.polytech.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class CovidApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApiApplication.class, args);
	}

}
