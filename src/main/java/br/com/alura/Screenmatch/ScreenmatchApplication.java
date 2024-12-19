package br.com.alura.Screenmatch;

import br.com.alura.Screenmatch.principal.Principal;
import br.com.alura.Screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
	@Autowired //injecão de dependência
	private SerieRepository repositorio; //criando um repositorio para salvar as séries

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();

	}
}
