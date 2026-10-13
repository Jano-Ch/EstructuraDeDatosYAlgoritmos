/**
 * Demostración ejecutable de los casos de inserción del Ejercicio 4.
 */
public class PruebaEjercicio4 {

    /**
     * Ejecuta verificaciones de inserción al inicio, en el medio, al final y
     * de posiciones inválidas.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        ListaEnlazada listaVacia = new ListaEnlazada();
        listaVacia.insertarEnPosicion(10, 0);
        verificar("lista vacía en 0", "10", listaVacia.toString());

        ListaEnlazada lista = new ListaEnlazada();
        lista.insertarEnPosicion(20, 0);
        lista.insertarEnPosicion(30, 1);
        lista.insertarEnPosicion(40, 2);
        lista.insertarEnPosicion(10, 0);
        verificar("inicio", "10 -> 20 -> 30 -> 40", lista.toString());

        lista.insertarEnPosicion(25, 2);
        verificar("medio", "10 -> 20 -> 25 -> 30 -> 40", lista.toString());

        lista.insertarEnPosicion(50, lista.getTamanio());
        verificar("final", "10 -> 20 -> 25 -> 30 -> 40 -> 50",
                lista.toString());

        verificarExcepcion("posición negativa", lista, 99, -1);
        verificarExcepcion("posición mayor que size", lista, 99, 7);
        verificar("lista intacta tras inválidas",
                "10 -> 20 -> 25 -> 30 -> 40 -> 50", lista.toString());

        System.out.println("Todas las pruebas del Ejercicio 4 pasaron.");
    }

    private static void verificar(String caso, String esperado,
            String obtenido) {
        if (!esperado.equals(obtenido)) {
            throw new AssertionError(caso + ": esperado '" + esperado
                    + "', obtenido '" + obtenido + "'");
        }
    }

    private static void verificarExcepcion(String caso, ListaEnlazada lista,
            int dato, int posicion) {
        try {
            lista.insertarEnPosicion(dato, posicion);
            throw new AssertionError(caso
                    + ": se esperaba IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException esperado) {
            // Caso esperado.
        }
    }
}
