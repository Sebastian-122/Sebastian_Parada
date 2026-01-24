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
    public UserDetails loadUserByUsername(String cedula)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByCedula(cedula)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Cédula no encontrada"));

        return new org.springframework.security.core.userdetails.User(
                usuario.getCedula(),
                usuario.getPassword(),
                usuario.isEnabled(),
                true,
                true,
                true,
                usuario.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority(r.getNombre()))
                        .collect(Collectors.toList())
        );
    }
}
