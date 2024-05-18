package com.demo.hola_spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/hola")
    public String Hola(){
        return "Hola Spring Boot";
    }


    @GetMapping("/personas/{id}")
    public Persona getPersona(@PathVariable int id){
        Persona persona = personaRepository.getPersona(id);
        return persona;
    }

    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return personaRepository.getPersonas();
    }


    
}
