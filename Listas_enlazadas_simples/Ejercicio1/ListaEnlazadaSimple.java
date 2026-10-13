/**
 * Lista enlazada simple de enteros.
 *
 * <p>Propósito: almacenar valores enteros mediante nodos enlazados, sin usar
 * {@code ArrayList}, {@code LinkedList} ni otras colecciones para la lista.</p>
 *
 * <p>El nodo contiene un {@code dato} y una referencia {@code siguiente}.
 * {@code head} apunta al primer nodo de la lista y {@code size} mantiene la
 * cantidad actual de elementos.</p>
 *
 * <p>Complejidades: insertar al inicio es O(1) en el mejor, peor y caso
 * promedio; insertar al final es O(n) en el mejor, peor y caso promedio
 * porque se recorre la lista; imprimir es O(n) en todos los casos; consultar
 * si está vacía y obtener el tamaño son O(1) en todos los casos.</p>
 */
public class ListaEnlazadaSimple {

    /**
     * Nodo interno de la lista: guarda un entero y el siguiente nodo.
     */
    private static final class Nodo {
        private final int dato;
        private Nodo siguiente;

        private Nodo(int dato) {
            this.dato = dato;
        }
    }

    private Nodo head;
    private int size;

    /**
     * Inserta un valor como primer elemento.
     *
     * @param dato valor entero que se agregará
     */
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = head;
        head = nuevoNodo;
        size++;
    }

    /**
     * Inserta un valor como último elemento.
     *
     * @param dato valor entero que se agregará
     */
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        size++;
    }

    /**
     * Imprime los elementos desde el primero hasta el último.
     */
    public void imprimir() {
        // DECISION: una lista vacía se representa como "(vacía)" — Motivo: ofrece una salida explícita y legible.
        if (head == null) {
            System.out.println("(vacía)");
            return;
        }

        Nodo actual = head;
        StringBuilder salida = new StringBuilder();
        while (actual != null) {
            if (salida.length() > 0) {
                salida.append(" -> ");
            }
            salida.append(actual.dato);
            actual = actual.siguiente;
        }
        System.out.println(salida);
    }

    /**
     * Indica si la lista no contiene elementos.
     *
     * @return {@code true} si la lista está vacía; {@code false} en otro caso
     */
    public boolean estaVacia() {
        return size == 0;
    }

    /**
     * Obtiene la cantidad de elementos almacenados.
     *
     * @return tamaño actual de la lista
     */
    public int getSize() {
        return size;
    }
}
