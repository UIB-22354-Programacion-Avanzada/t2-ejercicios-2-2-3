package es.uib.prgava.tema2.ejercicios;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 2.2.1. El conjunto: «¿lo he visto ya?» en tiempo constante esperado.
 *
 * <p>Las tres preguntas que contesta esta clase se podrían contestar con una lista y
 * {@code contains}, y costarían un recorrido cada vez. Con un conjunto cuestan una consulta.
 */
public final class PalabrasUnicas {

    private PalabrasUnicas() { }

    /**
     * Cuántas palabras distintas hay en la lista.
     *
     * <p>La comparación es exacta, sin normalizar: {@code "Sol"} y {@code "sol"} son dos palabras.
     *
     * @throws NullPointerException si {@code palabras} es {@code null}
     */
    public static int cuantasDistintas(List<String> palabras) {
        // TODO 2.2.1: con un HashSet es una linea.
        throw new UnsupportedOperationException("TODO 2.2.1: PalabrasUnicas.cuantasDistintas");
    }

    /**
     * Las palabras distintas, en el orden en que aparecen por primera vez.
     *
     * @return una lista nueva e inmutable
     * @throws NullPointerException si {@code palabras} es {@code null}
     */
    public static List<String> distintasEnOrdenDeAparicion(List<String> palabras) {
        // TODO 2.2.1: un HashSet no promete orden; el que lo promete es LinkedHashSet.
        throw new UnsupportedOperationException("TODO 2.2.1: PalabrasUnicas.distintasEnOrdenDeAparicion");
    }

    /**
     * Las palabras de {@code minimo} letras o más, en el mismo orden y con las repeticiones.
     *
     * <p>Es un filtro, no una deduplicación: si una palabra larga aparece tres veces, sale tres
     * veces.
     *
     * @return una lista nueva e inmutable
     * @throws IllegalArgumentException si {@code minimo} es menor que 1
     * @throws NullPointerException si {@code palabras} es {@code null}
     */
    public static List<String> sinLasCortas(List<String> palabras, int minimo) {
        // TODO 2.2.1: copia la lista y quita las cortas de una pasada. Antes, ejecuta
        // sinLasCortasRoto y explica en un comentario que pasa y por que.
        throw new UnsupportedOperationException("TODO 2.2.1: PalabrasUnicas.sinLasCortas");
    }

    /**
     * La versión que no funciona, para ejecutarla antes de arreglar nada.
     *
     * <p>No la modifiques: es parte del enunciado. Quita elementos de la lista mientras la
     * recorre, que es exactamente lo que el iterador no permite.
     */
    public static List<String> sinLasCortasRoto(List<String> palabras, int minimo) {
        var copia = new ArrayList<>(palabras);
        for (String palabra : copia) {
            if (palabra.length() < minimo) {
                copia.remove(palabra);
            }
        }
        return copia;
    }
}
