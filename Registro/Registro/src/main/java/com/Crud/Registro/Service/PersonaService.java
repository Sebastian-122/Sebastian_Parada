/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Crud.Registro.Service;

import com.Crud.Registro.model.Persona;
import com.Crud.Registro.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    // LISTAR TODAS LAS PERSONAS
    public Iterable<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    // GUARDAR PERSONA CON VALIDACIÓN
    public void guardar(Persona persona) {

        // Validar correo repetido
        if (personaRepository.existsByCorreo(persona.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        // Validar celular repetido
        if (personaRepository.existsByCelular(persona.getCelular())) {
            throw new IllegalArgumentException("El número ya está registrado");
        }

        personaRepository.save(persona);
    }

    // OBTENER PERSONA POR ID
    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    // ELIMINAR PERSONA
    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
}
