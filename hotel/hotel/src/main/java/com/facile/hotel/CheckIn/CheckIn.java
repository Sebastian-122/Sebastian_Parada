package com.facile.hotel.checkin;

import com.facile.hotel.habitaciones.Habitacion;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Habitacion habitacion;

    private LocalDateTime fechaCheckIn;

    private LocalDateTime fechaCheckOut; // 👈 NUEVO

    public CheckIn() {}

    public CheckIn(Habitacion habitacion) {
        this.habitacion = habitacion;
        this.fechaCheckIn = LocalDateTime.now();
    }

    public void realizarCheckOut() {
        this.fechaCheckOut = LocalDateTime.now();
    }

    public boolean estaActivo() {
        return fechaCheckOut == null;
    }

    public Long getId() { return id; }
    public Habitacion getHabitacion() { return habitacion; }
    public LocalDateTime getFechaCheckIn() { return fechaCheckIn; }
    public LocalDateTime getFechaCheckOut() { return fechaCheckOut; }
}
