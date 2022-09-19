package com.jabh.Pokemon.modelos;

import org.json.JSONObject;

import java.util.List;

public class Evoluciones {
    private List<Pokemon> cadenaEvoluciones;

    //parseamos el json para instanciar la clase
    public Evoluciones(String url){

    }

    public List<Pokemon> getCadenaEvoluciones() {
        return cadenaEvoluciones;
    }

    public void setCadenaEvoluciones(List<Pokemon> cadenaEvoluciones) {
        this.cadenaEvoluciones = cadenaEvoluciones;
    }
}
