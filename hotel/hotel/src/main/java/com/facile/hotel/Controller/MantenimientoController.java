package com.facile.hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {

    @GetMapping
    public String vistaMantenimiento() {
        // CARGA: templates/Mantenimiento.html
        return "Mantenimiento";
    }

    @PostMapping("/disponible/{id}")
    public String marcarDisponible(@PathVariable Long id) {
        return "redirect:/mantenimiento";
    }

    @PostMapping("/limpieza/{id}")
    public String enviarLimpieza(@PathVariable Long id) {
        return "redirect:/mantenimiento";
    }
}
