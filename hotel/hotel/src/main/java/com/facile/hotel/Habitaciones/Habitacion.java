package com.facile.hotel.habitaciones;

import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;

    @Enumerated(EnumType.STRING)
    private TipoHabitacion tipo;

    @Enumerated(EnumType.STRING)
    private EstadoHabitacion estado;
    private Double precioNoche;
    
    

    public Habitacion() {}

    public Long getId() { return id; }
    public void setNumero(String numero) { this.numero = numero; }
    public void setPrecioNoche(double precioNoche) { this.precioNoche = precioNoche; }
    public void setTipo(TipoHabitacion tipo) { this.tipo = tipo; }
    public void setEstado(EstadoHabitacion estado) { this.estado = estado; }
    public String getNumero() { return numero; }
    public TipoHabitacion getTipo() { return tipo; }
    public EstadoHabitacion getEstado() { return estado; }
    public Double getPrecioNoche() { return precioNoche; }
}