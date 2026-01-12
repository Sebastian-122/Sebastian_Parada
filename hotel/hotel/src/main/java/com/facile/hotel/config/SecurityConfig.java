package com.facile.hotel.config;

import com.facile.hotel.security.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // 🔓 PÁGINAS PÚBLICAS
                .requestMatchers(
                    "/", 
                    "/index",
                    "/login",
                    "/style.css",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // 🔐 ROLES
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/recepcion/**").hasRole("RECEPCION")

                // 🔒 TODO LO DEMÁS REQUIERE LOGIN
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(new LoginSuccessHandler())
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
