package com.demo.hola_spring.controladores;

import java.util.List;
import java.util.Optional;

/*import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hola_spring.modelos.Libro;
import com.demo.hola_spring.servicios.LibroServiceImpl;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroServiceImpl libroServiceImpl;

    public LibroController(LibroServiceImpl libroService) {
        this.libroServiceImpl = libroService;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        return new ResponseEntity<>(libroServiceImpl.getAllLibros(), HttpStatus.OK);
    }

    @GetMapping("/{id_libro}")
    public ResponseEntity<Libro> getLibroById(@PathVariable("id_libro") Long id) {
        Optional<Libro> libro = libroServiceImpl.getLibroById(id);
        return libro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
        libroServiceImpl.addLibro(libro);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }

    
}
