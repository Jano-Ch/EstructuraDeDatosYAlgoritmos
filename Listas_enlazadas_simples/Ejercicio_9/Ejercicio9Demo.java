/**
 * Demostración y pruebas locales del Ejercicio 9.
 *
 * <p>Bloque Prompt inicial utilizado con prompt vago simulado:
 * "Hacé el ejercicio 9 de listas enlazadas simples". Luego se iteró con un
 * agente planificador para precisar una inversión in situ. Ajustes tras la
 * primera respuesta de OpenCode: se limitó el cambio al Ejercicio 9, se
 * fijaron la firma pública {@code void invertir()}, el algoritmo con
 * {@code anterior}, {@code actual} y {@code siguiente}, la complejidad
 * O(n)/O(1), y pruebas para lista vacía, un nodo y valores repetidos.</p>
 */
public final class Ejercicio9Demo {

    // DECISION: usar la carpeta existente Ejercicio_9 — Motivo: el repositorio
    // no contiene la ruta solicitada Ejercicio9 y esta es su carpeta equivalente.
    private Ejercicio9Demo() {
        // Clase de demostración: no debe instanciarse.
    }

    /**
     * Ejecuta las pruebas de aceptación del ejercicio.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        ListaEnlazadaSimple vacia = new ListaEnlazadaSimple();
        vacia.invertir();
        verificar("(vacía)".equals(vacia.toString()),
                "invertir una lista vacía debe dejarla vacía");

        ListaEnlazadaSimple unNodo = new ListaEnlazadaSimple();
        unNodo.insertarAlFinal(7);
        unNodo.invertir();
        verificar("7".equals(unNodo.toString()),
                "invertir una lista de un nodo debe conservar su valor");

        ListaEnlazadaSimple repetidos = new ListaEnlazadaSimple();
        repetidos.insertarAlFinal(1);
        repetidos.insertarAlFinal(2);
        repetidos.insertarAlFinal(2);
        repetidos.insertarAlFinal(3);
        repetidos.invertir();
        verificar("3 -> 2 -> 2 -> 1".equals(repetidos.toString()),
                "la inversión debe conservar los valores repetidos");

        System.out.println("Pruebas del Ejercicio 9 aprobadas.");
    }

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}
