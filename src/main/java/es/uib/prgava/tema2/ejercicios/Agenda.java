package es.uib.prgava.tema2.ejercicios;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * Ejercicio 2.2.3. El árbol de búsqueda: una agenda de un día.
 *
 * <p>Las tres preguntas de esta clase —el intervalo, la siguiente cita, el recorrido en orden— son
 * las que un árbol responde y una tabla <em>hash</em> no, porque calcular la cubeta destruye el
 * orden. Por dentro, un {@code TreeMap<LocalTime, String>}.
 */
public final class Agenda {

    /** Una cita: la hora y lo que hay a esa hora. */
    public record Cita(LocalTime hora, String texto) { }

    // TODO 2.2.3: declara aqui el TreeMap. Conviene declararlo como NavigableMap, que es la
    // interfaz que ofrece subMap y higherEntry.

    /**
     * Añade una cita. Si ya había una a esa hora, la sustituye.
     *
     * @throws IllegalArgumentException si el texto es {@code null} o está en blanco
     * @throws NullPointerException si la hora es {@code null}
     */
    public void anadir(LocalTime hora, String texto) {
        // TODO 2.2.3
        throw new UnsupportedOperationException("TODO 2.2.3: Agenda.anadir");
    }

    /**
     * Las citas desde {@code desde} incluido hasta {@code hasta} excluido, en orden de hora.
     *
     * @return una lista nueva e inmutable
     * @throws IllegalArgumentException si {@code hasta} es anterior a {@code desde}
     */
    public List<Cita> entre(LocalTime desde, LocalTime hasta) {
        // TODO 2.2.3: subMap(desde, true, hasta, false).
        throw new UnsupportedOperationException("TODO 2.2.3: Agenda.entre");
    }

    /**
     * La primera cita estrictamente posterior a la hora dada, o vacío si no hay ninguna.
     *
     * <p>Estrictamente posterior: una cita a esa misma hora no cuenta.
     */
    public Optional<Cita> siguienteDespuesDe(LocalTime hora) {
        // TODO 2.2.3: higherEntry, no ceilingEntry.
        throw new UnsupportedOperationException("TODO 2.2.3: Agenda.siguienteDespuesDe");
    }

    /** Todas las citas, en orden de hora. */
    public List<Cita> todas() {
        // TODO 2.2.3: el orden del recorrido del arbol ya es el orden de las horas.
        throw new UnsupportedOperationException("TODO 2.2.3: Agenda.todas");
    }

    // TODO 2.2.3: escribe aqui, en comentario, que metodo tendrias que escribir para contestar
    // entre() si la agenda fuera un HashMap<LocalTime, String>, y cuanto costaria.
}
