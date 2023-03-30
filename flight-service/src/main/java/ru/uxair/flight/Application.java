package ru.uxair.flight;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = " UX Air API", version = "0.0.1"),
        servers = {@Server(url="http://localhost:8080")},
        tags = {@Tag(name = "Destination", description = "This is the Destination .")}

)
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}

