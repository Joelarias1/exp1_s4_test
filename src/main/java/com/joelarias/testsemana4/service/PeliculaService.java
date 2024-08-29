package com.joelarias.testsemana4.service;

import java.util.List;
import java.util.Optional;

import com.joelarias.testsemana4.model.Pelicula;

public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaById(Long id);

}

