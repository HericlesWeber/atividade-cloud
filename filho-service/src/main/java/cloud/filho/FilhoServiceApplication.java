package cloud.filho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FilhoServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FilhoServiceApplication.class, args);
	}
	
	@Autowired
	FilhoRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Filho(null, "João", 12, "Afeminado"));
		repository.save(new Filho(null, "Matheus", 13, "Macho"));
		repository.save(new Filho(null, "Hericles", 15, "Topzera"));
		repository.save(new Filho(null, "Maria", 15, "Homi"));
		repository.save(new Filho(null, "Pedrão", 20, "Nao sabe ainda"));
	}
}
