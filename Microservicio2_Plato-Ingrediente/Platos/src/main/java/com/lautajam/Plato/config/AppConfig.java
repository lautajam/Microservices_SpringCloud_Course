
package com.lautajam.Plato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    
    @Bean("apiIngredientes")
    public RestTemplate crearRestTemplateIngredientes(){
        return new RestTemplate();
    }
}
