package es.uib.prgava.tema2.ejercicios;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.2.3. */
class AgendaTest {

    private static Agenda deEjemplo() {
        var agenda = new Agenda();
        agenda.anadir(LocalTime.of(16, 0), "reunion de departamento");
        agenda.anadir(LocalTime.of(9, 0), "claustro");
        agenda.anadir(LocalTime.of(12, 0), "tutoria");
        agenda.anadir(LocalTime.of(10, 30), "clase de 22354");
        return agenda;
    }

    @Test
    void todasSalenEnOrdenDeHoraAunqueSeAnadanDesordenadas() {
        var horas = deEjemplo().todas().stream().map(Agenda.Cita::hora).toList();
        assertEquals(List.of(LocalTime.of(9, 0), LocalTime.of(10, 30), LocalTime.of(12, 0), LocalTime.of(16, 0)), horas);
    }

    @Test
    void elIntervaloIncluyeElPrincipioYExcluyeElFinal() {
        var citas = deEjemplo().entre(LocalTime.of(9, 0), LocalTime.of(12, 0));
        assertEquals(2, citas.size());
        assertEquals(new Agenda.Cita(LocalTime.of(9, 0), "claustro"), citas.get(0));
        assertEquals(new Agenda.Cita(LocalTime.of(10, 30), "clase de 22354"), citas.get(1));
    }

    @Test
    void unIntervaloSinCitasEstaVacio() {
        assertEquals(List.of(), deEjemplo().entre(LocalTime.of(13, 0), LocalTime.of(15, 0)));
        assertEquals(List.of(), deEjemplo().entre(LocalTime.of(9, 0), LocalTime.of(9, 0)));
    }

    @Test
    void laSiguienteEsEstrictamentePosterior() {
        var agenda = deEjemplo();
        assertEquals(Optional.of(new Agenda.Cita(LocalTime.of(12, 0), "tutoria")),
                agenda.siguienteDespuesDe(LocalTime.of(10, 30)));
        assertEquals(Optional.of(new Agenda.Cita(LocalTime.of(9, 0), "claustro")),
                agenda.siguienteDespuesDe(LocalTime.of(0, 0)));
        assertEquals(Optional.empty(), agenda.siguienteDespuesDe(LocalTime.of(16, 0)));
    }

    @Test
    void anadirDosVecesALaMismaHoraSustituye() {
        var agenda = deEjemplo();
        agenda.anadir(LocalTime.of(12, 0), "tutoria con cita previa");
        assertEquals(4, agenda.todas().size());
        assertEquals(Optional.of(new Agenda.Cita(LocalTime.of(12, 0), "tutoria con cita previa")),
                agenda.siguienteDespuesDe(LocalTime.of(11, 0)));
    }

    @Test
    void laListaDevueltaEsInmutable() {
        var citas = deEjemplo().todas();
        assertThrows(UnsupportedOperationException.class,
                () -> citas.add(new Agenda.Cita(LocalTime.of(20, 0), "cena")));
    }

    @Test
    void losArgumentosInvalidosSeRechazan() {
        var agenda = new Agenda();
        assertThrows(IllegalArgumentException.class, () -> agenda.anadir(LocalTime.NOON, "  "));
        assertThrows(NullPointerException.class, () -> agenda.anadir(null, "algo"));
        assertThrows(IllegalArgumentException.class,
                () -> agenda.entre(LocalTime.of(12, 0), LocalTime.of(9, 0)));
    }
}
