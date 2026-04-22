package com.example.Proyecto_WEB.repository;



import com.example.Proyecto_WEB.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
    List<Pelicula> findByAutorContainingIgnoreCase(String director);
    List<Pelicula> findByAnioBetween(int inicio, int fin);
}