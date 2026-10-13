import java.util.Objects;

/**
 * Pila enlazada genérica que respeta la política LIFO
 * (el último elemento apilado es el primero en salir).
 *
 * <p>Un genérico permite que la misma clase trabaje con distintos tipos
 * ({@code Integer}, {@code String} u objetos propios) manteniendo seguridad
 * de tipos en compilación. La lógica de la pila no depende de {@code T}:
 * solamente enlaza nodos, consulta el tope y recorre referencias.</p>
 *
 * @param <T> tipo de los elementos almacenados
 */
public class Pila<T> {
    private Nodo<T> tope;

    /**
     * Agrega un elemento en el tope de la pila.
     *
     * @param elemento elemento que se apila; también puede ser {@code null}
     */
    public void apilar(T elemento) {
        // DECISION: se permiten valores null al apilar — Motivo: el plan define
        // el comportamiento de pop/peek vacío, pero no restringe los elementos.
        tope = new Nodo<>(elemento, tope);
    }

    /**
     * Alias en inglés de {@link #apilar(Object)}.
     *
     * @param elemento elemento que se apila
     */
    public void push(T elemento) {
        apilar(elemento);
    }

    /**
     * Retira y devuelve el elemento del tope.
     *
     * @return elemento retirado o {@code null} si la pila está vacía
     */
    public T desapilar() {
        if (estaVacia()) {
            return null;
        }
        T elemento = tope.elemento;
        tope = tope.siguiente;
        return elemento;
    }

    /**
     * Alias en inglés de {@link #desapilar()}.
     *
     * @return elemento retirado o {@code null} si la pila está vacía
     */
    public T pop() {
        return desapilar();
    }

    /**
     * Consulta el elemento del tope sin retirarlo.
     *
     * @return elemento del tope o {@code null} si la pila está vacía
     */
    public T tope() {
        return tope == null ? null : tope.elemento;
    }

    /**
     * Alias en inglés de {@link #tope()}.
     *
     * @return elemento del tope o {@code null} si la pila está vacía
     */
    public T peek() {
        return tope();
    }

    /**
     * Indica si la pila no contiene elementos.
     *
     * @return {@code true} cuando no hay elementos
     */
    public boolean estaVacia() {
        return tope == null;
    }

    /**
     * Alias en inglés de {@link #estaVacia()}.
     *
     * @return {@code true} cuando no hay elementos
     */
    public boolean isEmpty() {
        return estaVacia();
    }

    /**
     * Busca un elemento usando igualdad segura para valores {@code null}.
     *
     * @param elemento valor que se desea encontrar
     * @return {@code true} si existe un elemento igual
     */
    public boolean buscar(T elemento) {
        Nodo<T> actual = tope;
        while (actual != null) {
            // DECISION: la búsqueda usa igualdad lógica y admite null — Motivo:
            // es la convención más útil para tipos genéricos y evita comparar
            // directamente con un método que podría no existir en T.
            if (Objects.equals(actual.elemento, elemento)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Imprime los elementos desde el tope hacia la base.
     *
     * <p>Esta convención hace visible el orden LIFO: el primer valor impreso
     * es el próximo que devolvería {@link #pop()}.</p>
     */
    public void imprimir() {
        Nodo<T> actual = tope;
        while (actual != null) {
            System.out.println(actual.elemento);
            actual = actual.siguiente;
        }
    }

    private static final class Nodo<T> {
        private final T elemento;
        private final Nodo<T> siguiente;

        private Nodo(T elemento, Nodo<T> siguiente) {
            this.elemento = elemento;
            this.siguiente = siguiente;
        }
    }
}
