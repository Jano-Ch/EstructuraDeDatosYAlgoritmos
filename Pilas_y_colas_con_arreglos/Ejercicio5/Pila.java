/*
 * Prompt inicial: implementar una Pila<T> con un arreglo de capacidad fija,
 * compatible con Integer, String y objetos simples, con operaciones LIFO,
 * controles de pila llena/vacía, explicación de genéricos y una demostración.
 *
 * La especificación vaga se ajustó iterativamente con el planificador hasta
 * definir capacidad explícita, errores documentados y los casos de prueba.
 */

import java.util.NoSuchElementException;

// DECISION: usar el paquete predeterminado — Motivo: el ejercicio es autónomo y
// así puede compilarse directamente con javac desde su propia carpeta.
/**
 * Pila genérica de capacidad fija que almacena elementos en orden LIFO
 * (last in, first out).
 *
 * <p>El arreglo interno se reserva una sola vez y nunca se redimensiona.
 * Aunque el arreglo se declara como {@code Object[]}, los métodos públicos
 * exponen {@code T}; el parámetro genérico permite que el compilador controle
 * que cada pila se use con un tipo consistente. Esto es más reutilizable y
 * seguro que una pila que solamente acepte {@code int}.</p>
 *
 * <p>Complejidad: {@link #push(Object)}, {@link #pop()} y {@link #peek()}
 * son O(1), al igual que las consultas. El consumo de memoria es O(n), donde
 * {@code n} es la capacidad fija.</p>
 *
 * @param <T> tipo de elementos almacenados
 */
public class Pila<T> {
    private final Object[] elementos;
    private int cima;

    /**
     * Crea una pila vacía con la capacidad indicada.
     *
     * @param capacidad cantidad máxima de elementos
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public Pila(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad de la pila debe ser mayor que cero.");
        }
        this.elementos = new Object[capacidad];
        this.cima = 0;
    }

    /**
     * Agrega un elemento en la cima de la pila.
     *
     * @param elemento elemento que se agregará; {@code null} también es válido
     * @throws IllegalStateException si la pila está llena
     */
    public void push(T elemento) {
        if (isFull()) {
            throw new IllegalStateException(
                    "No se puede insertar: la pila está llena (capacidad "
                            + capacidad() + ").");
        }
        // DECISION: permitir null — Motivo: el plan exige tipos genéricos y no
        // define una restricción de nulidad; null sigue ocupando una posición.
        elementos[cima] = elemento;
        cima++;
    }

    /**
     * Quita y devuelve el elemento ubicado en la cima.
     *
     * @return elemento retirado
     * @throws NoSuchElementException si la pila está vacía
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "No se puede retirar: la pila está vacía.");
        }
        cima--;
        T elemento = (T) elementos[cima];
        elementos[cima] = null;
        return elemento;
    }

    /**
     * Devuelve el elemento de la cima sin quitarlo.
     *
     * @return elemento ubicado en la cima
     * @throws NoSuchElementException si la pila está vacía
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "No se puede consultar: la pila está vacía.");
        }
        return (T) elementos[cima - 1];
    }

    /**
     * Indica si no hay elementos almacenados.
     *
     * @return {@code true} cuando la pila está vacía
     */
    public boolean isEmpty() {
        return cima == 0;
    }

    /**
     * Indica si se alcanzó la capacidad fija.
     *
     * @return {@code true} cuando no quedan posiciones libres
     */
    public boolean isFull() {
        return cima == elementos.length;
    }

    /**
     * Devuelve la cantidad actual de elementos.
     *
     * @return número de elementos almacenados
     */
    public int size() {
        return cima;
    }

    /**
     * Devuelve la capacidad máxima de la pila.
     *
     * @return capacidad fija
     */
    public int capacidad() {
        return elementos.length;
    }
}
