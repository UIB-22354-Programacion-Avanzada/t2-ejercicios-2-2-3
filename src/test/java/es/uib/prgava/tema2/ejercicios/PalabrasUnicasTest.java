package es.uib.prgava.tema2.ejercicios;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.2.1. */
class PalabrasUnicasTest {

    private static final List<String> PALABRAS = List.of("sol", "luna", "sol", "mar", "luna", "sol");

    @Test
    void cuentaLasDistintasSinNormalizar() {
        assertEquals(3, PalabrasUnicas.cuantasDistintas(PALABRAS));
        assertEquals(2, PalabrasUnicas.cuantasDistintas(List.of("Sol", "sol")));
        assertEquals(0, PalabrasUnicas.cuantasDistintas(List.of()));
        assertEquals(1, PalabrasUnicas.cuantasDistintas(List.of("sol", "sol", "sol")));
    }

    @Test
    void lasDistintasSalenEnOrdenDeAparicion() {
        assertEquals(List.of("sol", "luna", "mar"), PalabrasUnicas.distintasEnOrdenDeAparicion(PALABRAS));
        assertEquals(List.of(), PalabrasUnicas.distintasEnOrdenDeAparicion(List.of()));
    }

    @Test
    void sinLasCortasFiltraYConservaLasRepeticiones() {
        assertEquals(List.of("luna", "luna"), PalabrasUnicas.sinLasCortas(PALABRAS, 4));
        assertEquals(PALABRAS, PalabrasUnicas.sinLasCortas(PALABRAS, 1));
        assertEquals(List.of(), PalabrasUnicas.sinLasCortas(PALABRAS, 9));
    }

    @Test
    void laEntradaNoSeModificaYLasSalidasSonInmutables() {
        var entrada = new ArrayList<>(PALABRAS);
        var distintas = PalabrasUnicas.distintasEnOrdenDeAparicion(entrada);
        var filtradas = PalabrasUnicas.sinLasCortas(entrada, 4);
        assertEquals(PALABRAS, entrada, "la lista que llega no se toca");
        assertThrows(UnsupportedOperationException.class, () -> distintas.add("nueva"));
        assertThrows(UnsupportedOperationException.class, () -> filtradas.add("nueva"));
    }

    @Test
    void losArgumentosInvalidosSeRechazan() {
        assertThrows(NullPointerException.class, () -> PalabrasUnicas.cuantasDistintas(null));
        assertThrows(NullPointerException.class, () -> PalabrasUnicas.distintasEnOrdenDeAparicion(null));
        assertThrows(IllegalArgumentException.class, () -> PalabrasUnicas.sinLasCortas(PALABRAS, 0));
    }

    /** La versión del enunciado no funciona, y esta prueba lo deja escrito. */
    @Test
    void laVersionRotaFalla() {
        assertThrows(ConcurrentModificationException.class, () -> PalabrasUnicas.sinLasCortasRoto(PALABRAS, 4));
    }

    /** Con diez mil palabras: instantáneo con un conjunto, eterno preguntándole a una lista. */
    @Test
    void conDiezMilPalabras() {
        var muchas = new ArrayList<String>();
        for (int i = 0; i < 10_000; i++) {
            muchas.add("palabra" + (i % 7_000));
        }
        assertEquals(7_000, PalabrasUnicas.cuantasDistintas(muchas));
        assertEquals(7_000, PalabrasUnicas.distintasEnOrdenDeAparicion(muchas).size());
        assertEquals("palabra0", PalabrasUnicas.distintasEnOrdenDeAparicion(muchas).get(0));
    }
}
