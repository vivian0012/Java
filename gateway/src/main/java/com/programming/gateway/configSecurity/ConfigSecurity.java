package com.programming.gateway.configSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

// Aqui a gente desabilita e habilita determinadas configurações padrões
@Configuration
@EnableWebFluxSecurity
public class ConfigSecurity implements WebFluxConfigurer {

    // Aqui podemos filtras certas informações de segurança.

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity serverHttpSecurity) {

        serverHttpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange ->
                        exchange
                                .pathMatchers("/eureka/**")
                                .permitAll()
                                .pathMatchers("/api/book/**")
                                .permitAll()
                                .pathMatchers("/api/category/**")
                                .permitAll()
                                .anyExchange()
                                .authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new CorsConfiguration();
                    corsConfig.addAllowedOrigin("http://127.0.0.1:5500"); // Permitindo todos da origem URL
                    corsConfig.addAllowedMethod("*"); // Todos os métodos
                    corsConfig.addAllowedHeader("*"); // Permitido todos os Headers
                    return corsConfig;
                }));

        return serverHttpSecurity.build();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                .allowedHeaders("*");
    }
}
