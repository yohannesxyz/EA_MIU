package miu.edu.Lab14A.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( authConfig -> {
            authConfig.requestMatchers(HttpMethod.GET, "/shop").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/orders").hasRole("employee");
            authConfig.requestMatchers(HttpMethod.GET, "/payments").hasRole("finance");
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}

