package com.example.Proyecto_WEB.model;


import jakarta.persistence.*;


@Entity

public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor; 
    private Double precio;
    private Integer anio;

   

    private String imagen; 
    public Long getId() {
        return id;
    }

    // Constructor vacío (OBLIGATORIO para JPA)
    public Pelicula() {
    }

    // Constructor con todos los campos (Para crear pelis fácilmente)
    public Pelicula(Long id, String titulo, String autor, Double precio, Integer anio, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.anio = anio;
        this.imagen = imagen;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getAnio() {
        return anio;
    }
    public void setAnio(Integer anio) {
        this.anio = anio;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
  



}