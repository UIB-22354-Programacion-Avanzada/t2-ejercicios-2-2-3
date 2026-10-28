# t2-ejercicios-2-2-3 — Tema 2, bloques 2.2 y 2.3: estructuras de datos y cómo elegirlas

Esqueleto de los ejercicios **2.2.x** y **2.3.x** de *Programación Avanzada (22354)*, Grado en
Ingeniería Telemática, UIB-EPS. Los enunciados están en la
[página de ejercicios del tema](https://uib-22354-programacion-avanzada.github.io/website/es/ejercicios/tema2.html);
aquí tienes el código sobre el que trabajar.

Es un proyecto **Maven** para **Java 25** con pruebas en **JUnit 5**, preparado para **GitHub
Codespaces**. El esqueleto **compila desde el primer momento**, pero las pruebas fallan: tu trabajo
consiste en ponerlas en verde.

Las dos secciones comparten plantilla porque usan el mismo catálogo de estructuras y varios
ejercicios de 2.3 comparan con lo que se construye en 2.2. Aun así, **los ocho son independientes y
se pueden resolver en cualquier orden**: ninguno necesita la solución de otro.

## Cómo empezar

Sea cual sea la vía, lo primero es lo mismo: pulsa **Use this template** → **Create a new
repository** y créalo en **tu cuenta personal**. A partir de ahí tienes dos caminos, y **los dos
valen igual**: es un proyecto Maven corriente.

**En el navegador, con Codespaces.** No hay nada que instalar. En tu copia, **Code** →
**Codespaces** → **Create codespace on main**. Se abre VS Code con el JDK 25 y Maven ya puestos. En
el terminal:

```bash
java -version    # debe empezar por: openjdk version "25
mvn test         # verás fallos: es lo esperado al empezar
```

> **Recuerda detener el Codespace** cuando termines (**Code → Codespaces → ⋯ → Stop codespace**):
> mientras está encendido consume tu cuota mensual gratuita.

**En tu ordenador, con IntelliJ IDEA o con VS Code.** Clona tu copia y abre el proyecto por su
`pom.xml`: en IntelliJ, **File → Open** y selecciona el `pom.xml` (elige *Open as Project*); en VS
Code, abre la carpeta y deja que la extensión de Java la importe. Necesitas un **JDK 25**.

## Un ejercicio, una clase de prueba

Cada ejercicio se comprueba con una clase de prueba, y solo con esa. Para trabajar en uno, abre su
clase de prueba y pulsa el botón de ejecutar que aparece junto al nombre de la clase: el ▶ en VS
Code, la flecha verde del margen izquierdo en IntelliJ.

| Ejercicio | Clase | Clase de prueba | Estructura |
|---|---|---|---|
| 2.2.1 | `PalabrasUnicas` | `PalabrasUnicasTest` | `HashSet`, `LinkedHashSet` |
| 2.2.2 | `HistorialDeNavegacion` | `HistorialDeNavegacionTest` | `ArrayDeque` como pila |
| 2.2.3 | `Agenda` | `AgendaTest` | `TreeMap` |
| 2.2.4 | `ResultadosMasLentos` | `ResultadosMasLentosTest` | `PriorityQueue` |
| 2.3.1 | `RepetidosEjercicio` | `RepetidosEjercicioTest` | `HashSet` |
| 2.3.2 | `ConsumirPorElPrincipio` | `ConsumirPorElPrincipioTest` | `ArrayList` frente a `ArrayDeque` |
| 2.3.3 | `Telefonos` | `TelefonosTest` | `TreeMap` frente a `HashMap` |
| 2.3.4 | `ComparativaRepositorios` | `ComparativaRepositoriosTest` | `List` frente a `HashMap` |

**Al clonar, casi todas estas pruebas fallan. Es lo normal**: son la lista de tareas, no una
avería. Van pasando a verde según resuelves los ejercicios. La única que pasa desde el principio es
`laVersionRotaFalla`, de 2.2.1, que comprueba que el código roto del enunciado sigue roto.

## Cómo está organizado

```text
t2-ejercicios-2-2-3/
├── pom.xml                       ← proyecto Maven (Java 25, JUnit 5)
└── src/
    ├── main/java/es/uib/prgava/
    │   ├── tema1/monitor/        ← código del Tema 1, ya escrito
    │   └── tema2/
    │       ├── eficiencia/       ← código del tema, ya escrito
    │       ├── ejercicios/       ← tus ocho clases
    │       └── monitor/          ← el repositorio con índice del tema, ya escrito
    └── test/java/es/uib/prgava/tema2/ejercicios/   ← las pruebas
```

Hay **8 clases** con ejercicios y **15** ya escritas, de las que dependen:

- las once del monitor del Tema 1 —`Servicio` con sus tres implementaciones, `Estado`, `Resultado`,
  `Alerta`, las tres interfaces del repositorio y `RepositorioEnMemoria`—, que usan los dos
  ejercicios del monitor, 2.2.4 y 2.3.4;
- `Recuento` y `Conteos` del Tema 2, que el ejercicio 2.3.1 necesita para anunciar su recuento y
  para comparar con la versión cuadrática, más `DemoConteos` para ejecutar la comparación;
- `RepositorioIndexado`, la versión con índice por servicio del tema, que conviene leer antes de
  hacer 2.3.4.

Son las mismas que hay en
[`t1-ejemplos`](https://github.com/UIB-22354-Programacion-Avanzada/t1-ejemplos) y
[`t2-ejemplos`](https://github.com/UIB-22354-Programacion-Avanzada/t2-ejemplos): puedes leerlas,
ejecutarlas y, cuando el enunciado lo pida, modificarlas.

## Cómo leer el esqueleto

Cada clase que tienes que escribir trae ya las **declaraciones** que necesita el ejercicio: las
firmas de sus métodos y la documentación, para que el proyecto compile y las pruebas se puedan
ejecutar desde el primer momento. Lo que falta son los **cuerpos**, marcados con `// TODO 2.X.k` y
un `throw new UnsupportedOperationException(...)`. **Borra ese `throw`** al implementar el método.

Algunos `TODO` no piden código sino **un comentario**: por qué una pareja de métodos y no la otra,
qué costaría la misma consulta con otra estructura, qué dicen los números que acabas de medir. No
los saltes: son la parte del ejercicio que se evalúa leyendo, y el tipo de pregunta que aparece en
el Examen Parcial.

Hay un método que **ya está escrito y no hay que arreglar**: `PalabrasUnicas.sinLasCortasRoto`. Es
parte del enunciado 2.2.1 y está ahí para ejecutarlo y ver qué pasa.

## Lo que se cuenta, y cómo

Dos ejercicios, 2.3.1 y 2.3.2, piden **contar operaciones**, con el mismo convenio que en la
sección 2.1: el método devuelve lo que tiene que devolver, anuncia su recuento con
`Recuento.anunciar` cuando corresponda, y además deja el número en un método de clase
—`ultimasOperaciones()`, `ultimosDesplazamientos()`— para que las pruebas puedan leerlo.

Y en 2.3.4 no se cronometra nada: lo que se compara son **resultados examinados**, que es el mismo
número en cualquier máquina y en cualquier versión de Java. Esa es la idea de 2.3.5, y la razón de
que una prueba de coste cuente en lugar de medir el tiempo.

## Órdenes útiles

```bash
mvn test                                   # todas las pruebas
mvn -Dtest=AgendaTest test                 # solo una clase
mvn -q compile                             # solo compilar
mvn -q compile exec:java -Dexec.mainClass=es.uib.prgava.tema2.eficiencia.DemoConteos
```

## Integridad académica

El uso de asistentes de IA en estos ejercicios se rige por las **condiciones de uso de la IA** de la
[guía docente](https://uib-22354-programacion-avanzada.github.io/website/es/informaciones/guia-docente.html).
En resumen: puedes pedir explicaciones y revisión, pero entregar código que no sabes explicar,
justificar ni modificar se considera uso indebido. Estos ejercicios son la base de los Talleres y
del Examen Parcial, donde no hay asistente que valga.

## Licencia

El material de partida se publica bajo licencia [MIT](LICENSE) — copyright © 2026 Alejandro Mesejo.
**Las soluciones que escribas son tuyas.** Los enunciados y el resto del material docente están en
el [sitio web de la asignatura](https://uib-22354-programacion-avanzada.github.io/website/), bajo
licencia [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en).
