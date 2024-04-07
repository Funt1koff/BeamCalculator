package ru.TechStud.BeamCalculator.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "BeamCalculatorApi",
                description = "Api for calculate epure cross force",
                contact = @Contact(
                        name = "Sergey Funtikov",
                        email = "sfuntikoff@gmail.com"
                ),
                version = "0.0.1a"
        )
)
@Configuration
public class OpenApiConfig {

}
