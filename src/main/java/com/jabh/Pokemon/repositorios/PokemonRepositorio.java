package com.jabh.Pokemon.repositorios;

import com.jabh.Pokemon.modelos.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class PokemonRepositorio implements IPokemonRepositorio{
    private List<Pokemon> listaPokemons;
    private int cantidadAnterior;
    private int cantidadActual;
    private int cantidadSiguiente;

    public PokemonRepositorio(int id) {
        PoblarRepositorioPokemon(id);
    }
    @Override
    public void create(Object pokemon) {
        listaPokemons.add((Pokemon)pokemon);
    }

    @Override
    public Object find(Object id) {
        return null;
    }

    @Override
    public Object findDate(Object var1) {
        return null;
    }

    @Override
    public List findAll() {
        return listaPokemons;
    }

    @Override
    public void update(Object var1) {

    }

    @Override
    public void delete(Object var1) {

    }

    private void PoblarRepositorioPokemon(int compensacion){
        listaPokemons = new ArrayList();
        String url= "https://pokeapi.co/api/v2/pokemon-species"+"?offset="+calcularCompensacion(compensacion)+"&limit=20";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(result);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for(int i=0; i<jsonArray.length(); i++) {
            jsonObject = new JSONObject(jsonArray.get(i).toString());
            this.create(new Pokemon(jsonObject.get("url").toString()));
        }
    }

    private int calcularCompensacion(Integer id) {
        return (id-1)*20;
    }
}
