/*
 * Prompt inicial: implementar una cola circular con arreglo de capacidad fija,
 * reutilizar los espacios iniciales liberados, mover front/rear con %, distinguir
 * llena y vacía, y demostrar enqueues, dequeues, reutilización y límites.
 *
 * Refinamiento iterativo:
 * 1) Se definieron front, rear y size para separar la posición de lectura de la
 *    próxima posición de escritura y evitar ambigüedad entre llena y vacía.
 * 2) Se agregó el avance modular con % en cada enqueue y dequeue, de modo que
 *    los índices vuelvan al comienzo del arreglo.
 * 3) Se incorporaron validaciones de capacidad y operaciones en los límites,
 *    seguidas por una demostración ejecutable con aserciones.
 *
 * Complejidad y casos:
 * - enqueue, dequeue, peek, isEmpty, isFull y size son O(1).
 * - La memoria usada por la cola es O(capacidad).
 * - Una cola vacía rechaza dequeue/peek; una cola llena rechaza enqueue.
 * - La capacidad cero o negativa se rechaza al construir la cola.
 *
 * Prueba de ejecución esperada:
 *   enqueue(A), enqueue(B), dequeue() -> A, enqueue(C), enqueue(D),
 *   dequeue() -> B, dequeue() -> C, dequeue() -> D; luego se verifican
 *   los límites de cola llena y cola vacía.
 */

import java.util.NoSuchElementException;

/**
 * Cola FIFO circular de capacidad fija implementada sobre un arreglo.
 *
 * @param <E> tipo de elemento almacenado
 */
public class ColaCircular<E> {

    private final Object[] elementos;
    private int front;
    private int rear;
    private int size;

    /**
     * Crea una cola vacía con la capacidad indicada.
     *
     * @param capacidad cantidad máxima de elementos
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public ColaCircular(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
        }
        elementos = new Object[capacidad];
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param elemento elemento que se agregará
     * @throws IllegalStateException si la cola está llena
     */
    public void enqueue(E elemento) {
        if (isFull()) {
            throw new IllegalStateException("No se puede hacer enqueue: la cola está llena.");
        }

        elementos[rear] = elemento;
        rear = (rear + 1) % elementos.length;
        size++;
    }

    /**
     * Quita y devuelve el elemento más antiguo de la cola.
     *
     * @return elemento quitado
     * @throws NoSuchElementException si la cola está vacía
     */
    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("No se puede hacer dequeue: la cola está vacía.");
        }

        E elemento = (E) elementos[front];
        elementos[front] = null;
        front = (front + 1) % elementos.length;
        size--;
        return elemento;
    }

    /**
     * Devuelve el elemento más antiguo sin quitarlo.
     *
     * @return elemento ubicado al frente
     * @throws NoSuchElementException si la cola está vacía
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("No se puede hacer peek: la cola está vacía.");
        }
        return (E) elementos[front];
    }

    /**
     * Indica si la cola no contiene elementos.
     *
     * @return true cuando no hay elementos
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Indica si la cola alcanzó su capacidad máxima.
     *
     * @return true cuando no queda espacio disponible
     */
    public boolean isFull() {
        return size == elementos.length;
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
     * Devuelve la capacidad máxima de esta cola.
     *
     * @return capacidad fija
     */
    public int capacity() {
        return elementos.length;
    }

    /**
     * Ejecuta una demostración de operaciones normales, wrap-around y límites.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        ColaCircular<String> cola = new ColaCircular<>(3);

        cola.enqueue("A");
        cola.enqueue("B");
        System.out.println("dequeue() -> " + cola.dequeue());

        // rear vuelve al índice 0: este espacio liberado se reutiliza.
        cola.enqueue("C");
        cola.enqueue("D");
        System.out.println("Cola llena: " + cola.isFull());
        System.out.println("dequeue() -> " + cola.dequeue());
        System.out.println("dequeue() -> " + cola.dequeue());
        System.out.println("dequeue() -> " + cola.dequeue());
        System.out.println("Cola vacía: " + cola.isEmpty());

        verificarLimites();
        System.out.println("Prueba de límites: OK");
    }

    /**
     * Comprueba los errores definidos para construcción, cola llena y vacía.
     */
    private static void verificarLimites() {
        boolean capacidadRechazada = false;
        try {
            new ColaCircular<Integer>(0);
        } catch (IllegalArgumentException exception) {
            capacidadRechazada = true;
        }
        assert capacidadRechazada : "Debe rechazarse una capacidad no positiva.";

        ColaCircular<Integer> cola = new ColaCircular<>(2);
        cola.enqueue(1);
        cola.enqueue(2);

        boolean llenaRechazada = false;
        try {
            cola.enqueue(3);
        } catch (IllegalStateException exception) {
            llenaRechazada = true;
        }
        assert llenaRechazada : "Debe rechazarse enqueue cuando la cola está llena.";

        cola.dequeue();
        cola.dequeue();

        boolean vaciaRechazada = false;
        try {
            cola.dequeue();
        } catch (NoSuchElementException exception) {
            vaciaRechazada = true;
        }
        assert vaciaRechazada : "Debe rechazarse dequeue cuando la cola está vacía.";
    }
}
