package br.ufg.petsadoption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PetsAdoptionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsAdoptionServerApplication.class, args);
	}

}
