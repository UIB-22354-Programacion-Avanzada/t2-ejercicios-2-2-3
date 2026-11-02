package es.uib.prgava.tema2.ejercicios;

import java.util.Optional;

/**
 * Programa de prueba del ejercicio 2.2.2.
 *
 * <p>Simula una sesión de navegación y va imprimiendo el estado después de cada acción, que es lo
 * que una aserción no deja ver: cómo la pila crece por un extremo y se consume por el mismo.
 *
 * <p>El último bloque enseña una consecuencia del diseño que conviene entender: {@code atras}
 * <strong>destruye</strong> el historial que había por delante, de modo que esta clase no puede
 * tener un botón «adelante». Para eso hacen falta dos pilas.
 *
 * <p>Hasta que el ejercicio esté resuelto, el programa termina con la
 * {@code UnsupportedOperationException} del {@code TODO}: es lo esperado.
 */
public final class DemoHistorialDeNavegacion {

    private DemoHistorialDeNavegacion() { }

    private static final HistorialDeNavegacion HISTORIAL = new HistorialDeNavegacion();

    /** Visita una página y escribe el estado que queda. */
    private static void visitar(String url) {
        HISTORIAL.visitar(url);
        traza("visitar(\"" + url + "\")", Optional.of(url));
    }

    /** Retrocede y escribe lo que devolvió y el estado que queda. */
    private static void atras() {
        traza("atras()", HISTORIAL.atras());
    }

    private static void traza(String accion, Optional<String> devuelto) {
        System.out.printf("   %-28s devuelve %-22s actual = %-22s paginas = %d%n",
                accion,
                devuelto.orElse("(vacio)"),
                HISTORIAL.actual().orElse("(ninguna)"),
                HISTORIAL.tamano());
    }

    public static void main(String[] args) {
        System.out.println("--- un historial recien abierto");
        traza("(nada todavia)", Optional.empty());
        atras();
        System.out.println("   Retroceder sin haber visitado nada no es un error: devuelve vacio.");

        System.out.println();
        System.out.println("--- tres paginas, y vuelta atras hasta el principio");
        visitar("uib.es");
        visitar("uib.es/eps");
        visitar("uib.es/eps/22354");
        atras();
        atras();
        atras();
        System.out.println("   La ultima visitada es la primera que se recupera: eso es LIFO. Y el");
        System.out.println("   ultimo atras() devuelve vacio y no borra la pagina que queda: desde la");
        System.out.println("   primera no se puede retroceder.");

        System.out.println();
        System.out.println("--- lo que atras() se lleva por delante");
        visitar("uib.es/eps");
        visitar("uib.es/eps/22354");
        atras();
        visitar("uib.es/biblioteca");
        System.out.println("   La pagina 22354 ha desaparecido del historial, asi que no hay forma de");
        System.out.println("   volver a ella: una sola pila no puede ofrecer un boton de adelante.");
    }
}