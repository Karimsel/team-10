package de.unistuttgart.iste.ese.api;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNullApi;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

    String localOrigin = "http://localhost:5173";
    String vmOrigin = "http://193.196.55.75:8000";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // enable cross-origin resource sharing (CORS)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@Nonnull CorsRegistry registry) {
                // allow CORS requests for all resources and HTTP methods from the frontend origin
                CorsRegistration registration = registry.addMapping("/**")
                    .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE");
                /*String frontendUrl = System.getenv("FRONTEND_URL");
                if (frontendUrl != null) {
                    registration.allowedOrigins(frontendUrl);
                }*/
            }
        };
    }
}
