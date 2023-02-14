package dio.bootcamp.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr.
 * Os seguintes modulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - h2 Database
 * - OpenFeign
 *
 * @author pablo.cunha
 */
@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
