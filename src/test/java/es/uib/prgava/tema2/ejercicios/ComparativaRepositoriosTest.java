package es.uib.prgava.tema2.ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Ejercicio 2.3.4. */
class ComparativaRepositoriosTest {

    /** N(N+1)/2 con N = rondas * servicios. */
    private static long formulaListaUnica(int rondas, int servicios) {
        long n = (long) rondas * servicios;
        return n * (n + 1) / 2;
    }

    /** s * r(r+1)/2. */
    private static long formulaIndice(int rondas, int servicios) {
        return (long) servicios * rondas * (rondas + 1) / 2;
    }

    @Test
    void laListaUnicaExaminaLaSumaDeUnoHastaN() {
        for (int[] caso : new int[][] {{1, 1}, {2, 3}, {5, 4}, {100, 20}}) {
            assertEquals(formulaListaUnica(caso[0], caso[1]),
                    ComparativaRepositorios.examinadosConListaUnica(caso[0], caso[1]),
                    "con " + caso[0] + " rondas y " + caso[1] + " servicios");
        }
    }

    @Test
    void elIndiceSoloExaminaLosDelServicioPreguntado() {
        for (int[] caso : new int[][] {{1, 1}, {2, 3}, {5, 4}, {100, 20}}) {
            assertEquals(formulaIndice(caso[0], caso[1]),
                    ComparativaRepositorios.examinadosConIndice(caso[0], caso[1]),
                    "con " + caso[0] + " rondas y " + caso[1] + " servicios");
        }
    }

    @Test
    void lasDosPrimerasFilasDeLaTabla() {
        assertEquals(2_001_000, ComparativaRepositorios.examinadosConListaUnica(100, 20));
        assertEquals(101_000, ComparativaRepositorios.examinadosConIndice(100, 20));
        assertEquals(8_002_000, ComparativaRepositorios.examinadosConListaUnica(200, 20));
        assertEquals(402_000, ComparativaRepositorios.examinadosConIndice(200, 20));
    }

    /** Lo que el indice elimina es el factor s, y se ve en el cociente. */
    @Test
    void elCocienteSeAcercaAlNumeroDeServicios() {
        for (int servicios : new int[] {5, 20}) {
            double cociente = (double) ComparativaRepositorios.examinadosConListaUnica(100, servicios)
                    / ComparativaRepositorios.examinadosConIndice(100, servicios);
            assertTrue(Math.abs(cociente - servicios) < 1,
                    "con " + servicios + " servicios el cociente fue " + cociente);
        }
    }

    /** Las dos siguen siendo cuadraticas en las rondas: al duplicarlas, por cuatro. */
    @Test
    void alDuplicarLasRondasLasDosSeMultiplicanPorCuatro() {
        double lista = (double) ComparativaRepositorios.examinadosConListaUnica(200, 10)
                / ComparativaRepositorios.examinadosConListaUnica(100, 10);
        double indice = (double) ComparativaRepositorios.examinadosConIndice(200, 10)
                / ComparativaRepositorios.examinadosConIndice(100, 10);
        assertEquals(4.0, lista, 0.05);
        assertEquals(4.0, indice, 0.05);
    }

    @Test
    void losArgumentosInvalidosSeRechazan() {
        assertThrows(IllegalArgumentException.class, () -> ComparativaRepositorios.examinadosConListaUnica(0, 3));
        assertThrows(IllegalArgumentException.class, () -> ComparativaRepositorios.examinadosConIndice(3, 0));
    }
}
