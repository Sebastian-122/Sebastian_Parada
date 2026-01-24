/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facile.hotel.Controller;

import com.facile.hotel.usuarios.Usuario;
import com.facile.hotel.usuarios.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // FORMULARIO DE REGISTRO
    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    // GUARDAR USUARIO PÚBLICO
    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        // 🔐 siempre ROLE_USER
        usuarioService.crearUsuario(usuario, "ROLE_USER");
        return "redirect:/login";
    }
}
