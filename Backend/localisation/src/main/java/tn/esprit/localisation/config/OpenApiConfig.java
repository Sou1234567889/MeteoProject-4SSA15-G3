package tn.esprit.localisation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI localisationOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Service Localisation API")
                .description("Gestion des pays, régions et villes pour l'application météo")
                .version("1.0.0"));
    }
}