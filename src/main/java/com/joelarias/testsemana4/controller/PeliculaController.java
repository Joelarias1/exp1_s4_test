package com.joelarias.testsemana4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.joelarias.testsemana4.model.Pelicula;
import com.joelarias.testsemana4.service.PeliculaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {


    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelicula no encontrada"));
    }

}
