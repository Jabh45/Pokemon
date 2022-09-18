package com.jabh.Pokemon.modelos;

import org.json.*;
import org.springframework.format.Parser;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Pokemon {
    private Integer id;
    private String name;
    private String tipo;
    private String descripcion;
    private String imagen;
    private String color;
    private String habitat;
    private String cadenaEvolucion;

    //parseamos el json de pokemons para instanciar la clase
    Pokemon(String jsonPokemon){
        JSONObject jsonObject = new JSONObject(jsonPokemon);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getCadenaEvolucion() {
        return cadenaEvolucion;
    }

    public void setCadenaEvolucion(String cadenaEvolucion) {
        this.cadenaEvolucion = cadenaEvolucion;
    }
}
