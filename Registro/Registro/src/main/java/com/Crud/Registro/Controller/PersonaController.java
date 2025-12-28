/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Crud.Registro.Controller;

import com.Crud.Registro.Service.PersonaService;
import com.Crud.Registro.model.Persona;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Juan
 */
 @Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("personas", personaService.listarTodas());
        return "persona-list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "persona-form";
    }

    @PostMapping
public String guardarPersona(
        @Valid Persona persona,
        BindingResult result,
        Model model,
        RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
        return "persona-form";
    }

    try {
        personaService.guardar(persona);
    } catch (Exception e) {
        model.addAttribute("error", "El correo o el celular ya están registrados");
        return "persona-form";
    }

    redirectAttributes.addFlashAttribute(
        "success",
        "Persona registrada correctamente"
    );

    return "redirect:/personas";
}


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "persona-form";
    }

   @GetMapping("/eliminar/{id}")
public String eliminarPersona(
        @PathVariable Long id,
        RedirectAttributes redirectAttributes) {

    personaService.eliminar(id);

    redirectAttributes.addFlashAttribute(
        "success",
        "Persona eliminada correctamente"
    );

    return "redirect:/personas";
}

}
