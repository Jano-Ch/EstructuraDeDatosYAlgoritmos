/**
 * Lista enlazada simple de elementos genéricos.
 *
 * <p>Prompt inicial utilizado (prompt vago simulado):</p>
 * <blockquote>«Hacer el ejercicio 3 de listas enlazadas.»</blockquote>
 *
 * <p>Iteración con agente planificador:</p>
 * <blockquote>«Implementar {@link #obtener(int)} con posiciones base cero,
 * validar antes de recorrer, lanzar {@link IndexOutOfBoundsException} cuando
 * la posición sea inválida, recorrer nodo por nodo sin modificar la lista y
 * documentar complejidad y casos límite.»</blockquote>
 *
 * <p>Ajustes tras la primera respuesta de OpenCode: se explicitó que la
 * validación ocurre antes de acceder al primer nodo, que una lista vacía
 * rechaza toda posición y que {@code obtener} no cambia el estado. También
 * se explicó por qué no existe acceso directo como en un arreglo: cada nodo
 * solo conoce al siguiente.</p>
 *
 * @param <T> tipo de elementos almacenados
 */
// DECISION: se implementa una clase genérica sin paquete — Motivo: la carpeta estaba vacía y no definía una convención de paquetes.
public class ListaEnlazada<T> {
    private Nodo<T> primero;
    private int size;

    // DECISION: se incluyen agregar y size como soporte mínimo — Motivo: permiten construir y verificar una lista sin alterar el contrato de obtener.
    /**
     * Agrega un elemento al final.
     *
     * @param elemento elemento que se agregará; puede ser {@code null}
     */
    public void agregar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    /**
     * Obtiene un elemento mediante una posición base cero.
     *
     * <p>Una lista enlazada no puede calcular la dirección del nodo como un
     * arreglo: cada nodo solo conserva el enlace al siguiente. Por eso se
     * recorre nodo por nodo desde el primero. La complejidad es {@code O(posicion)}
     * en tiempo y {@code O(1)} en memoria adicional.</p>
     *
     * <p>Una lista vacía rechaza cualquier posición; cero devuelve el primero;
     * {@code size - 1}, el último; y una posición negativa o mayor o igual que
     * {@code size} lanza la excepción indicada. La validación ocurre antes del
     * recorrido y la lista no se modifica.</p>
     *
     * @param posicion posición base cero
     * @return elemento de la posición
     * @throws IndexOutOfBoundsException si la posición es inválida
     */
    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                    "Posición fuera de rango: " + posicion + "; tamaño: " + size);
        }
        Nodo<T> actual = primero;
        for (int indice = 0; indice < posicion; indice++) {
            actual = actual.siguiente;
        }
        return actual.elemento;
    }

    /**
     * Devuelve el tamaño actual.
     *
     * @return cantidad de elementos
     */
    public int size() {
        return size;
    }

    private static final class Nodo<T> {
        private final T elemento;
        private Nodo<T> siguiente;

        private Nodo(T elemento) {
            this.elemento = elemento;
        }
    }
}
