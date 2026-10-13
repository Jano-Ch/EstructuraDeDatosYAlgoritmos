import java.util.Objects;

/**
 * Lista doblemente enlazada genérica.
 *
 * <p>Prompt inicial inventado: "Implementá una lista doblemente enlazada
 * genérica en Java. Usá un nodo propio con dato, anterior y siguiente, y
 * mantené referencias a cabeza y cola. Incluí inserción al inicio y al final,
 * eliminación de la primera coincidencia, impresión en ambos sentidos,
 * casos vacío, único, cabeza, cola, intermedio, inexistente, duplicados y
 * null, junto con sus complejidades. La iteración se definirá con ayuda del
 * planificador para recorrer los enlaces sin perder la referencia al nodo
 * siguiente."</p>
 *
 * <p>Cada nodo conoce a su vecino anterior y a su vecino siguiente. La lista
 * conserva además la referencia al primer nodo ({@code cabeza}) y al último
 * ({@code cola}); por eso ambas inserciones son O(1). En una lista vacía las
 * dos referencias son {@code null}; en una lista de un elemento apuntan al
 * mismo nodo, cuyo anterior y siguiente son {@code null}.</p>
 *
 * <p>La comparación de eliminación usa {@link Objects#equals(Object, Object)}
 * para aceptar valores {@code null} de forma segura. Las impresiones recorren
 * los enlaces en O(n) y el espacio ocupado por la lista es O(n).</p>
 *
 * @param <T> tipo de dato almacenado en cada nodo
 */
public class ListaDoblementeEnlazada<T> {

    /**
     * Nodo privado propio de la lista.
     *
     * @param <T> tipo del dato almacenado
     */
    private static final class Nodo<T> {
        private T dato;
        private Nodo<T> anterior;
        private Nodo<T> siguiente;

        private Nodo(T dato) {
            this.dato = dato;
        }
    }

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamanio;

    /**
     * Inserta un dato al comienzo de la lista.
     *
     * @param dato dato a insertar; puede ser {@code null}
     */
    public void insertarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza;

        if (cabeza == null) {
            cola = nuevo;
        } else {
            cabeza.anterior = nuevo;
        }

        cabeza = nuevo;
        tamanio++;
    }

    /**
     * Inserta un dato al final de la lista.
     *
     * @param dato dato a insertar; puede ser {@code null}
     */
    public void insertarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.anterior = cola;

        if (cola == null) {
            cabeza = nuevo;
        } else {
            cola.siguiente = nuevo;
        }

        cola = nuevo;
        tamanio++;
    }

    /**
     * Elimina la primera aparición de un dato.
     *
     * <p>La búsqueda comienza en la cabeza, por lo que, si hay duplicados,
     * solamente se elimina el primero. La igualdad es segura cuando el dato
     * buscado o el dato almacenado es {@code null}.</p>
     *
     * @param buscado dato que se desea eliminar
     * @return {@code true} si se eliminó una coincidencia; {@code false} si
     *         la lista está vacía o no existe
     */
    public boolean eliminarPrimeraCoincidencia(T buscado) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (Objects.equals(actual.dato, buscado)) {
                desvincular(actual);
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Imprime los datos desde la cabeza hacia la cola.
     *
     * <p>Para una lista vacía imprime {@code []}. La operación es O(n).</p>
     */
    public void imprimirAdelante() {
        System.out.println(representacionDesde(cabeza, false));
    }

    /**
     * Imprime los datos desde la cola hacia la cabeza.
     *
     * <p>Para una lista vacía imprime {@code []}. La operación es O(n).</p>
     */
    public void imprimirAtras() {
        System.out.println(representacionDesde(cola, true));
    }

    /**
     * Indica si la lista no contiene nodos.
     *
     * @return {@code true} cuando está vacía
     */
    public boolean estaVacia() {
        return tamanio == 0;
    }

    /**
     * Devuelve la cantidad de elementos almacenados.
     *
     * @return cantidad de nodos de la lista
     */
    public int tamanio() {
        return tamanio;
    }

    private void desvincular(Nodo<T> nodo) {
        if (nodo.anterior == null) {
            cabeza = nodo.siguiente;
        } else {
            nodo.anterior.siguiente = nodo.siguiente;
        }

        if (nodo.siguiente == null) {
            cola = nodo.anterior;
        } else {
            nodo.siguiente.anterior = nodo.anterior;
        }

        nodo.anterior = null;
        nodo.siguiente = null;
        tamanio--;
    }

    private String representacionDesde(Nodo<T> inicio, boolean haciaAnterior) {
        // DECISION: representar la lista como [dato1, dato2] y la vacía como [] — Motivo: ofrece una salida clara y uniforme para ambos sentidos sin agregar dependencias.
        StringBuilder resultado = new StringBuilder("[");
        Nodo<T> actual = inicio;
        while (actual != null) {
            if (actual != inicio) {
                resultado.append(", ");
            }
            resultado.append(actual.dato);
            actual = haciaAnterior ? actual.anterior : actual.siguiente;
        }
        return resultado.append(']').toString();
    }
}
