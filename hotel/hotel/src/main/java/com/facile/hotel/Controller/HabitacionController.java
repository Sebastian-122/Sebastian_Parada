package com.facile.hotel.Controller;

import com.facile.hotel.habitaciones.EstadoHabitacion;
import com.facile.hotel.habitaciones.Habitacion;
import com.facile.hotel.habitaciones.HabitacionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HabitacionController {

    private final HabitacionRepository habitacionRepository;

    public HabitacionController(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    @GetMapping("/habitaciones")
    public String listarHabitaciones(Model model) {
        List<Habitacion> habitaciones = habitacionRepository.findAll();
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones";
    }
    @PostMapping("/habitaciones/limpia")
public String marcarComoLimpia(@RequestParam Long id) {

    Habitacion habitacion = habitacionRepository.findById(id)
            .orElseThrow();

    if (habitacion.getEstado() != EstadoHabitacion.LIMPIEZA) {
        return "redirect:/habitaciones?error";
    }

    habitacion.setEstado(EstadoHabitacion.DISPONIBLE);
    habitacionRepository.save(habitacion);

    return "redirect:/habitaciones";
}

}
