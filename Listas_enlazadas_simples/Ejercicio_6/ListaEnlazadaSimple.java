/**
 * Lista enlazada simple para el ejercicio de eliminación por posición.
 *
 * <p>Prompt inicial utilizado (prompt vago simulado): "Haz el ejercicio 6
 * de listas enlazadas simples".</p>
 *
 * <p>Iteración con agente planificador: se precisó que la posición es base
 * cero, que el rango válido es {@code 0 <= posicion < size}, y que una
 * posición inválida debe producir {@link IndexOutOfBoundsException}. La
 * estrategia acordada fue tratar la cabeza por separado y, para los demás
 * casos, recorrer hasta el nodo anterior y enlazarlo con el siguiente del
 * nodo eliminado.</p>
 *
 * <p>Ajustes tras la primera respuesta de OpenCode: se dejó explícito que
 * {@code size} solo se decrementa después de comprobar la posición y de
 * enlazar correctamente; también se documentaron recorrido, enlaces,
 * complejidad y casos límite.</p>
 *
 * @param <T> tipo de los elementos almacenados
 */
public class ListaEnlazadaSimple<T> {

    private Nodo<T> cabeza;
    private int size;

    /**
     * Agrega un elemento al final, para permitir construir listas de prueba.
     *
     * @param elemento elemento que se agregará
     */
    public void agregarAlFinal(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    /**
     * Devuelve la cantidad actual de elementos.
     *
     * @return cantidad de elementos
     */
    public int size() {
        return size;
    }

    /**
     * Elimina el elemento ubicado en una posición base cero.
     *
     * <p>Para la posición cero se mueve {@code cabeza} al nodo siguiente.
     * Para cualquier otra posición se recorre la lista hasta encontrar el
     * nodo anterior; después se salta el nodo eliminado enlazando el anterior
     * con su siguiente. La operación tarda {@code O(n)} en el peor caso por
     * el recorrido y usa {@code O(1)} espacio adicional.</p>
     *
     * <p>Casos contemplados: una lista vacía o una posición negativa son
     * inválidos; también lo es una posición igual o mayor que {@code size}.
     * En todos esos casos se lanza {@link IndexOutOfBoundsException} sin
     * modificar la lista ni su tamaño. Eliminar el único elemento deja la
     * cabeza en {@code null} y el tamaño en cero.</p>
     *
     * @param posicion posición base cero del elemento que se eliminará
     * @throws IndexOutOfBoundsException si
     *         {@code posicion < 0 || posicion >= size}
     */
    public void eliminarEnPosicion(int posicion) {
        // DECISION: usar posiciones base cero y rechazar valores fuera de 0 <= posicion < size — Motivo: criterio de aceptación confirmado.
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                    "Posición fuera de rango: " + posicion
                            + "; tamaño: " + size);
        }

        if (posicion == 0) {
            cabeza = cabeza.siguiente;
        } else {
            Nodo<T> anterior = cabeza;
            for (int indice = 1; indice < posicion; indice++) {
                anterior = anterior.siguiente;
            }
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        size--;
    }

    /**
     * Devuelve el elemento de una posición, útil para verificar el resultado.
     *
     * @param posicion posición base cero que se consultará
     * @return elemento de la posición
     * @throws IndexOutOfBoundsException si la posición no es válida
     */
    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                    "Posición fuera de rango: " + posicion
                            + "; tamaño: " + size);
        }
        Nodo<T> actual = cabeza;
        for (int indice = 0; indice < posicion; indice++) {
            actual = actual.siguiente;
        }
        return actual.elemento;
    }

    /**
     * Nodo interno de una lista enlazada simple.
     *
     * @param <T> tipo del elemento del nodo
     */
    private static final class Nodo<T> {
        private final T elemento;
        private Nodo<T> siguiente;

        private Nodo(T elemento) {
            this.elemento = elemento;
        }
    }
}
