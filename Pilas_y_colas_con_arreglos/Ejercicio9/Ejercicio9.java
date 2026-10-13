/*
 * Prompt inicial (basado en el plan): implementar una cola simple no circular
 * con un arreglo de capacidad fija, realizar varios enqueue/dequeue y mostrar
 * el desperdicio de espacio cuando quedan posiciones libres al comienzo.
 *
 * Refinamiento iterativo:
 * 1) Se definieron los índices frente y fin para modelar una cola FIFO.
 * 2) Se agregó la visualización del arreglo después de cada operación para
 *    hacer visible el espacio desperdiciado.
 * 3) Se incorporaron IllegalStateException para los casos llena y vacía, y
 *    una demostración ejecutable que recorre los casos normales y de error.
 *
 * Complejidad y casos:
 * - enqueue y dequeue son O(1), igual que mostrar el estado por la capacidad
 *   fija de este ejemplo (la visualización recorre el arreglo).
 * - La capacidad es fija: al alcanzar el fin físico del arreglo, enqueue
 *   falla aunque haya posiciones libres antes del frente.
 * - dequeue sobre una cola vacía y enqueue sobre una cola llena lanzan
 *   IllegalStateException.
 *
 * Prueba de ejecución esperada:
 * enqueue(10), enqueue(20), enqueue(30), dequeue(), dequeue(), enqueue(40) y
 * enqueue(50) dejan [_, _, 30, 40, 50]. Luego enqueue(60) informa que la cola
 * está llena aunque los dos primeros espacios estén libres. Finalmente,
 * dequeue() hasta vaciarla muestra el caso vacío.
 */

/**
 * Demuestra el funcionamiento y el desperdicio de espacio de una cola simple
 * no circular implementada con un arreglo de capacidad fija.
 */
public class Ejercicio9 {

    /**
     * Ejecuta una secuencia de operaciones normales y los casos de error
     * acordados para la demostración.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        // DECISION: usar capacidad 5 — Motivo: permite mostrar dos posiciones
        // libres al inicio y alcanzar el límite físico con pocos ejemplos.
        ColaSimpleArreglo cola = new ColaSimpleArreglo(5);

        System.out.println("=== Cola simple no circular ===");
        System.out.println("El arreglo no reutiliza posiciones liberadas al inicio.");
        cola.mostrarEstado("estado inicial");

        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.desencolar();
        cola.desencolar();
        cola.encolar(40);
        cola.encolar(50);

        System.out.println();
        System.out.println("Se liberaron las posiciones 0 y 1, pero el fin llegó al "
                + "límite físico del arreglo.");
        cola.mostrarEstado("antes de intentar encolar 60");

        try {
            cola.encolar(60);
        } catch (IllegalStateException exception) {
            System.out.println("Error de cola llena: " + exception.getMessage());
        }

        System.out.println();
        System.out.println("Vaciado de la cola:");
        while (!cola.estaVacia()) {
            cola.desencolar();
        }
        cola.mostrarEstado("después de vaciar");

        try {
            cola.desencolar();
        } catch (IllegalStateException exception) {
            System.out.println("Error de cola vacía: " + exception.getMessage());
        }
    }

    /**
     * Cola FIFO que avanza siempre hacia la derecha y no vuelve al inicio.
     */
    private static final class ColaSimpleArreglo {
        private final Integer[] elementos;
        private int frente;
        private int fin;

        /**
         * Crea una cola con capacidad fija.
         *
         * @param capacidad cantidad de posiciones disponibles
         * @throws IllegalArgumentException si la capacidad no es positiva
         */
        private ColaSimpleArreglo(int capacidad) {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser positiva.");
            }
            elementos = new Integer[capacidad];
        }

        /**
         * Agrega un elemento al final físico del arreglo.
         *
         * @param elemento valor que se agrega
         * @throws IllegalStateException si el fin alcanzó la capacidad
         */
        private void encolar(int elemento) {
            if (fin == elementos.length) {
                throw new IllegalStateException(
                        "No hay espacio al final; las posiciones iniciales no se reutilizan.");
            }
            elementos[fin] = elemento;
            fin++;
            mostrarEstado("enqueue(" + elemento + ")");
        }

        /**
         * Retira y devuelve el elemento situado en el frente.
         *
         * @return elemento retirado
         * @throws IllegalStateException si la cola está vacía
         */
        private int desencolar() {
            if (estaVacia()) {
                throw new IllegalStateException("La cola está vacía.");
            }
            int elemento = elementos[frente];
            elementos[frente] = null;
            frente++;
            mostrarEstado("dequeue() -> " + elemento);
            return elemento;
        }

        /**
         * Indica si no quedan elementos para retirar.
         *
         * @return {@code true} cuando la cola está vacía
         */
        private boolean estaVacia() {
            return frente == fin;
        }

        /**
         * Imprime todas las posiciones y los índices relevantes de la cola.
         *
         * @param operacion descripción de la operación recién realizada
         */
        private void mostrarEstado(String operacion) {
            System.out.print(operacion + " | arreglo: [");
            for (int indice = 0; indice < elementos.length; indice++) {
                if (indice > 0) {
                    System.out.print(", ");
                }
                System.out.print(elementos[indice] == null ? "_" : elementos[indice]);
            }
            System.out.println("] | frente=" + frente + ", fin=" + fin);
        }
    }
}
