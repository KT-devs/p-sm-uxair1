package ru.uxair.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppInit {
    public static void main(String[] args) {
        SpringApplication.run(AppInit.class, args);

    }
}
