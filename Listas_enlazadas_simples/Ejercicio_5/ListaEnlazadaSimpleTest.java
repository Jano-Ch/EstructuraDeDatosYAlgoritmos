/**
 * Verificación ejecutable del Ejercicio 5, sin dependencias externas.
 */
public final class ListaEnlazadaSimpleTest {
    private ListaEnlazadaSimpleTest() {
    }

    /**
     * Ejecuta los casos acordados y falla con una excepción si alguno no se
     * cumple.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        pruebaListaVacia();
        pruebaPrimeraAparicion();
        pruebaNodoDelMedio();
        pruebaUltimoNodo();
        pruebaDatoInexistente();
        System.out.println("Todas las pruebas del Ejercicio 5 fueron exitosas.");
    }

    private static void pruebaListaVacia() {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        verificar(!lista.eliminar(7), "Una lista vacía no elimina");
        verificar(lista.size() == 0, "La lista vacía conserva size");
    }

    private static void pruebaPrimeraAparicion() {
        ListaEnlazadaSimple lista = listaDe(4, 4, 8);
        verificar(lista.eliminar(4), "Debe eliminar el primer nodo");
        verificar(lista.size() == 2, "Debe decrementar size al eliminar head");
        verificar(lista.eliminar(4), "Debe quedar la segunda aparición");
        verificar(lista.size() == 1, "Debe decrementar size en la segunda eliminación");
    }

    private static void pruebaNodoDelMedio() {
        ListaEnlazadaSimple lista = listaDe(1, 2, 3);
        verificar(lista.eliminar(2), "Debe eliminar un nodo del medio");
        verificar(lista.size() == 2, "Debe actualizar size al eliminar del medio");
        verificar(!lista.eliminar(2), "El dato eliminado no debe seguir accesible");
    }

    private static void pruebaUltimoNodo() {
        ListaEnlazadaSimple lista = listaDe(1, 2, 3);
        verificar(lista.eliminar(3), "Debe eliminar el último nodo");
        verificar(lista.size() == 2, "Debe actualizar size al eliminar el último");
        verificar(lista.eliminar(1), "Debe seguir permitiendo eliminar head");
        verificar(lista.eliminar(2), "Debe permitir vaciar la lista");
        verificar(lista.size() == 0, "La lista debe quedar vacía");
    }

    private static void pruebaDatoInexistente() {
        ListaEnlazadaSimple lista = listaDe(1, 2, 3);
        verificar(!lista.eliminar(9), "Un dato inexistente devuelve false");
        verificar(lista.size() == 3, "Un dato inexistente no cambia size");
    }

    private static ListaEnlazadaSimple listaDe(int... datos) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        for (int dato : datos) {
            lista.agregarAlFinal(dato);
        }
        return lista;
    }

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}
