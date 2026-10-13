/**
 * Demostración ejecutable local de {@link ListaEnlazadaSimple}.
 *
 * <p>Usa aserciones explícitas para verificar los casos normales y de borde
 * definidos para la búsqueda secuencial.</p>
 */
public final class Ejercicio2Prueba {
    private Ejercicio2Prueba() {
        // Clase de utilidad: no se instancia.
    }

    /**
     * Ejecuta las verificaciones del ejercicio.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        ListaEnlazadaSimple listaVacia = new ListaEnlazadaSimple();
        verificar(!listaVacia.buscar(10), "Una lista vacía no contiene datos");

        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.agregarAlInicio(10);
        lista.agregarAlInicio(-3);
        lista.agregarAlInicio(10);

        verificar(lista.buscar(10), "Encuentra una coincidencia en el primer nodo");
        verificar(lista.buscar(-3), "Encuentra una coincidencia intermedia");
        verificar(!lista.buscar(99), "Informa ausencia al alcanzar null");
        verificar(lista.buscar(0) == false, "No confunde un dato ausente con cero");

        System.out.println("Ejercicio 2: todas las pruebas pasaron.");
    }

    private static void verificar(boolean condicion, String descripcion) {
        if (!condicion) {
            throw new AssertionError(descripcion);
        }
    }
}
