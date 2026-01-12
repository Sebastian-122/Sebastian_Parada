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
public class CheckOutController {

    private final HabitacionRepository habitacionRepository;
    private final CheckInRepository checkInRepository;

    public CheckOutController(HabitacionRepository habitacionRepository,
                              CheckInRepository checkInRepository) {
        this.habitacionRepository = habitacionRepository;
        this.checkInRepository = checkInRepository;
    }

    @PostMapping("/checkout")
    public String realizarCheckOut(@RequestParam Long habitacionId) {

        Habitacion habitacion = habitacionRepository.findById(habitacionId)
                .orElseThrow();

        if (habitacion.getEstado() != EstadoHabitacion.OCUPADA) {
            return "redirect:/habitaciones?error";
        }

        CheckIn checkIn = checkInRepository
                .findByHabitacionIdAndFechaCheckOutIsNull(habitacionId)
                .orElseThrow();

        // cerrar check-in
        checkIn.realizarCheckOut();
        checkInRepository.save(checkIn);

        // pasar habitación a limpieza
        habitacion.setEstado(EstadoHabitacion.LIMPIEZA);
        habitacionRepository.save(habitacion);

        return "redirect:/habitaciones";
    }
}
