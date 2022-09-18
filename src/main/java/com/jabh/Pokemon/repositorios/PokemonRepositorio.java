package com.jabh.Pokemon.repositorios;

import com.jabh.Pokemon.modelos.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonRepositorio implements IPokemonRepositorio{
    private List<Pokemon> listaEventos = new ArrayList();

    @Override
    public void create(Object pokemon) {
        this.listaEventos.add((Pokemon)pokemon);
    }

    @Override
    public Object find(Object var1) {
        return null;
    }

    @Override
    public Object findDate(Object var1) {
        return null;
    }

    @Override
    public List findAll() {
        return listaEventos;
    }

    @Override
    public void update(Object var1) {

    }

    @Override
    public void delete(Object var1) {

    }
}
