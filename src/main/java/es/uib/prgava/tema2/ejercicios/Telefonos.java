package es.uib.prgava.tema2.ejercicios;

import java.util.List;
import java.util.Optional;

/**
 * Ejercicio 2.3.3. Tabla o árbol: una guía de teléfonos con dos preguntas.
 *
 * <p>«El teléfono de este nombre» la contestan las dos estructuras; «los nombres que empiezan por
 * este prefijo», solo el árbol. Por eso la guía es un {@code TreeMap}, y el precio es que la
 * búsqueda exacta pasa de tiempo constante esperado a logarítmico garantizado.
 */
public final class Telefonos {

    // TODO 2.3.3: declara aqui el TreeMap. Conviene declararlo como NavigableMap, que es la
    // interfaz que ofrece tailMap.

    /**
     * Añade o sustituye un número.
     *
     * @throws IllegalArgumentException si el nombre o el teléfono son {@code null} o están en
     *         blanco
     */
    public void anadir(String nombre, String telefono) {
        // TODO 2.3.3
        throw new UnsupportedOperationException("TODO 2.3.3: Telefonos.anadir");
    }

    /** El teléfono de ese nombre exacto, o vacío si no está en la guía. */
    public Optional<String> telefonoDe(String nombre) {
        // TODO 2.3.3
        throw new UnsupportedOperationException("TODO 2.3.3: Telefonos.telefonoDe");
    }

    /**
     * Los nombres que empiezan por {@code prefijo}, en orden alfabético.
     *
     * <p>El prefijo vacío devuelve todos los nombres, porque toda cadena empieza por la cadena
     * vacía.
     *
     * @return una lista nueva e inmutable
     */
    public List<String> nombresQueEmpiezanPor(String prefijo) {
        // TODO 2.3.3: tailMap(prefijo, true) da los nombres desde el prefijo en adelante, y como
        // vienen en orden basta recorrer hasta el primero que ya no empieza por el prefijo y
        // parar. No compares con todos.
        throw new UnsupportedOperationException("TODO 2.3.3: Telefonos.nombresQueEmpiezanPor");
    }

    /** Cuántos nombres hay en la guía. */
    public int tamano() {
        // TODO 2.3.3
        throw new UnsupportedOperationException("TODO 2.3.3: Telefonos.tamano");
    }

    // TODO 2.3.3: escribe aqui, en comentario, cual de las dos preguntas podria contestar un
    // HashMap, que costaria la otra con un HashMap, y por que el orden de las claves del arbol es
    // el indice que hace barata la segunda.
}
