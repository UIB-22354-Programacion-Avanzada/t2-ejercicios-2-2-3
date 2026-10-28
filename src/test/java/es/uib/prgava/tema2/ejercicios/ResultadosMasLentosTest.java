package es.uib.prgava.tema2.ejercicios;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import es.uib.prgava.tema1.monitor.Estado;
import es.uib.prgava.tema1.monitor.Resultado;
import es.uib.prgava.tema1.monitor.Servicio;
import es.uib.prgava.tema1.monitor.ServicioTcp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.2.4. */
class ResultadosMasLentosTest {

    private static final Servicio SERVICIO = new ServicioTcp("web", 80);
    private static final Instant I0 = Instant.parse("2026-01-01T00:00:00Z");

    private static List<Resultado> con(int... latenciasEnMilis) {
        var resultados = new ArrayList<Resultado>();
        for (int i = 0; i < latenciasEnMilis.length; i++) {
            resultados.add(new Resultado(SERVICIO, I0.plusSeconds(i), Estado.ACTIVO,
                    Duration.ofMillis(latenciasEnMilis[i])));
        }
        return List.copyOf(resultados);
    }

    private static List<Long> milis(List<Resultado> resultados) {
        var lista = new ArrayList<Long>();
        for (Resultado r : resultados) {
            lista.add(r.latencia().toMillis());
        }
        return lista;
    }

    @Test
    void losTresMasLentosDeCinco() {
        assertEquals(List.of(900L, 650L, 120L), milis(ResultadosMasLentos.masLentos(con(40, 900, 120, 650, 30), 3)));
    }

    @Test
    void siKEsMayorQueLoQueHayDevuelveTodos() {
        assertEquals(List.of(900L, 650L, 120L, 40L, 30L), milis(ResultadosMasLentos.masLentos(con(40, 900, 120, 650, 30), 99)));
        assertEquals(5, ResultadosMasLentos.masLentos(con(40, 900, 120, 650, 30), 5).size());
    }

    @Test
    void conUnoYConLaListaVacia() {
        assertEquals(List.of(900L), milis(ResultadosMasLentos.masLentos(con(40, 900, 120), 1)));
        assertEquals(List.of(), ResultadosMasLentos.masLentos(List.of(), 3));
    }

    /**
     * Quince resultados colocados a propósito: el array interno del montículo no queda ordenado,
     * así que esta prueba falla si se recorre la cola en lugar de vaciarla con poll.
     */
    @Test
    void hayQueSacarLosElementos() {
        var resultados = con(40, 900, 120, 650, 30, 70, 880, 15, 500, 210, 95, 760, 330, 55, 410);
        assertEquals(List.of(900L, 880L, 760L), milis(ResultadosMasLentos.masLentos(resultados, 3)));
        assertEquals(List.of(900L, 880L, 760L, 650L, 500L), milis(ResultadosMasLentos.masLentos(resultados, 5)));
    }

    @Test
    void laListaDevueltaEsInmutable() {
        var peores = ResultadosMasLentos.masLentos(con(40, 900), 1);
        assertThrows(UnsupportedOperationException.class, () -> peores.add(null));
    }

    @Test
    void losArgumentosInvalidosSeRechazan() {
        assertThrows(IllegalArgumentException.class, () -> ResultadosMasLentos.masLentos(con(40), 0));
        assertThrows(IllegalArgumentException.class, () -> ResultadosMasLentos.masLentos(con(40), -2));
        assertThrows(NullPointerException.class, () -> ResultadosMasLentos.masLentos(null, 3));
    }
}
