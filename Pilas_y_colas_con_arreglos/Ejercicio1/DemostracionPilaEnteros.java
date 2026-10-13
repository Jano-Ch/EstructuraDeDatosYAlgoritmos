/**
 * Demostración ejecutable de {@link PilaEnteros}, incluyendo límites y errores.
 *
 * <p>Prompt inicial: implementar una pila de enteros con arreglo de capacidad
 * fija recibida por constructor, {@code top} inicial en -1, operaciones
 * {@code push}, {@code pop}, {@code peek}, {@code isEmpty}, {@code isFull} y
 * {@code size}, y una demostración de sus límites.</p>
 *
 * <p>La especificación vaga se ajustó iterativamente con el planificador:
 * capacidad inválida significa capacidad menor o igual que cero; una pila
 * llena o vacía produce {@link IllegalStateException} en la operación que no
 * puede realizarse. La prueba usa los datos 10, 20 y 30 para evidenciar el
 * comportamiento LIFO y todos los estados.</p>
 *
 * <p>La demostración recorre operaciones O(1) y documenta el resultado de
 * cada caso mediante la salida estándar.</p>
 */
public class DemostracionPilaEnteros {

    /**
     * Ejecuta la demostración de la pila.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        // DECISION: se usa el paquete por defecto — Motivo: el ejercicio no
        // define paquetes y así puede compilarse directamente con javac.
        System.out.println("=== Demostración de PilaEnteros ===");

        PilaEnteros pila = new PilaEnteros(3);
        mostrarEstado("Inicial", pila);

        pila.push(10);
        pila.push(20);
        pila.push(30);
        mostrarEstado("Después de push(10), push(20), push(30)", pila);
        System.out.println("peek() = " + pila.peek() + " (la cima no se quita)");

        intentar("push(40) con la pila llena", new Accion() {
            @Override
            public void ejecutar() {
                pila.push(40);
            }
        });

        System.out.println("pop() = " + pila.pop());
        System.out.println("pop() = " + pila.pop());
        System.out.println("pop() = " + pila.pop());
        mostrarEstado("Después de quitar todos los elementos", pila);

        intentar("peek() con la pila vacía", new Accion() {
            @Override
            public void ejecutar() {
                pila.peek();
            }
        });
        intentar("pop() con la pila vacía", new Accion() {
            @Override
            public void ejecutar() {
                pila.pop();
            }
        });
        intentar("new PilaEnteros(0)", new Accion() {
            @Override
            public void ejecutar() {
                new PilaEnteros(0);
            }
        });
    }

    private static void mostrarEstado(String descripcion, PilaEnteros pila) {
        System.out.println(descripcion + ": isEmpty()=" + pila.isEmpty()
                + ", isFull()=" + pila.isFull() + ", size()=" + pila.size());
    }

    private static void intentar(String descripcion, Accion accion) {
        try {
            accion.ejecutar();
            System.out.println("ERROR: " + descripcion + " no produjo excepción.");
        } catch (IllegalArgumentException | IllegalStateException error) {
            System.out.println(descripcion + " -> "
                    + error.getClass().getSimpleName() + ": " + error.getMessage());
        }
    }

    private interface Accion {
        void ejecutar();
    }
}
