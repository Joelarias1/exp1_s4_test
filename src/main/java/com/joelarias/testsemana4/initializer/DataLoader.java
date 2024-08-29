package com.joelarias.testsemana4.initializer; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.joelarias.testsemana4.model.Pelicula;
import com.joelarias.testsemana4.repository.PeliculaRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public void run(String... args) throws Exception {
        peliculaRepository.save(new Pelicula(null, "Interstellar", 2014, "Christopher Nolan", "Ciencia ficción", "Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad."));
        peliculaRepository.save(new Pelicula(null, "Oppenheimer", 2023, "Christopher Nolan", "Biografía", "La vida de J. Robert Oppenheimer, el físico detrás de la bomba atómica."));
        peliculaRepository.save(new Pelicula(null, "Deadpool", 2016, "Tim Miller", "Comedia", "Un mercenario bocazas con un acelerado factor de curación busca venganza."));
        peliculaRepository.save(new Pelicula(null, "Transformers", 2007, "Michael Bay", "Acción/", "Robots alienígenas luchan en la Tierra, y los humanos quedan atrapados en el medio."));
        peliculaRepository.save(new Pelicula(null, "Avengers: Infinity War", 2018, "Anthony y Joe Russo", "Aventura", "Los Vengadores y sus aliados intentan derrotar al poderoso Thanos antes de que su ataque de devastación y ruina ponga fin al universo."));
    }
}
