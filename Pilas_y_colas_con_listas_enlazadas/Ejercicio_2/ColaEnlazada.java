/**
 * Cola enlazada de enteros que respeta el orden FIFO (primero en entrar,
 * primero en salir).
 *
 * <p>Se mantienen dos referencias: {@code head} representa el frente, donde
 * se desencola y se consulta el siguiente elemento, y {@code tail} representa
 * el final, donde se encola. Ambas referencias son necesarias para que las
 * operaciones de ambos extremos sean O(1). Si se conservara solamente
 * {@code head}, habría que recorrer toda la cola para encontrar el último
 * nodo al encolar, haciendo que esa operación fuera O(n).</p>
 */
public class ColaEnlazada {
    private Nodo head;
    private Nodo tail;

    /**
     * Nodo propio de la cola enlazada.
     */
    private static final class Nodo {
        private final int valor;
        private Nodo siguiente;

        private Nodo(int valor) {
            this.valor = valor;
        }
    }

    /**
     * Agrega un entero al final de la cola.
     *
     * @param valor entero que se agregará; admite negativos, cero y duplicados
     */
    public void encolar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
            return;
        }

        tail.siguiente = nuevo;
        tail = nuevo;
    }

    /**
     * Quita y devuelve el entero que está en el frente de la cola.
     *
     * @return el primer entero, o {@code null} si la cola está vacía
     */
    public Integer desencolar() {
        if (estaVacia()) {
            return null;
        }

        int valor = head.valor;
        head = head.siguiente;
        if (head == null) {
            tail = null;
        }
        return valor;
    }

    /**
     * Consulta el entero del frente sin quitarlo.
     *
     * @return el primer entero, o {@code null} si la cola está vacía
     */
    public Integer frente() {
        return estaVacia() ? null : head.valor;
    }

    /**
     * Indica si la cola no contiene elementos.
     *
     * @return {@code true} cuando la cola está vacía; {@code false} en caso contrario
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Busca un entero en la cola.
     *
     * @param valor entero que se desea encontrar
     * @return {@code true} si aparece al menos una vez; {@code false} si no aparece
     */
    public boolean buscar(int valor) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.valor == valor) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Imprime los elementos desde el frente hasta el final.
     */
    public void imprimir() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.valor);
            if (actual.siguiente != null) {
                System.out.print(" ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
