import java.lang.reflect.Field;

/**
 * Prueba ejecutable de {@link ListaEnlazadaSimple}.
 */
public final class Ejercicio7Prueba {
    private Ejercicio7Prueba() {
    }

    /**
     * Verifica modificación, límites y conservación de la estructura.
     *
     * @param args argumentos no utilizados
     * @throws Exception si la inspección de la estructura privada falla
     */
    public static void main(String[] args) throws Exception {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.agregarAlInicio(30);
        lista.agregarAlInicio(20);
        lista.agregarAlInicio(10);

        Field headField = ListaEnlazadaSimple.class.getDeclaredField("head");
        headField.setAccessible(true);
        Object headAntes = headField.get(lista);
        int sizeAntes = lista.size();

        lista.modificar(1, 99);

        Object headDespues = headField.get(lista);
        verificar(headAntes == headDespues, "modificar conserva head");
        verificar(lista.size() == sizeAntes, "modificar conserva size");
        verificar(datoEn(headDespues) == 10, "conserva el dato del primer nodo");
        Object segundo = siguienteDe(headDespues);
        verificar(datoEn(segundo) == 99, "modifica el dato de la posición 1");
        verificar(siguienteDe(segundo) != null, "conserva el enlace del nodo modificado");
        verificar(datoEn(siguienteDe(segundo)) == 30, "conserva el tercer nodo");

        verificarLanzaIndice(lista, -1);
        verificarLanzaIndice(lista, 3);

        ListaEnlazadaSimple vacia = new ListaEnlazadaSimple();
        verificarLanzaIndice(vacia, 0);
        System.out.println("Ejercicio 7: todas las pruebas pasaron.");
    }

    private static int datoEn(Object nodo) throws Exception {
        Field dato = nodo.getClass().getDeclaredField("dato");
        dato.setAccessible(true);
        return dato.getInt(nodo);
    }

    private static Object siguienteDe(Object nodo) throws Exception {
        Field siguiente = nodo.getClass().getDeclaredField("siguiente");
        siguiente.setAccessible(true);
        return siguiente.get(nodo);
    }

    private static void verificarLanzaIndice(ListaEnlazadaSimple lista, int posicion) {
        try {
            lista.modificar(posicion, 0);
            throw new AssertionError("No lanzó excepción para posición " + posicion);
        } catch (IndexOutOfBoundsException esperado) {
            // Caso esperado.
        }
    }

    private static void verificar(boolean condicion, String descripcion) {
        if (!condicion) {
            throw new AssertionError(descripcion);
        }
    }
}
