package es.uib.prgava.tema2.ejercicios;

import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Programa de prueba del ejercicio 2.2.1.
 *
 * <p>Lo que hay que ver aquí es lo último: la versión rota del paso 3 no devuelve un resultado
 * equivocado, <strong>revienta</strong>, y el nombre de la excepción no menciona en ningún momento
 * lo que de verdad ha pasado.
 *
 * <p>Hasta que el ejercicio esté resuelto, los tres primeros bloques terminan con la
 * {@code UnsupportedOperationException} del {@code TODO}: es lo esperado.
 */
public final class DemoPalabrasUnicas {

    private DemoPalabrasUnicas() { }

    private static final List<String> PALABRAS = List.of("sol", "luna", "sol", "mar", "luna", "sol");

    public static void main(String[] args) {
        System.out.println("--- la lista de partida");
        System.out.println("   " + PALABRAS);

        System.out.println();
        System.out.println("--- cuantas distintas, y cuales");
        System.out.println("   distintas              = " + PalabrasUnicas.cuantasDistintas(PALABRAS));
        System.out.println("   en orden de aparicion  = " + PalabrasUnicas.distintasEnOrdenDeAparicion(PALABRAS));
        System.out.println("   y con mayusculas: " + List.of("Sol", "sol") + " tiene "
                + PalabrasUnicas.cuantasDistintas(List.of("Sol", "sol")) + " distintas");

        System.out.println();
        System.out.println("--- el filtro conserva las repeticiones");
        System.out.println("   de 4 letras o mas = " + PalabrasUnicas.sinLasCortas(PALABRAS, 4));
        System.out.println("   de 1 letra o mas  = " + PalabrasUnicas.sinLasCortas(PALABRAS, 1));

        System.out.println();
        System.out.println("--- y la version rota, que es el ejercicio");
        try {
            System.out.println("   devolvio " + PalabrasUnicas.sinLasCortasRoto(PALABRAS, 4));
            System.out.println("   ...no ha fallado, y eso es todavia peor: mira el Error Frecuente");
        } catch (ConcurrentModificationException e) {
            System.out.println("   lanza " + e.getClass().getSimpleName() + ", y sin mensaje ninguno");
            System.out.println("   El nombre habla de concurrencia y aqui hay un solo hilo: lo que");
            System.out.println("   ha pasado es que el iterador detecto una modificacion que no hizo el.");
        }
    }
}