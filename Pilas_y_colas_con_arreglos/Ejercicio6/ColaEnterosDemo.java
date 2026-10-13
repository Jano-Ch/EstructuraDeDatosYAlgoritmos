/*
 * Prompt inicial: demostrar una ColaEnteros circular de capacidad fija,
 * incluyendo sus operaciones y la reutilización de posiciones liberadas.
 *
 * Refinamiento iterativo: la demostración se amplió desde una secuencia FIFO
 * básica a una secuencia que llena la cola, desencola dos elementos y vuelve a
 * encolar para verificar el retorno circular de rear al comienzo del arreglo.
 *
 * Complejidad y casos: cada operación demostrada es O(1). También se verifican
 * los errores de capacidad inválida, cola llena y cola vacía.
 *
 * Prueba de ejecución: compilar con javac *.java y ejecutar con
 * java ColaEnterosDemo.
 */

/**
 * Programa demostrativo de {@link ColaEnteros}.
 */
public class ColaEnterosDemo {

    // DECISION: usar una clase demo separada — Motivo: mantiene ColaEnteros
    // reutilizable y deja la prueba de ejecución explícita.
    /**
     * Ejecuta una demostración de FIFO, estados y reutilización circular.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        ColaEnteros cola = new ColaEnteros(3);

        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        System.out.println("Cola llena: " + cola.isFull());
        System.out.println("Frente: " + cola.front() + ", tamaño: " + cola.size());

        try {
            cola.enqueue(40);
        } catch (IllegalStateException exception) {
            System.out.println("Caso llena: " + exception.getMessage());
        }

        System.out.println("Sale: " + cola.dequeue());
        System.out.println("Sale: " + cola.dequeue());

        // rear ya pasó por el final y estas inserciones reutilizan las posiciones.
        cola.enqueue(40);
        cola.enqueue(50);
        System.out.println("Tras reutilizar posiciones, frente: " + cola.front()
                + ", tamaño: " + cola.size());
        System.out.println("Orden FIFO: " + cola.dequeue() + ", " + cola.dequeue()
                + ", " + cola.dequeue());
        System.out.println("Cola vacía: " + cola.isEmpty());

        try {
            cola.front();
        } catch (IllegalStateException exception) {
            System.out.println("Caso vacía: " + exception.getMessage());
        }

        try {
            new ColaEnteros(0);
        } catch (IllegalArgumentException exception) {
            System.out.println("Caso capacidad inválida: " + exception.getMessage());
        }
    }
}
