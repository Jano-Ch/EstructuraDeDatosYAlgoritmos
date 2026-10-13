/**
 * Lista enlazada simple de enteros para el Ejercicio 7.
 *
 * <p>{@code modificar} cambia únicamente el dato del nodo ubicado en la
 * posición indicada. El dato es el valor entero almacenado en el nodo;
 * {@code siguiente} es la referencia al próximo nodo y nunca se modifica.
 * Por eso también se conservan {@code head}, todos los enlaces y {@code size}.</p>
 *
 * <p>Las posiciones usan base cero. Primero se valida
 * {@code 0 <= posicion < size}; una posición inválida lanza
 * {@link IndexOutOfBoundsException} sin recorrer la lista. La búsqueda del
 * nodo cuesta O(posicion), y O(n) en el peor caso; modificar el dato cuesta
 * O(1) una vez alcanzado el nodo y usa O(1) espacio adicional. En una lista
 * vacía toda posición es inválida.</p>
 *
 * <p>Prompt inicial utilizado (simulando un prompt vago):</p>
 * <blockquote>
 * Implementa el ejercicio 7 de listas enlazadas simples en Java.
 * </blockquote>
 *
 * <p>Iteración posterior con el planificador:</p>
 * <blockquote>
 * Implementar {@code void modificar(int posicion, int nuevoDato)} con
 * posiciones base cero; validar el rango antes de recorrer; lanzar
 * {@code IndexOutOfBoundsException} si es inválida; cambiar solo el dato,
 * conservando {@code head}, enlaces y {@code size}.
 * </blockquote>
 *
 * <p>Ajustes tras la primera respuesta de OpenCode: restringir los cambios a
 * este ejercicio, no crear README y agregar una prueba ejecutable que verifique
 * los casos válido, lista vacía, límites inválidos y conservación de
 * referencias y tamaño.</p>
 */
public class ListaEnlazadaSimple {
    private Nodo head;
    private int size;

    /**
     * Agrega un dato al inicio para construir listas de prueba.
     *
     * @param dato valor que se agregará
     */
    public void agregarAlInicio(int dato) {
        head = new Nodo(dato, head);
        size++;
    }

    /**
     * Devuelve la cantidad de nodos de la lista.
     *
     * @return tamaño actual
     */
    public int size() {
        return size;
    }

    /**
     * Reemplaza el dato del nodo en una posición base cero.
     *
     * @param posicion posición del nodo que se modificará
     * @param nuevoDato nuevo valor entero
     * @throws IndexOutOfBoundsException si la posición no pertenece a la lista
     */
    public void modificar(int posicion, int nuevoDato) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                    "Posición fuera de rango: " + posicion + " (tamaño: " + size + ")");
        }

        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        // DECISION: mutar solo dato y mantener siguiente final — Motivo: el
        // ejercicio exige modificar el valor sin alterar la estructura.
        actual.dato = nuevoDato;
    }

    private static final class Nodo {
        private int dato;
        private final Nodo siguiente;

        private Nodo(int dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }
}
