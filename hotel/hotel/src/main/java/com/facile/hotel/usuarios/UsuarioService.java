package com.facile.hotel.usuarios;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario, String rolNombre);

    List<Usuario> listarUsuarios();

    Usuario buscarPorCedula(String cedula);

    void cambiarPassword(Long usuarioId, String nuevaPassword);

    void desactivarUsuario(Long usuarioId);

    void activarUsuario(Long usuarioId);

    void cambiarRol(Long usuarioId, String rolNombre);
}
