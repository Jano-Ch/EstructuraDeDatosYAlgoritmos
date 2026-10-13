/**
 * Prompt inicial y demostración de una cola genérica con cadenas y clientes.
 *
 * <p>Prompt inicial: Implementá en Java el Ejercicio 4 dentro de esta carpeta.
 * Diseñá una cola enlazada genérica {@code Cola<T>} con nodos propios y
 * referencias {@code head/frente} y {@code tail/final}. La demostración debe
 * usar {@code Cola<String>} con nombres y {@code Cola<Cliente>} con objetos
 * {@code Cliente}, manteniendo FIFO sin depender del tipo concreto.</p>
 *
 * <p>Incluí las operaciones {@code encolar}, {@code desencolar},
 * {@code frente}, {@code estaVacia} y las operaciones de recorrido necesarias
 * ({@code buscar} e {@code imprimir}). Para una extracción o consulta sobre
 * una cola vacía devolvé {@code null}. Contemplá el primer y el último
 * elemento, valores repetidos y la cola vacía.</p>
 *
 * <p>Documentá el funcionamiento, la elección de FIFO, las operaciones, los
 * casos considerados y las complejidades: {@code encolar},
 * {@code desencolar} y {@code frente} en {@code O(1)}, recorridos en
 * {@code O(n)} y espacio {@code O(n)}. La iteración y las decisiones de
 * diseño se realizan con ayuda del planificador. Agregá Javadoc a la API
 * pública y no incluyas un README.</p>
 */
public class Main {
    /**
     * Ejecuta los ejemplos y verifica los casos principales de la cola.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        demostrarNombres();
        demostrarClientes();
        verificarCasosLimite();
    }

    private static void demostrarNombres() {
        Cola<String> nombres = new Cola<>();
        nombres.encolar("Ana");
        nombres.encolar("Bruno");
        nombres.encolar("Ana");

        System.out.println("Cola de nombres:");
        nombres.imprimir();
        System.out.println("Frente: " + nombres.frente());
        System.out.println("¿Está Bruno?: " + nombres.buscar("Bruno"));
        System.out.println("Sale: " + nombres.desencolar());
        System.out.println("Cola luego de desencolar:");
        nombres.imprimir();
    }

    private static void demostrarClientes() {
        Cola<Cliente> clientes = new Cola<>();
        Cliente cliente1 = new Cliente(1, "Carla");
        Cliente cliente2 = new Cliente(2, "Diego");
        clientes.encolar(cliente1);
        clientes.encolar(cliente2);

        System.out.println("\nCola de clientes:");
        clientes.imprimir();
        System.out.println("Frente: " + clientes.frente());
        System.out.println("¿Está Diego?: " + clientes.buscar(new Cliente(2, "Diego")));
        System.out.println("Sale: " + clientes.desencolar());
        System.out.println("Sale: " + clientes.desencolar());
    }

    private static void verificarCasosLimite() {
        Cola<String> cola = new Cola<>();
        if (!cola.estaVacia() || cola.desencolar() != null || cola.frente() != null) {
            throw new AssertionError("La cola vacía debe devolver null y estar vacía");
        }

        cola.encolar("único");
        if (!"único".equals(cola.frente()) || !"único".equals(cola.desencolar())
                || !cola.estaVacia()) {
            throw new AssertionError("El caso de un único elemento no conserva FIFO");
        }

        cola.encolar(null);
        cola.encolar("último");
        if (!cola.buscar(null) || cola.desencolar() != null
                || !"último".equals(cola.desencolar())) {
            throw new AssertionError("No se manejó correctamente el valor null o el último elemento");
        }
        System.out.println("\nCasos límite verificados: cola vacía, primer/último, repetidos y null.");
    }
}
