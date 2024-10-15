package com.utcn.SCDProiect;

import org.springframework.boot.SpringApplication;

public class TestScdProiectApplication {

	public static void main(String[] args) {
		SpringApplication.from(ScdProiectApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
