package es.uib.prgava.tema2.ejercicios;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.3.2. */
class ConsumirPorElPrincipioTest {

    @Test
    void losDosDevuelvenLoMismoYEnElMismoOrden() {
        assertEquals(List.of(1, 2, 3, 4, 5), ConsumirPorElPrincipio.conLista(5));
        assertEquals(List.of(1, 2, 3, 4, 5), ConsumirPorElPrincipio.conDeque(5));
        for (int n : new int[] {1, 2, 17, 1_000}) {
            assertEquals(ConsumirPorElPrincipio.conLista(n), ConsumirPorElPrincipio.conDeque(n),
                    "con n = " + n);
        }
    }

    @Test
    void losElementosSonLosNumerosDeUnoAN() {
        var esperados = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            esperados.add(i);
        }
        assertEquals(esperados, ConsumirPorElPrincipio.conDeque(100));
    }

    /** Esta es la del ejercicio: el contador tiene que ser exactamente n(n-1)/2. */
    @Test
    void consumirConRemoveCeroCuestaNPorNMenosUnoEntreDos() {
        for (int n : new int[] {1, 2, 5, 1_000, 10_000}) {
            ConsumirPorElPrincipio.conLista(n);
            assertEquals((long) n * (n - 1) / 2, ConsumirPorElPrincipio.ultimosDesplazamientos(),
                    "con n = " + n);
        }
    }

    @Test
    void laListaDevueltaEsInmutable() {
        var consumidos = ConsumirPorElPrincipio.conDeque(3);
        assertThrows(UnsupportedOperationException.class, () -> consumidos.add(99));
    }

    @Test
    void unTamanoInvalidoEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> ConsumirPorElPrincipio.conLista(0));
        assertThrows(IllegalArgumentException.class, () -> ConsumirPorElPrincipio.conDeque(0));
        assertThrows(IllegalArgumentException.class, () -> ConsumirPorElPrincipio.conLista(-3));
    }
}
