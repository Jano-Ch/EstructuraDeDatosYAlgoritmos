/*
 * Prompt inicial: implementar una cola de enteros con arreglo circular de
 * capacidad fija, incluyendo enqueue, dequeue, front, isEmpty, isFull y size,
 * y demostrar la reutilización de posiciones liberadas.
 *
 * Refinamiento iterativo: se comenzó con la representación de una cola lineal
 * y se refinó a un arreglo circular para reutilizar el espacio sin desplazar
 * elementos. Luego se fijó la convención solicitada: front apunta al primer
 * elemento y rear a la próxima posición libre. Finalmente se agregaron las
 * validaciones de capacidad y de operaciones sobre colas llena o vacía.
 *
 * Complejidad y casos: construir la cola, consultar estado, insertar y quitar
 * elementos son operaciones O(1); size también es O(1). La capacidad inválida
 * produce IllegalArgumentException, mientras que enqueue sobre una cola llena
 * y dequeue/front sobre una cola vacía producen IllegalStateException.
 *
 * Prueba de ejecución: ColaEnterosDemo llena la cola, quita elementos, agrega
 * nuevos valores en las posiciones liberadas y muestra los índices circulares.
 */

/**
 * Cola FIFO de enteros respaldada por un arreglo circular de capacidad fija.
 *
 * <p>{@code front} es el índice del primer elemento disponible y {@code rear}
 * es el índice de la próxima posición libre. Cuando uno de los índices llega
 * al final del arreglo, vuelve a cero.</p>
 */
public class ColaEnteros {
    private final int[] elementos;
    private int front;
    private int rear;
    // DECISION: conservar la cantidad de elementos — Motivo: permite distinguir
    // de forma O(1) una cola vacía de una llena sin reservar una posición.
    private int cantidad;

    /**
     * Crea una cola vacía con la capacidad indicada.
     *
     * @param capacidad cantidad máxima de elementos que puede contener
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public ColaEnteros(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
        }
        elementos = new int[capacidad];
    }

    /**
     * Agrega un entero al final de la cola.
     *
     * @param elemento valor que se agregará
     * @throws IllegalStateException si la cola está llena
     */
    public void enqueue(int elemento) {
        if (isFull()) {
            throw new IllegalStateException("No se puede encolar: la cola está llena.");
        }

        elementos[rear] = elemento;
        rear = siguienteIndice(rear);
        cantidad++;
    }

    /**
     * Quita y devuelve el primer elemento de la cola.
     *
     * @return el elemento que estaba al frente
     * @throws IllegalStateException si la cola está vacía
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede desencolar: la cola está vacía.");
        }

        int elemento = elementos[front];
        front = siguienteIndice(front);
        cantidad--;
        return elemento;
    }

    /**
     * Devuelve el primer elemento sin quitarlo.
     *
     * @return el elemento que está al frente
     * @throws IllegalStateException si la cola está vacía
     */
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede consultar el frente: la cola está vacía.");
        }
        return elementos[front];
    }

    /**
     * Indica si la cola no contiene elementos.
     *
     * @return {@code true} cuando no hay elementos
     */
    public boolean isEmpty() {
        return cantidad == 0;
    }

    /**
     * Indica si la cola alcanzó su capacidad máxima.
     *
     * @return {@code true} cuando no queda espacio libre
     */
    public boolean isFull() {
        return cantidad == elementos.length;
    }

    /**
     * Devuelve la cantidad actual de elementos.
     *
     * @return número de elementos almacenados
     */
    public int size() {
        return cantidad;
    }

    /**
     * Avanza un índice y lo envuelve al inicio cuando llega al final.
     */
    private int siguienteIndice(int indice) {
        return (indice + 1) % elementos.length;
    }
}
