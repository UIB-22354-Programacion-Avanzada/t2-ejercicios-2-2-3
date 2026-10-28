package es.uib.prgava.tema2.ejercicios;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.3.3. */
class TelefonosTest {

    private static Telefonos deEjemplo() {
        var guia = new Telefonos();
        guia.anadir("Marcos", "971 10 10 10");
        guia.anadir("Maria", "971 20 20 20");
        guia.anadir("Marta", "971 30 30 30");
        guia.anadir("Pau", "971 40 40 40");
        guia.anadir("Laia", "971 50 50 50");
        return guia;
    }

    @Test
    void laBusquedaExacta() {
        var guia = deEjemplo();
        assertEquals(Optional.of("971 20 20 20"), guia.telefonoDe("Maria"));
        assertEquals(Optional.of("971 40 40 40"), guia.telefonoDe("Pau"));
        assertEquals(Optional.empty(), guia.telefonoDe("Joan"));
        assertEquals(Optional.empty(), guia.telefonoDe("maria"), "la busqueda es exacta");
        assertEquals(5, guia.tamano());
    }

    @Test
    void elPrefijoDaLosNombresEnOrdenAlfabetico() {
        assertEquals(List.of("Marcos", "Maria", "Marta"), deEjemplo().nombresQueEmpiezanPor("Mar"));
        assertEquals(List.of("Marcos"), deEjemplo().nombresQueEmpiezanPor("Marc"));
    }

    @Test
    void unPrefijoSinNombresDaLaListaVacia() {
        assertEquals(List.of(), deEjemplo().nombresQueEmpiezanPor("Z"));
        assertEquals(List.of(), deEjemplo().nombresQueEmpiezanPor("Mz"));
    }

    @Test
    void elPrefijoVacioDaTodosLosNombres() {
        assertEquals(List.of("Laia", "Marcos", "Maria", "Marta", "Pau"), deEjemplo().nombresQueEmpiezanPor(""));
    }

    @Test
    void unPrefijoQueEsUnNombreCompletoSeIncluye() {
        assertEquals(List.of("Maria"), deEjemplo().nombresQueEmpiezanPor("Maria"));
        assertEquals(List.of("Pau"), deEjemplo().nombresQueEmpiezanPor("Pau"));
    }

    @Test
    void anadirDosVecesElMismoNombreSustituye() {
        var guia = deEjemplo();
        guia.anadir("Maria", "971 99 99 99");
        assertEquals(Optional.of("971 99 99 99"), guia.telefonoDe("Maria"));
        assertEquals(5, guia.tamano());
    }

    @Test
    void conMilNombres() {
        var guia = new Telefonos();
        for (int i = 0; i < 1_000; i++) {
            guia.anadir(String.format("nombre%04d", i), "971 00 00 " + i);
        }
        assertEquals(1_000, guia.tamano());
        assertEquals(10, guia.nombresQueEmpiezanPor("nombre000").size());
        assertEquals(List.of("nombre0007"), guia.nombresQueEmpiezanPor("nombre0007"));
        assertEquals(List.of(), guia.nombresQueEmpiezanPor("zzz"));
    }

    @Test
    void laListaDevueltaEsInmutableYLosArgumentosSeValidan() {
        var guia = deEjemplo();
        var nombres = guia.nombresQueEmpiezanPor("Mar");
        assertThrows(UnsupportedOperationException.class, () -> nombres.add("Mario"));
        assertThrows(IllegalArgumentException.class, () -> guia.anadir("", "971"));
        assertThrows(IllegalArgumentException.class, () -> guia.anadir("Joan", "  "));
    }
}
