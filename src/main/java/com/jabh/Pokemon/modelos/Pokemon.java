package com.jabh.Pokemon.modelos;

import org.json.*;
import org.springframework.format.Parser;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class Pokemon {
    private Integer id;
    private String name;
    private String imagen;
    private String color;
    private String habitat;
    private String cadenaEvolucion;

    //parseamos el json de pokemons para instanciar la clase
    public Pokemon(String url){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(result);

        this.id = (Integer) (jsonObject.get("id"));
        this.name = jsonObject.get("name").toString();
        this.imagen = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+this.id+".png";
        this.color = jsonObject.getJSONObject("color").get("name").toString();
        this.habitat = jsonObject.getJSONObject("habitat").get("name").toString();
        this.cadenaEvolucion = jsonObject.getJSONObject("evolution_chain").get("url").toString();

        System.out.println(this.id);
        System.out.println(this.imagen);
        System.out.println(this.name);
        System.out.println(this.color);
        System.out.println(this.habitat);
        System.out.println(this.cadenaEvolucion);
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
