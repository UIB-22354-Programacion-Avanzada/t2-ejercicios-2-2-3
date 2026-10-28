package es.uib.prgava.tema2.ejercicios;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.2.2. */
class HistorialDeNavegacionTest {

    @Test
    void unHistorialNuevoEstaVacio() {
        var historial = new HistorialDeNavegacion();
        assertEquals(0, historial.tamano());
        assertEquals(Optional.empty(), historial.actual());
        assertEquals(Optional.empty(), historial.atras());
    }

    @Test
    void laUltimaVisitadaEsLaActual() {
        var historial = new HistorialDeNavegacion();
        historial.visitar("uib.es");
        assertEquals(Optional.of("uib.es"), historial.actual());
        historial.visitar("uib.es/eps");
        assertEquals(Optional.of("uib.es/eps"), historial.actual());
        assertEquals(2, historial.tamano());
    }

    @Test
    void atrasRecuperaLasAnterioresEnOrdenInverso() {
        var historial = new HistorialDeNavegacion();
        historial.visitar("uib.es");
        historial.visitar("uib.es/eps");
        historial.visitar("uib.es/eps/22354");

        assertEquals(Optional.of("uib.es/eps"), historial.atras());
        assertEquals(Optional.of("uib.es/eps"), historial.actual());
        assertEquals(2, historial.tamano());

        assertEquals(Optional.of("uib.es"), historial.atras());
        assertEquals(1, historial.tamano());
    }

    @Test
    void sobreUnaSolaPaginaAtrasNoBorraNada() {
        var historial = new HistorialDeNavegacion();
        historial.visitar("uib.es");
        assertEquals(Optional.empty(), historial.atras());
        assertEquals(Optional.of("uib.es"), historial.actual());
        assertEquals(1, historial.tamano(), "atras no puede dejar el historial vacio");
    }

    @Test
    void unaUrlEnBlancoEsRechazada() {
        var historial = new HistorialDeNavegacion();
        assertThrows(IllegalArgumentException.class, () -> historial.visitar(null));
        assertThrows(IllegalArgumentException.class, () -> historial.visitar(""));
        assertThrows(IllegalArgumentException.class, () -> historial.visitar("   "));
    }
}
