package com.demo.hola_spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepository {
    private List<Persona> personas = new ArrayList<>();


    public PersonaRepository(){
        personas.add(new Persona(1000, "Galo", "Vera"));
        personas.add(new Persona(1001, "Maria", "Perez"));
        personas.add(new Persona(1002, "Luis", "Miranda"));
    }

    public Persona getPersona(int id){
        for(Persona persona: personas){
            if(id == persona.getId())
                return persona;

        }

        return null;
    }

    public List<Persona> getPersonas(){
        return personas;
    }
}
