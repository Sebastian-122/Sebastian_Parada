package com.facile.hotel.config;

import com.facile.hotel.security.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // ====== PÚBLICO ======
                .requestMatchers(
                    "/",
                    "/index",
                    "/login",
                    "/register",
                    "/style.css",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // ====== ADMIN ======
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")

                // ====== LIMPIEZA ======
                .requestMatchers("/limpieza/**").hasAuthority("ROLE_LIMPIEZA")

                // ====== MANTENIMIENTO ======
                .requestMatchers("/mantenimiento/**").hasAuthority("ROLE_MANTENIMIENTO")

                // ====== USUARIO NORMAL ======
                .requestMatchers("/dashboard", "/dashboard/**")
                    .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

                // ====== TODO LO DEMÁS ======
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
