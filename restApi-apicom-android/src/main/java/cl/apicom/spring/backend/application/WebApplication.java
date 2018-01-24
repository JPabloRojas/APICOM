package cl.apicom.spring.backend.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"cl.apicom.spring.backend.application", "cl.apicom.spring.backend.rest"})
@EntityScan("cl.apicom.spring.backend.entities")
@EnableJpaRepositories("cl.apicom.spring.backend.repository")
public class WebApplication extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}