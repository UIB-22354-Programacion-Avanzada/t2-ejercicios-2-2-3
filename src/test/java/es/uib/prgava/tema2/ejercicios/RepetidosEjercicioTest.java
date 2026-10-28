package es.uib.prgava.tema2.ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Ejercicio 2.3.1. */
class RepetidosEjercicioTest {

    /** Los mismos arrays que usa DemoConteos: n enteros distintos. */
    private static int[] sinRepetidos(int n) {
        var datos = new int[n];
        for (int i = 0; i < n; i++) {
            datos[i] = i;
        }
        return datos;
    }

    @Test
    void detectaElRepetidoYSuAusencia() {
        assertFalse(RepetidosEjercicio.hayRepetido(new int[] {10, 20, 30}));
        assertTrue(RepetidosEjercicio.hayRepetido(new int[] {10, 20, 10}));
        assertTrue(RepetidosEjercicio.hayRepetido(new int[] {7, 7}));
    }

    @Test
    void losCasosDegenerados() {
        assertFalse(RepetidosEjercicio.hayRepetido(new int[] {}));
        assertEquals(0, RepetidosEjercicio.ultimasOperaciones());
        assertFalse(RepetidosEjercicio.hayRepetido(new int[] {42}));
        assertEquals(1, RepetidosEjercicio.ultimasOperaciones());
    }

    @Test
    void sinRepetidoExaminaTodoElArray() {
        for (int n : new int[] {3, 100, 2_000}) {
            RepetidosEjercicio.hayRepetido(sinRepetidos(n));
            assertEquals(n, RepetidosEjercicio.ultimasOperaciones(), "con n = " + n);
        }
    }

    @Test
    void conRepetidoParaEnCuantoLoEncuentra() {
        var enMedio = sinRepetidos(2_000);
        enMedio[1_000] = enMedio[999];
        assertTrue(RepetidosEjercicio.hayRepetido(enMedio));
        assertEquals(1_001, RepetidosEjercicio.ultimasOperaciones(), "el repetido esta en la posicion 1000");

        var alPrincipio = sinRepetidos(2_000);
        alPrincipio[1] = alPrincipio[0];
        assertTrue(RepetidosEjercicio.hayRepetido(alPrincipio));
        assertEquals(2, RepetidosEjercicio.ultimasOperaciones(), "el repetido esta en la posicion 1");
    }

    /** Cien mil elementos: con un conjunto es inmediato, comparando pares no acabaria. */
    @Test
    void conCienMilElementos() {
        assertFalse(RepetidosEjercicio.hayRepetido(sinRepetidos(100_000)));
        assertEquals(100_000, RepetidosEjercicio.ultimasOperaciones());
    }

    @Test
    void unArrayNuloEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> RepetidosEjercicio.hayRepetido(null));
    }
}
