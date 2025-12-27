package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

    SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()

                // API metadata
                .info(new Info()
                        .title("Visitor Risk Scoring API")
                        .version("1.0")
                        .description("Backend API documentation for Visitor Risk Scoring Engine"))
                // Server configuration
                .servers(List.of(
                        new Server().url("https://9149.pro604cr.amypo.ai/")
                ));
    }
}
    