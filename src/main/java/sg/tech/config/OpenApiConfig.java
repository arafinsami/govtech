package sg.tech.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "MD. SAMIUL ARAFIN",
                        email = "sami.cse.1112@gmail.com",
                        url = "https://github.com/arafinsami"
                ),
                description = "OpenApi documentation for Spring practice",
                title = "OpenApi specification - Sami",
                version = "v1.0.0"
        )
)
public class OpenApiConfig {
}
