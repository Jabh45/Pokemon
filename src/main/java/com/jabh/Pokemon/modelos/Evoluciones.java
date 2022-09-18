package com.jabh.Pokemon.modelos;

import org.json.JSONObject;

import java.util.List;

public class Evoluciones {
    private List<Pokemon> cadenaEvoluciones;

    //parseamos el json para instanciar la clase
    Evoluciones(String jsonCadenaEvoluciones){
        JSONObject jsonObject = new JSONObject(jsonCadenaEvoluciones);

    }
}
