/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Crud.Registro.Repository;

import com.Crud.Registro.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author Juan
 */
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    boolean existsByCorreo(String correo);

boolean existsByCelular(String celular);
}
