package com.facile.hotel.roles;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Rol() {}
    public Rol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
}