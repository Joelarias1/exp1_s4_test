package com.joelarias.testsemana4;

import com.joelarias.testsemana4.controller.PeliculaController;
import com.joelarias.testsemana4.model.Pelicula;
import com.joelarias.testsemana4.service.PeliculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaService peliculaService;

    private Pelicula pelicula1;
    private Pelicula pelicula2;

    @BeforeEach
    void setUp() {
        // Crear películas de prueba
        pelicula1 = new Pelicula(1L, "Pelicula 1", 2020, "Director 1", "Acción", "Sinopsis 1");
        pelicula2 = new Pelicula(2L, "Pelicula 2", 2021, "Director 2", "Comedia", "Sinopsis 2");
    }

    @Test
    public void testGetAllPeliculas() throws Exception {
        // Configurar el comportamiento del servicio mock
        when(peliculaService.getAllPeliculas()).thenReturn(Arrays.asList(pelicula1, pelicula2));

        // Realizar la petición GET y verificar el resultado
        mockMvc.perform(get("/api/peliculas"))
                .andExpect(status().isOk()) // Verificar que la respuesta tiene un status 200 OK
                .andExpect(jsonPath("$[0].titulo").value("Pelicula 1")) // Verificar que el primer elemento tiene el título esperado
                .andExpect(jsonPath("$[1].titulo").value("Pelicula 2")); // Verificar que el segundo elemento tiene el título esperado
    }

    @Test
    public void testGetPeliculaById() throws Exception {
        // Configurar el comportamiento del servicio mock
        when(peliculaService.getPeliculaById(1L)).thenReturn(Optional.of(pelicula1));

        // Realizar la petición GET y verificar el resultado
        mockMvc.perform(get("/api/peliculas/1"))
                .andExpect(status().isOk()) // Verificar que la respuesta tiene un status 200 OK
                .andExpect(jsonPath("$.titulo").value("Pelicula 1")) // Verificar que el título de la película es el esperado
                .andExpect(jsonPath("$.anio").value(2020)); // Verificar que el año de la película es el esperado
    }

}