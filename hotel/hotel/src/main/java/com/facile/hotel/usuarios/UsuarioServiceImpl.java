package com.facile.hotel.usuarios;

import com.facile.hotel.roles.Rol;
import com.facile.hotel.roles.RolRepository;
import jakarta.persistence.Column;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Usuario crearUsuario(Usuario usuario, String rolNombre) {
        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRoles(Set.of(rol));
        usuario.setEnabled(true);

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public void cambiarPassword(Long usuarioId, String nuevaPassword) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setPassword(passwordEncoder.encode(nuevaPassword));
        usuarioRepository.save(usuario);
    }

    @Override
    public void desactivarUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEnabled(false);
        usuarioRepository.save(usuario);
    }

    @Override
    public void activarUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEnabled(true);
        usuarioRepository.save(usuario);
    }

    @Override
    public void cambiarRol(Long usuarioId, String rolNombre) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        usuario.setRoles(Set.of(rol));
        usuarioRepository.save(usuario);
    }
    

   
}