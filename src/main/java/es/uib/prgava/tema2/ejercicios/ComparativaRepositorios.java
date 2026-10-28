package es.uib.prgava.tema2.ejercicios;

/**
 * Ejercicio 2.3.4. Las dos versiones del repositorio, comparadas contando.
 *
 * <p>Cada método reproduce una ejecución completa del monitor —en cada ronda y para cada servicio,
 * guardar un resultado y después pedir el historial de ese servicio— y devuelve cuántos resultados
 * se han examinado al responder los historiales. La misma unidad en los dos, que es lo que permite
 * dividir un número por el otro.
 *
 * <p>No hacen falta el {@code Monitor} ni las clases del repositorio: con una {@code List} en un
 * caso y un {@code HashMap} en el otro, dentro del propio método, es suficiente. Los servicios se
 * crean con {@code new ServicioTcp("s" + i, 9000 + i)}.
 */
public final class ComparativaRepositorios {

    private ComparativaRepositorios() { }

    /**
     * Resultados examinados por la versión del Tema 1, que guarda todo en una lista y recorre
     * los {@code N} resultados en cada consulta.
     *
     * @throws IllegalArgumentException si {@code rondas} o {@code numServicios} son menores que 1
     */
    public static long examinadosConListaUnica(int rondas, int numServicios) {
        // TODO 2.3.4
        throw new UnsupportedOperationException("TODO 2.3.4: ComparativaRepositorios.examinadosConListaUnica");
    }

    /**
     * Resultados examinados por la versión con índice por servicio, que solo copia los del
     * servicio preguntado.
     *
     * @throws IllegalArgumentException si {@code rondas} o {@code numServicios} son menores que 1
     */
    public static long examinadosConIndice(int rondas, int numServicios) {
        // TODO 2.3.4: un HashMap<Servicio, List<Resultado>>; te sirve computeIfAbsent.
        throw new UnsupportedOperationException("TODO 2.3.4: ComparativaRepositorios.examinadosConIndice");
    }

    // TODO 2.3.4: escribe aqui, en comentario, las dos formulas en funcion de r, s y N = r*s, y la
    // conclusion: que operacion dominaba, cuanto mejora el indice y por que sigue siendo
    // cuadratico en las rondas.
}
