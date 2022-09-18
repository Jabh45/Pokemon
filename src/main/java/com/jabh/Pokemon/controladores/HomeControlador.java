package com.jabh.Pokemon.controladores;

import com.jabh.Pokemon.modelos.Pokemon;
import com.jabh.Pokemon.repositorios.PokemonRepositorio;
import org.json.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeControlador {
    private PokemonRepositorio pokemonRepositorio = new PokemonRepositorio();

    @GetMapping("")
    public ModelAndView verPaginaDeInicio() {
        PoblarRepositorioPoquemon();
        List<Pokemon> ListaPokemons = pokemonRepositorio.findAll();
        return new ModelAndView("index.html")
                .addObject("ListaPokemons", ListaPokemons);
    }

    private void PoblarRepositorioPoquemon(){
        String uri= "https://pokeapi.co/api/v2/pokemon-species";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject = new JSONObject(result);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for(int i=0; i<jsonArray.length(); i++) {
            jsonObject = new JSONObject(jsonArray.get(i).toString());
            this.pokemonRepositorio.create(new Pokemon(jsonObject.get("url").toString()));
        }
    }
}
