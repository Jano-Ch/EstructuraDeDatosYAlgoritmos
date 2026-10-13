/**
 * Lista enlazada simple de enteros con inversión in situ.
 *
 * <p>El orden fundamental de la inversión es recorrer la lista desde
 * {@code head} y, en cada nodo, redirigir su referencia {@code siguiente}
 * hacia el nodo anterior. El recorrido utiliza únicamente las referencias
 * {@code anterior}, {@code actual} y {@code siguiente}; no crea nodos ni
 * utiliza colecciones auxiliares.</p>
 *
 * <p>Complejidad de {@link #invertir()}: O(n) tiempo y O(1) espacio
 * adicional. Una lista vacía y una lista de un nodo quedan sin cambios.
 * También se conservan correctamente los valores repetidos, porque la
 * operación modifica enlaces y no compara ni elimina datos.</p>
 */
public class ListaEnlazadaSimple {

    /**
     * Nodo de la lista.
     */
    private static final class Nodo {
        private final int dato;
        private Nodo siguiente;

        private Nodo(int dato) {
            this.dato = dato;
        }
    }

    private Nodo head;

    /**
     * Agrega un valor al final de la lista para poder construir ejemplos.
     *
     * @param dato valor entero que se agregará
     */
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            head = nuevo;
            return;
        }

        Nodo actual = head;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    /**
     * Invierte los enlaces de la lista en el lugar.
     *
     * <p>El orden fundamental es: guardar {@code actual.siguiente} en
     * {@code siguiente}, redirigir {@code actual.siguiente} a
     * {@code anterior}, avanzar {@code anterior} y {@code actual}, y al
     * finalizar actualizar {@code head}.</p>
     */
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = head;

        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        head = anterior;
    }

    /**
     * Devuelve la representación de los datos en orden de recorrido.
     *
     * @return valores separados por {@code " -> "}, o {@code "(vacía)"}
     *         cuando no hay nodos
     */
    @Override
    public String toString() {
        if (head == null) {
            return "(vacía)";
        }

        StringBuilder resultado = new StringBuilder();
        Nodo actual = head;
        while (actual != null) {
            if (resultado.length() > 0) {
                resultado.append(" -> ");
            }
            resultado.append(actual.dato);
            actual = actual.siguiente;
        }
        return resultado.toString();
    }
}
