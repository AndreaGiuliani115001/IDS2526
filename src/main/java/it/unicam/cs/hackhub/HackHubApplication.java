package it.unicam.cs.hackhub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HackHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackHubApplication.class, args);
    }

    @Bean
    public CommandLineRunner startupRunner() {
        return args -> System.out.println("HackHub Iteration 4: Spring Boot Engine Started");
    }
}
