package com.example.Proyecto_WEB.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Proyecto_WEB.model.Pelicula;
import com.example.Proyecto_WEB.repository.PeliculaRepository;

@RestController
@RequestMapping("/api/peliculas") 
@CrossOrigin(origins = "*") 
public class PeliculaController {

    @Autowired
    private PeliculaRepository repository;

    // 1. LISTAR TODAS
    @GetMapping
    public List<Pelicula> listar() {
        return repository.findAll();
    }

    // 2. AÑADIR
    @PostMapping
    public Pelicula añadir(@RequestBody Pelicula pelicula) {
        return repository.save(pelicula);
    }

    // 3. EDITAR 
    @PutMapping("/{id}")
    public Pelicula editar(@PathVariable Long id, @RequestBody Pelicula peliculaActualizada) {
        return repository.findById(id).map(pelicula -> {
            pelicula.setTitulo(peliculaActualizada.getTitulo());
            pelicula.setAutor(peliculaActualizada.getAutor()); // Director
            pelicula.setPrecio(peliculaActualizada.getPrecio());
            pelicula.setAnio(peliculaActualizada.getAnio());
            pelicula.setImagen(peliculaActualizada.getImagen());
            return repository.save(pelicula);
        }).orElseThrow(() -> new RuntimeException("Película no encontrada con id: " + id));
    }

    // 4. BORRAR
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 5. BUSCAR POR TÍTULO
    @GetMapping("/buscar/titulo")
    public List<Pelicula> buscarPorTitulo(@RequestParam String nombre) {
        return repository.findByTituloContainingIgnoreCase(nombre);
    }

    // 6. BUSCAR POR DIRECTOR 
    @GetMapping("/buscar/autor")
    public List<Pelicula> buscarPorDirector(@RequestParam String nombre) {
        return repository.findByAutorContainingIgnoreCase(nombre);
    }

    // 7. BUSCAR ENTRE AÑOS 
    @GetMapping("/buscar/anios")
    public List<Pelicula> buscarEntreAnios(@RequestParam int inicio, @RequestParam int fin) {
        return repository.findByAnioBetween(inicio, fin);
    }
}