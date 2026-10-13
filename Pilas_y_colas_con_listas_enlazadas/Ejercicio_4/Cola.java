import java.util.Objects;

/**
 * Cola enlazada genérica que mantiene el orden de llegada de sus elementos.
 *
 * @param <T> tipo de elementos almacenados
 */
public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> finalCola;

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param elemento elemento que se encola; puede ser {@code null}
     */
    public void encolar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (estaVacia()) {
            frente = nuevo;
            finalCola = nuevo;
            return;
        }

        finalCola.siguiente = nuevo;
        finalCola = nuevo;
    }

    /**
     * Retira y devuelve el elemento que está en el frente.
     *
     * @return el primer elemento, o {@code null} si la cola está vacía
     */
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }

        T elemento = frente.elemento;
        frente = frente.siguiente;
        if (frente == null) {
            finalCola = null;
        }
        return elemento;
    }

    /**
     * Consulta el elemento del frente sin retirarlo.
     *
     * @return el primer elemento, o {@code null} si la cola está vacía
     */
    public T frente() {
        return estaVacia() ? null : frente.elemento;
    }

    /**
     * Indica si no hay elementos en la cola.
     *
     * @return {@code true} cuando la cola está vacía
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Busca un elemento usando {@link Objects#equals(Object, Object)}.
     *
     * @param buscado elemento a buscar
     * @return {@code true} si la cola contiene un elemento igual
     */
    public boolean buscar(T buscado) {
        Nodo<T> actual = frente;
        while (actual != null) {
            if (Objects.equals(actual.elemento, buscado)) {
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
        Nodo<T> actual = frente;
        if (actual == null) {
            System.out.println("Cola vacía");
            return;
        }

        StringBuilder salida = new StringBuilder();
        while (actual != null) {
            if (salida.length() > 0) {
                salida.append(" -> ");
            }
            salida.append(actual.elemento);
            actual = actual.siguiente;
        }
        System.out.println(salida);
    }

    /**
     * Nodo privado usado exclusivamente por la cola.
     *
     * @param <E> tipo de elemento del nodo
     */
    private static final class Nodo<E> {
        private final E elemento;
        private Nodo<E> siguiente;

        private Nodo(E elemento) {
            this.elemento = elemento;
        }
    }
}
