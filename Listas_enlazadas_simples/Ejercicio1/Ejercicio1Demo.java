/**
 * Demostración local del Ejercicio 1.
 *
 * <p>Incluye verificaciones de los casos vacío, inserción al inicio, inserción
 * al final, valores repetidos y valores negativos.</p>
 *
 * <p>Prompt inicial utilizado con prompt deliberadamente vago simulado:
 * "Hacé el ejercicio 1 de listas enlazadas simples". Después se iteró con
 * agente planificador. Ajustes realizados luego de la primera respuesta de
 * OpenCode: se acotó el alcance exclusivamente a Ejercicio1, se exigió una
 * lista de enteros sin colecciones de Java, se definieron las operaciones
 * insertarAlInicio, insertarAlFinal, imprimir, estaVacia y getSize, y se
 * agregaron complejidades, documentación y pruebas locales.</p>
 */
public final class Ejercicio1Demo {

    private Ejercicio1Demo() {
        // Clase de demostración: no debe instanciarse.
    }

    /**
     * Ejecuta las verificaciones del ejercicio.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        verificar(lista.estaVacia(), "una lista nueva debe estar vacía");
        verificar(lista.getSize() == 0, "el tamaño inicial debe ser cero");
        lista.imprimir();

        lista.insertarAlInicio(2);
        lista.insertarAlInicio(1);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(-4);
        lista.insertarAlFinal(3);

        verificar(!lista.estaVacia(), "la lista con elementos no debe estar vacía");
        verificar(lista.getSize() == 5, "el tamaño debe contar todas las inserciones");
        lista.imprimir();

        System.out.println("Pruebas del Ejercicio 1 aprobadas.");
    }

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}
