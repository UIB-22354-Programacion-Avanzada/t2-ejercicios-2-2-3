package es.uib.prgava.tema2.ejercicios;

import java.util.Optional;

/**
 * Ejercicio 2.2.2. La pila: el botón «atrás» de un navegador.
 *
 * <p>La última página visitada es la primera que se recupera. Por dentro, un {@code ArrayDeque}
 * usado como pila; nunca {@code java.util.Stack}.
 */
public final class HistorialDeNavegacion {

    // TODO 2.2.2: declara aqui el Deque<String> donde se apilan las paginas.

    /**
     * Apila una página y la convierte en la actual.
     *
     * @throws IllegalArgumentException si la {@code url} es {@code null} o está en blanco
     */
    public void visitar(String url) {
        // TODO 2.2.2
        throw new UnsupportedOperationException("TODO 2.2.2: HistorialDeNavegacion.visitar");
    }

    /** La página en la que estás, sin quitarla, o vacío si no has visitado ninguna. */
    public Optional<String> actual() {
        // TODO 2.2.2
        throw new UnsupportedOperationException("TODO 2.2.2: HistorialDeNavegacion.actual");
    }

    /**
     * Retrocede: descarta la página actual y devuelve la anterior, que pasa a ser la actual.
     *
     * <p>Si solo hay una página, o ninguna, no hay a dónde retroceder: no cambia nada y devuelve
     * vacío.
     */
    public Optional<String> atras() {
        // TODO 2.2.2
        throw new UnsupportedOperationException("TODO 2.2.2: HistorialDeNavegacion.atras");
    }

    /** Cuántas páginas hay apiladas. */
    public int tamano() {
        // TODO 2.2.2
        throw new UnsupportedOperationException("TODO 2.2.2: HistorialDeNavegacion.tamano");
    }

    // TODO 2.2.2: escribe aqui, en dos lineas de comentario, por que la pareja de metodos
    // correcta es la que devuelve valor especial y no la que lanza excepcion.
}
