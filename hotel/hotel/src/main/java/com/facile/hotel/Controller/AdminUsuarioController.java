package com.facile.hotel.Controller;

import com.facile.hotel.usuarios.Usuario;
import com.facile.hotel.usuarios.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/usuarios")
public class AdminUsuarioController {

    private final UsuarioService usuarioService;

    public AdminUsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "admin-usuarios";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin-usuario-form";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(
            @ModelAttribute Usuario usuario,
            @RequestParam String rol
    ) {
        usuarioService.crearUsuario(usuario, rol);
        return "redirect:/admin/usuarios";
    }

    @PostMapping("/cambiar-rol")
    public String cambiarRol(
            @RequestParam Long usuarioId,
            @RequestParam String rol
    ) {
        usuarioService.cambiarRol(usuarioId, rol);
        return "redirect:/admin/usuarios";
    }

    @PostMapping("/desactivar")
    public String desactivarUsuario(@RequestParam Long usuarioId) {
        usuarioService.desactivarUsuario(usuarioId);
        return "redirect:/admin/usuarios";
    }

    @PostMapping("/activar")
    public String activarUsuario(@RequestParam Long usuarioId) {
        usuarioService.activarUsuario(usuarioId);
        return "redirect:/admin/usuarios";
    }
}