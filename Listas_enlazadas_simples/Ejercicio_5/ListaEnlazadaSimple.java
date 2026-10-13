/**
 * Lista enlazada simple de enteros para el Ejercicio 5.
 *
 * <p>Prompt inicial utilizado (prompt vago simulado): "Hacer el ejercicio 5
 * de listas enlazadas". Iteración con planificador: se precisó que
 * {@link #eliminar(int)} elimina únicamente la primera aparición y contempla
 * lista vacía, primero, medio, último e inexistente. Ajustes tras la primera
 * respuesta de OpenCode: se actualizan {@code head} y {@code size}, se
 * desconecta el nodo eliminado y se documentan la complejidad y los casos
 * límite.</p>
 */
public class ListaEnlazadaSimple {
    private Nodo head;
    private int size;

    /**
     * Crea una lista vacía.
     */
    public ListaEnlazadaSimple() {
        head = null;
        size = 0;
    }

    // DECISION: se incluye una operación mínima de carga — Motivo: la
    // carpeta del ejercicio estaba vacía y se necesita construir casos de
    // prueba sin modificar otras carpetas.
    /**
     * Agrega un dato al final de la lista.
     *
     * @param dato valor que se agregará
     */
    public void agregarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    /**
     * Elimina la primera aparición del dato indicado.
     *
     * <p>Si la lista está vacía o el dato no existe, no se modifica la lista
     * y se devuelve {@code false}. Para el primer nodo se actualiza
     * {@code head}; para los restantes se salta el nodo desde su antecesor.
     * El enlace del nodo eliminado se establece en {@code null}, dejándolo
     * inaccesible desde la lista y elegible para el Garbage Collector, sin
     * realizar borrado manual.</p>
     *
     * <p>Complejidad temporal: mejor caso O(1) (lista vacía o dato en el
     * primer nodo), peor caso O(n) (último nodo o inexistente) y promedio
     * O(n). Complejidad espacial: O(1).</p>
     *
     * @param dato valor que se desea eliminar
     * @return {@code true} si se eliminó la primera aparición;
     *         {@code false} si no se encontró
     */
    public boolean eliminar(int dato) {
        if (head == null) {
            return false;
        }

        if (head.dato == dato) {
            Nodo eliminado = head;
            head = head.siguiente;
            eliminado.siguiente = null;
            size--;
            return true;
        }

        Nodo anterior = head;
        Nodo actual = head.siguiente;
        while (actual != null) {
            if (actual.dato == dato) {
                anterior.siguiente = actual.siguiente;
                actual.siguiente = null;
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Devuelve la cantidad de elementos actuales.
     *
     * @return tamaño de la lista
     */
    public int size() {
        return size;
    }

    /**
     * Representa un nodo enlazado simple.
     */
    private static final class Nodo {
        private final int dato;
        private Nodo siguiente;

        private Nodo(int dato) {
            this.dato = dato;
        }
    }
}
