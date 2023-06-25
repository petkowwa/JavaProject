package bg.tu.petkowwa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(
        new Info().
            title("My movie API").
            contact(
                new Contact().
                    email("petkowwa.aa@gmail.com").name("Toni Petkova")

            ).
            description("Small API for movies/actors description.")
    );
  }

}
