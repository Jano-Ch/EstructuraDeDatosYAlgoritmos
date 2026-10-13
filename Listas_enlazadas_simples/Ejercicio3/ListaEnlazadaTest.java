/**
 * Prueba ejecutable, sin dependencias externas, del Ejercicio 3.
 */
// DECISION: se usa una clase main en lugar de JUnit — Motivo: no hay configuración de build ni dependencias en la carpeta.
public final class ListaEnlazadaTest {
    private ListaEnlazadaTest() {
    }

    /**
     * Verifica casos normal y límite.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        comprobarExcepcion(() -> lista.obtener(0), "lista vacía");
        comprobarExcepcion(() -> lista.obtener(-1), "negativo");
        lista.agregar("primero");
        lista.agregar("segundo");
        lista.agregar("último");
        comprobar("primero".equals(lista.obtener(0)), "primero");
        comprobar("último".equals(lista.obtener(2)), "último");
        comprobarExcepcion(() -> lista.obtener(3), "igual al tamaño");
        comprobar(lista.size() == 3, "sin modificación de la lista");
        System.out.println("Todas las verificaciones de Ejercicio 3 pasaron.");
    }

    private static void comprobar(boolean condicion, String caso) {
        if (!condicion) {
            throw new AssertionError("Falló: " + caso);
        }
    }

    private static void comprobarExcepcion(Runnable operacion, String caso) {
        try {
            operacion.run();
            throw new AssertionError("Falló: no se lanzó excepción en " + caso);
        } catch (IndexOutOfBoundsException esperada) {
            // Excepción esperada.
        }
    }
}
