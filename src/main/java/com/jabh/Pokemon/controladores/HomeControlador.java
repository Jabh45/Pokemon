package com.jabh.Pokemon.controladores;

import com.jabh.Pokemon.modelos.Evoluciones;
import com.jabh.Pokemon.modelos.Pokemon;
import com.jabh.Pokemon.repositorios.PokemonRepositorio;
import org.json.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeControlador {

    private PokemonRepositorio pokemonRepositorio;

    @GetMapping("")
    public ModelAndView verPaginaDeInicio() {
        pokemonRepositorio = new PokemonRepositorio(1);
        List<Pokemon> ListaPokemons = pokemonRepositorio.findAll();
        return new ModelAndView("index.html")
                .addObject("ListaPokemons", ListaPokemons);
    }

    @GetMapping("/{id}")
    public ModelAndView mostrarPokemons(@PathVariable Integer id) {
        pokemonRepositorio = new PokemonRepositorio(id);
        List<Pokemon> ListaPokemons = pokemonRepositorio.findAll();
        return new ModelAndView("index.html")
                .addObject("ListaPokemons", ListaPokemons);
    }

    @GetMapping("/pokemon/{id}")
    public ModelAndView mostrarDetallesDePokemos(@PathVariable Integer id) {
        Pokemon pokemon = new Pokemon("https://pokeapi.co/api/v2/pokemon-species/"+id);

        return new ModelAndView("pokemon").addObject("pokemon",pokemon);
    }

    @GetMapping("/evoluciones/{id}")
    public ModelAndView mostrarDetallesDeEvoluciones(@PathVariable Integer id) {
        Evoluciones evoluciones = new Evoluciones(id);
        List<Pokemon> listaEvoluciones = evoluciones.getCadenaEvoluciones();

        return new ModelAndView("evoluciones").addObject("listaEvoluciones", listaEvoluciones);
    }



}
