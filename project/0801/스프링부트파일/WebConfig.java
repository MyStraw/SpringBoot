package edu.pnu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) { //이걸 해줌으로서 cors disabled 안써도 된다. 이거 소용없어짐.
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE");
    }
}