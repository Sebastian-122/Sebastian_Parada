/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facile.hotel.Controller;

import com.facile.hotel.checkin.CheckIn;
import com.facile.hotel.checkin.CheckInRepository;
import com.facile.hotel.habitaciones.EstadoHabitacion;
import com.facile.hotel.habitaciones.Habitacion;
import com.facile.hotel.habitaciones.HabitacionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    private final HabitacionRepository habitacionRepository;
    private final CheckInRepository checkInRepository;

    public CheckInController(HabitacionRepository habitacionRepository,
                             CheckInRepository checkInRepository) {
        this.habitacionRepository = habitacionRepository;
        this.checkInRepository = checkInRepository;
    }

    @PostMapping("/checkin")
    public String realizarCheckIn(@RequestParam Long habitacionId) {

        Habitacion habitacion = habitacionRepository.findById(habitacionId)
                .orElseThrow();

        if (habitacion.getEstado() != EstadoHabitacion.DISPONIBLE) {
            return "redirect:/habitaciones?error";
        }

        habitacion.setEstado(EstadoHabitacion.OCUPADA);
        habitacionRepository.save(habitacion);

        CheckIn checkIn = new CheckIn(habitacion);
        checkInRepository.save(checkIn);

        return "redirect:/habitaciones";
    }
}
