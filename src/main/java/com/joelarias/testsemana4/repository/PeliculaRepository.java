package com.joelarias.testsemana4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joelarias.testsemana4.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}