package cl.apicom.spring.backend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"cl.apicom.spring.backend.application", "cl.apicom.spring.backend.rest"})
@EntityScan("cl.apicom.spring.backend.entities")
@EnableJpaRepositories("cl.apicom.spring.backend.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}