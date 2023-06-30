package ru.test.java.planflight.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact rarmContact = new Contact()
                .email("avtorutet123@gmail.com")
                .url("My url")
                .name("Yuriy Alchin");

        return new OpenAPI()
                .info(new Info().title("Тестовый проект \"Планирование полетов\"")
                        .description("API для работы с модулем планирования полетов")
                        .contact(rarmContact)
                        .version("0.0.1"));
    }

}
