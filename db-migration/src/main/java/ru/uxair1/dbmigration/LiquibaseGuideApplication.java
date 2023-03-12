package ru.uxair1.dbmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiquibaseGuideApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiquibaseGuideApplication.class, args);
    }
    @Bean
    public ReactiveWebServerFactory reactiveWebServerFactory() {
        return new TomcatReactiveWebServerFactory();

    }
}
