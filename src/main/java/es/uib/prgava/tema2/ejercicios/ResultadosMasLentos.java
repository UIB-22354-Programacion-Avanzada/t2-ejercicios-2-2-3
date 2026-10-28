package es.uib.prgava.tema2.ejercicios;

import java.util.List;

import es.uib.prgava.tema1.monitor.Resultado;

/**
 * Ejercicio 2.2.4. El montículo: los {@code k} resultados más lentos del monitor.
 *
 * <p>Una cola de prioridad saca siempre el mínimo según su comparador, así que para quedarse con
 * los mayores el comparador va invertido. Y los elementos hay que <strong>sacarlos</strong>:
 * recorrer la cola no los da en orden.
 */
public final class ResultadosMasLentos {

    private ResultadosMasLentos() { }

    /**
     * Los {@code k} resultados de mayor latencia, de mayor a menor.
     *
     * <p>Si hay menos de {@code k} resultados, devuelve todos los que haya.
     *
     * @return una lista nueva e inmutable
     * @throws IllegalArgumentException si {@code k} es menor que 1
     * @throws NullPointerException si {@code resultados} es {@code null}
     */
    public static List<Resultado> masLentos(List<Resultado> resultados, int k) {
        // TODO 2.2.4: una PriorityQueue con Comparator.comparing(Resultado::latencia).reversed(),
        // addAll, y poll k veces. Duration es Comparable, no hace falta pasar a milisegundos.
        throw new UnsupportedOperationException("TODO 2.2.4: ResultadosMasLentos.masLentos");
    }
}
