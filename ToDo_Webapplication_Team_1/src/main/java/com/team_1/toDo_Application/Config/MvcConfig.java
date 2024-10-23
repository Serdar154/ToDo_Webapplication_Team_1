package com.team_1.toDo_Application.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Stellt sicher, dass die HTML-Seiten über die entsprechenden Routen erreichbar sind
        registry.addViewController("/").setViewName("index"); // Startseite
        registry.addViewController("/index").setViewName("index"); // Zusätzliches Mapping für /index
        registry.addViewController("/projektverwaltung").setViewName("projektverwaltung");
        registry.addViewController("/projektErstellen").setViewName("projektErstellen");
        registry.addViewController("/projektBearbeiten").setViewName("projektBearbeiten");
        registry.addViewController("/lernplanverwaltung").setViewName("lernplanverwaltung");
        registry.addViewController("/to-dos").setViewName("to-dos");
        registry.addViewController("/kalender").setViewName("kalender");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Konfiguriert CORS, damit Anfragen von http://localhost:8080 zugelassen werden
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080") // Erlaubt Anfragen von diesem Origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Erlaubt diese HTTP-Methoden
                .allowedHeaders("*") // Erlaubt alle Header
                .allowCredentials(true); // Erlaubt das Senden von Cookies/Session-Informationen
    }
}
