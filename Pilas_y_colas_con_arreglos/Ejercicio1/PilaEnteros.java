/**
 * Pila de enteros implementada con un arreglo de capacidad fija.
 *
 * <p>La especificación inicial (crear una pila con arreglos) era vaga y se
 * ajustó iterativamente con el planificador hasta definir la capacidad
 * recibida por constructor, el valor inicial de {@code top} y los errores
 * esperados.</p>
 *
 * <p>La pila mantiene {@code top} en -1 cuando está vacía y en el índice del
 * elemento superior cuando contiene elementos. {@link #isEmpty()} informa el
 * estado vacío y {@link #isFull()} el estado lleno. {@link #push(int)} falla
 * con {@link IllegalStateException} si la pila está llena; {@link #pop()} y
 * {@link #peek()} fallan con esa excepción si está vacía.</p>
 *
 * <p>Complejidad: {@code push}, {@code pop}, {@code peek}, {@code isEmpty},
 * {@code isFull} y {@code size} son operaciones de tiempo O(1) y la memoria
 * utilizada es O(capacidad). La capacidad debe ser positiva; una capacidad
 * menor o igual que cero produce {@link IllegalArgumentException}.</p>
 */
public class PilaEnteros {
    private final int[] elementos;
    private int top;

    /**
     * Crea una pila vacía con la capacidad indicada.
     *
     * @param capacidad cantidad máxima de enteros que puede almacenar
     * @throws IllegalArgumentException si la capacidad es menor o igual que
     *         cero
     */
    public PilaEnteros(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        elementos = new int[capacidad];
        top = -1;
    }

    /**
     * Agrega un entero en la cima de la pila.
     *
     * @param valor entero que se agregará
     * @throws IllegalStateException si la pila está llena
     */
    public void push(int valor) {
        if (isFull()) {
            throw new IllegalStateException("No se puede hacer push: la pila está llena.");
        }
        elementos[++top] = valor;
    }

    /**
     * Quita y devuelve el entero ubicado en la cima.
     *
     * @return entero quitado
     * @throws IllegalStateException si la pila está vacía
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede hacer pop: la pila está vacía.");
        }
        return elementos[top--];
    }

    /**
     * Devuelve el entero de la cima sin quitarlo.
     *
     * @return entero ubicado en la cima
     * @throws IllegalStateException si la pila está vacía
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede hacer peek: la pila está vacía.");
        }
        return elementos[top];
    }

    /**
     * Indica si la pila no contiene elementos.
     *
     * @return {@code true} cuando {@code top} es -1
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Indica si la pila alcanzó su capacidad máxima.
     *
     * @return {@code true} cuando {@code top} es el último índice del arreglo
     */
    public boolean isFull() {
        return top == elementos.length - 1;
    }

    /**
     * Devuelve la cantidad actual de elementos.
     *
     * @return cantidad de elementos almacenados
     */
    public int size() {
        return top + 1;
    }
}
