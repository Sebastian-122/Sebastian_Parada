package com.facile.hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/limpieza")
public class LimpiezaController {

    @GetMapping
    public String vistaLimpieza() {
        // CARGA: templates/Limpieza.html
        return "Limpieza";
    }

    @PostMapping("/disponible/{id}")
    public String marcarDisponible(@PathVariable Long id) {
        return "redirect:/limpieza";
    }

    @PostMapping("/mantenimiento/{id}")
    public String enviarMantenimiento(@PathVariable Long id) {
        return "redirect:/limpieza";
    }
}
