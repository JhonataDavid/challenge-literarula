package com.jhonata.challenge.literalura;

import com.jhonata.challenge.literalura.view.InterfaceUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private final InterfaceUsuario interfaceUsuario;

	public LiteraluraApplication(InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario =  interfaceUsuario;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		interfaceUsuario.exibirMenu();
	}
}
