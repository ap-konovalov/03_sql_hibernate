package ru.netology.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    private static final String PASSWORD = "admin";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails userRead = User
                .withDefaultPasswordEncoder()
                .username("read")
                .password(PASSWORD)
                .roles("READ")
                .build();
        UserDetails userWrite = User
                .withDefaultPasswordEncoder()
                .username("write")
                .password(PASSWORD)
                .roles("WRITE")
                .build();
        UserDetails userDelete = User
                .withDefaultPasswordEncoder()
                .username("delete")
                .password(PASSWORD)
                .roles("DELETE")
                .build();
        return new InMemoryUserDetailsManager(List.of(userRead, userWrite, userDelete));
    }
}
