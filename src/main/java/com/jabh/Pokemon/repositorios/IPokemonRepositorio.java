package com.jabh.Pokemon.repositorios;

import java.util.List;

public interface IPokemonRepositorio<T> {
    void create(T var1);

    T find(Object var1);

    T findDate(Object var1);

    List<T> findAll();

    void update(T var1);

    void delete(Object var1);
}
