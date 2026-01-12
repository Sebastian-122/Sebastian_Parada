package com.facile.hotel.security;

import com.facile.hotel.usuarios.Usuario;
import com.facile.hotel.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("DEBUG: Intentando buscar al usuario: " + username);
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("DEBUG: Usuario '" + username + "' NO fue encontrado en la BD");
                    return new UsernameNotFoundException("Usuario no encontrado");
                });

        return new org.springframework.security.core.userdetails.User(
            usuario.getUsername(),
            usuario.getPassword(),
            usuario.isEnabled(),
            true,
            true,
            true,
            usuario.getRoles().stream()
                    .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                    .collect(Collectors.toList())
        );
    }
}