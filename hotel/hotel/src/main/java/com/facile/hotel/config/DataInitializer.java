package com.facile.hotel.config;

import com.facile.hotel.roles.Rol;
import com.facile.hotel.roles.RolRepository;
import com.facile.hotel.usuarios.Usuario;
import com.facile.hotel.usuarios.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RolRepository rolRepo, UsuarioRepository userRepo) {
        return args -> {

            // ================= ROLES =================
            Rol adminRole = rolRepo.findByNombre("ROLE_ADMIN")
                    .orElseGet(() -> rolRepo.save(new Rol("ROLE_ADMIN")));

            Rol limpiezaRole = rolRepo.findByNombre("ROLE_LIMPIEZA")
                    .orElseGet(() -> rolRepo.save(new Rol("ROLE_LIMPIEZA")));

            Rol mantenimientoRole = rolRepo.findByNombre("ROLE_MANTENIMIENTO")
                    .orElseGet(() -> rolRepo.save(new Rol("ROLE_MANTENIMIENTO")));

            // ================= ADMIN PRINCIPAL =================
            if (userRepo.findByCedula("1013609866").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setCedula("1013609866");
                admin.setNombre("Sebastian");
                admin.setApellido("Parada");
                admin.setCorreo("sebasparada122@gmail.com");
                admin.setTelefono("1013609866");
                admin.setPassword(new BCryptPasswordEncoder().encode("Megaprojuan1"));
                admin.setRoles(Set.of(adminRole));
                admin.setEnabled(true);

                userRepo.save(admin);
                System.out.println("✔ ADMIN creado");
            }

           
        };
    }
}