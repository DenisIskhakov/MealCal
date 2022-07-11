package com.example.mealcal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MealCalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealCalApplication.class, args);
    }

}
