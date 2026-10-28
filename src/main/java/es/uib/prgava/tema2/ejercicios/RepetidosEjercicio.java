package es.uib.prgava.tema2.ejercicios;

/**
 * Ejercicio 2.3.1. El mismo problema que {@code Conteos.hayRepetido}, con otro orden.
 *
 * <p>La versión del tema compara todos los pares y es cuadrática. Esta mete cada elemento en un
 * conjunto y pregunta si ya estaba, y es lineal: el cambio no está en el bucle, está en la
 * estructura.
 *
 * <p>Sigue el convenio de recuento de la página de ejercicios: anuncia con {@code Recuento} y deja
 * el número en {@link #ultimasOperaciones()}.
 */
public final class RepetidosEjercicio {

    private RepetidosEjercicio() { }

    // TODO 2.3.1: declara aqui el atributo de clase donde se guarda el ultimo recuento.

    /**
     * ¿Hay algún valor repetido en {@code datos}?
     *
     * @throws IllegalArgumentException si {@code datos} es {@code null}
     */
    public static boolean hayRepetido(int[] datos) {
        // TODO 2.3.1: un HashSet<Integer> y un recorrido. El valor que devuelve add() ya dice si
        // el elemento estaba, asi que no hace falta llamar antes a contains(). Cuenta las
        // iteraciones del cuerpo, anuncialas con
        // Recuento.anunciar("conConjunto", datos.length, operaciones, "n") y guardalas.
        throw new UnsupportedOperationException("TODO 2.3.1: RepetidosEjercicio.hayRepetido");
    }

    /** Iteraciones que ejecutó la última llamada a {@link #hayRepetido(int[])}. */
    public static long ultimasOperaciones() {
        // TODO 2.3.1
        throw new UnsupportedOperationException("TODO 2.3.1: RepetidosEjercicio.ultimasOperaciones");
    }

    // TODO 2.3.1: escribe aqui, en comentario, los seis numeros de la tabla —los tres arrays de
    // 2000 elementos de DemoConteos, con las dos versiones— y la conclusion.
}
