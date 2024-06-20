package kea.athleticsbackend;

import org.springframework.boot.SpringApplication;

public class TestAthleticsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(AthleticsBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
