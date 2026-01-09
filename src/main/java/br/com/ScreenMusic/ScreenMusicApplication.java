package br.com.ScreenMusic;

import br.com.ScreenMusic.Classes.ArtistaRepository;
import br.com.ScreenMusic.Principal.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMusicApplication implements CommandLineRunner {

    @Autowired
    private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenMusicApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main(repository);
        main.menu();
    }
}
