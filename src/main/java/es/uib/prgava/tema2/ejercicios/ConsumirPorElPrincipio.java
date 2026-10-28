package es.uib.prgava.tema2.ejercicios;

import java.util.List;

/**
 * Ejercicio 2.3.2. Consumir por el principio: el extremo equivocado de un {@code ArrayList}.
 *
 * <p>Los dos métodos hacen lo mismo y devuelven lo mismo. Lo que cambia es el trabajo: con
 * {@code remove(0)} cada extracción desplaza todo lo que queda, y con {@code pollFirst} sobre un
 * array circular no se desplaza nada.
 */
public final class ConsumirPorElPrincipio {

    private ConsumirPorElPrincipio() { }

    // TODO 2.3.2: declara aqui el atributo de clase donde se guardan los desplazamientos.

    /**
     * Construye los números de 1 a {@code n} en un {@code ArrayList} y los consume con
     * {@code remove(0)}, contando los desplazamientos.
     *
     * @return lo consumido, en el orden en que salió; lista nueva e inmutable
     * @throws IllegalArgumentException si {@code n} es menor que 1
     */
    public static List<Integer> conLista(int n) {
        // TODO 2.3.2: antes de cada remove(0), suma al contador cuantos elementos va a desplazar.
        throw new UnsupportedOperationException("TODO 2.3.2: ConsumirPorElPrincipio.conLista");
    }

    /**
     * Lo mismo con un {@code ArrayDeque} declarado como {@code Deque} y consumido con
     * {@code pollFirst}.
     *
     * @return lo consumido, en el orden en que salió; lista nueva e inmutable
     * @throws IllegalArgumentException si {@code n} es menor que 1
     */
    public static List<Integer> conDeque(int n) {
        // TODO 2.3.2: pollFirst devuelve null al vaciarse, asi que el bucle natural es
        // while ((siguiente = cola.pollFirst()) != null). Aqui no hay nada que contar.
        throw new UnsupportedOperationException("TODO 2.3.2: ConsumirPorElPrincipio.conDeque");
    }

    /** Desplazamientos que costó la última llamada a {@link #conLista(int)}. */
    public static long ultimosDesplazamientos() {
        // TODO 2.3.2
        throw new UnsupportedOperationException("TODO 2.3.2: ConsumirPorElPrincipio.ultimosDesplazamientos");
    }
}
