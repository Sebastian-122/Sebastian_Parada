package com.facile.hotel.config;

import com.facile.hotel.habitaciones.EstadoHabitacion;
import com.facile.hotel.habitaciones.Habitacion;
import com.facile.hotel.habitaciones.HabitacionRepository;
import com.facile.hotel.habitaciones.TipoHabitacion;
import com.facile.hotel.roles.Rol;
import com.facile.hotel.roles.RolRepository;
import com.facile.hotel.usuarios.Usuario;
import com.facile.hotel.usuarios.UsuarioRepository;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(RolRepository rolRepository, UsuarioRepository usuarioRepository) {
        return args -> {
            Rol adminRole = rolRepository.findByNombre("ROLE_ADMIN")
                    .orElseGet(() -> rolRepository.save(new Rol(null, "ROLE_ADMIN")));
            Rol userRole = rolRepository.findByNombre("ROLE_USER")
                    .orElseGet(() -> rolRepository.save(new Rol(null, "ROLE_USER")));
            Rol employeeRole = rolRepository.findByNombre("ROLE_EMPLOYEE")
                    .orElseGet(() -> rolRepository.save(new Rol(null, "ROLE_EMPLOYEE")));

            PasswordEncoder encoder = new BCryptPasswordEncoder();

            if (usuarioRepository.findByUsername("Sebastian").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUsername("Sebastian");
                admin.setPassword(encoder.encode("1234"));
                admin.setRoles(Set.of(adminRole));
                usuarioRepository.save(admin);
                System.out.println("✔ Usuario Sebastian creado");
            }

            if (usuarioRepository.findByUsername("Laura").isEmpty()) {
                Usuario user = new Usuario();
                user.setUsername("Laura");
                user.setPassword(encoder.encode("1234"));
                user.setRoles(Set.of(userRole));
                usuarioRepository.save(user);
                System.out.println("✔ Usuario Laura creado");
            }

            if (usuarioRepository.findByUsername("David").isEmpty()) {
                Usuario employee = new Usuario();
                employee.setUsername("David");
                employee.setPassword(encoder.encode("1234"));
                employee.setRoles(Set.of(employeeRole));
                usuarioRepository.save(employee);
                System.out.println("✔ Usuario David creado");
            }
        };
    }

    @Bean
    CommandLineRunner initHabitaciones(HabitacionRepository repo) {
        return args -> {
            if (repo.count() > 0) return;
            for (int i = 1; i <= 10; i++) {
                Habitacion h = new Habitacion();
                h.setNumero("H-" + i);
                h.setTipo(TipoHabitacion.HABITACION_SENCILLA);
                h.setEstado(EstadoHabitacion.DISPONIBLE);
                h.setPrecioNoche(300000.0);
                repo.save(h);
            }
            for (int i = 1; i <= 27; i++) {
                Habitacion h = new Habitacion();
                h.setNumero("A-" + i);
                if (i % 3 == 0) {
                    h.setTipo(TipoHabitacion.APARTAMENTO_DUPLEX);
                    h.setPrecioNoche(600000.0);
                } else {
                    h.setTipo(TipoHabitacion.APARTAMENTO_SIMPLE);
                    h.setPrecioNoche(400000.0);
                }
                h.setEstado(EstadoHabitacion.DISPONIBLE);
                repo.save(h);
            }
            System.out.println("✔ Habitaciones creadas correctamente");
        };
    }
}