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
        PoblarRepositorioPokemon(0);
        List<Pokemon> ListaPokemons = pokemonRepositorio.findAll();
        return new ModelAndView("index.html")
                .addObject("ListaPokemons", ListaPokemons);
    }

    @GetMapping("/{id}")
    public ModelAndView mostrarPokemons(@PathVariable Integer id) {
        PoblarRepositorioPokemon(calcularCompensacion(id));
        List<Pokemon> ListaPokemons = pokemonRepositorio.findAll();
        return new ModelAndView("index.html")
                .addObject("ListaPokemons", ListaPokemons);
    }

    @GetMapping("/pokemon/{id}")
    public ModelAndView mostrarDetallesDePokemos(@PathVariable Integer id) {
        Pokemon pokemon = new Pokemon("https://pokeapi.co/api/v2/pokemon-species/"+id);

        return new ModelAndView("pokemon").addObject("pokemon",pokemon);
    }

    @GetMapping("/evoluciones/{url}")
    public ModelAndView mostrarDetallesDeEvoluciones(@PathVariable String url) {
        List<Pokemon> evoluciones = new Evoluciones(url).getCadenaEvoluciones();

        return new ModelAndView("evoluciones").addObject("evoluciones", evoluciones);
    }

    private void PoblarRepositorioPokemon(int compensacion){
        this.pokemonRepositorio = new PokemonRepositorio();
        String url= "https://pokeapi.co/api/v2/pokemon-species"+"?offset="+compensacion+"&limit=20";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(result);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for(int i=0; i<jsonArray.length(); i++) {
            jsonObject = new JSONObject(jsonArray.get(i).toString());
            this.pokemonRepositorio.create(new Pokemon(jsonObject.get("url").toString()));
        }
    }

    private int calcularCompensacion(Integer id) {
        return (id-1)*20;
    }

}
