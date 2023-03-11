package ru.uxair1.apigateway.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/authorization-service/**") // Добавлен маршрут для микросервиса 1
                        .uri("http://localhost:8081")) // Указан адрес микросервиса 1
                .route(p -> p
                        .path("/config-service/**") // Добавлен маршрут для микросервиса 2
                        .uri("http://localhost:8082")) // Указан адрес микросервиса 2
                .route(p -> p
                        .path("/db-migration/**") // Добавлен маршрут для микросервиса 3
                        .uri("http://localhost:8083")) // Указан адрес микросервиса 3
                .route(p -> p
                        .path("/eureka-server/**") // Добавлен маршрут для микросервиса 4
                        .uri("http://localhost:8084")) // Указан адрес микросервиса 4
                .route(p -> p
                        .path("/flight-service/**") // Добавлен маршрут для микросервиса 5
                        .uri("http://localhost:8085")) // Указан адрес микросервиса 5
                .route(p -> p
                        .path("/notification-service/**") // Добавлен маршрут для микросервиса 6
                        .uri("http://localhost:8086")) // Указан адрес микросервиса 6
                .route(p -> p
                        .path("/user-management/**") // Добавлен маршрут для микросервиса 7
                        .uri("http://localhost:8087")) // Указан адрес микросервиса 7
                .build();
    }
}

