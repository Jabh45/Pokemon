package com.jabh.Pokemon.modelos;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Evoluciones {
    private List<Pokemon> cadenaEvoluciones;

    //parseamos el json para instanciar la clase
    public Evoluciones(int id){
        cadenaEvoluciones = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://pokeapi.co/api/v2/evolution-chain/"+id, String.class);
        JSONObject jsonObject = new JSONObject(result);

        JSONObject evolucionInicial = jsonObject.getJSONObject("chain");
        Pokemon pokemonBase = new Pokemon(evolucionInicial.getJSONObject("species").get("url").toString());
        this.cadenaEvoluciones.add(pokemonBase);
        System.out.println("entre");

        JSONArray cadena = evolucionInicial.getJSONArray("evolves_to");

        GenerarCadenaEvoluciones(cadena);
    }

    public List<Pokemon> getCadenaEvoluciones() {
        return cadenaEvoluciones;
    }

    public void setCadenaEvoluciones(List<Pokemon> cadenaEvoluciones) {
        this.cadenaEvoluciones = cadenaEvoluciones;
    }

    private void GenerarCadenaEvoluciones(JSONArray cadena){
        JSONObject jsonObject;
        for(int i=0; i<cadena.length(); i++) {
            jsonObject = new JSONObject(cadena.get(i).toString());
            cadenaEvoluciones.add(new Pokemon(jsonObject.getJSONObject("species").get("url").toString()));
            GenerarCadenaEvoluciones(jsonObject.getJSONArray("evolves_to"));
            System.out.println("entre");

        }
    }
}
