/**
 * Demostración ejecutable del Ejercicio 3.
 *
 * <p>Prompt inicial inventado: "Implementá una estructura con nodos propios,
 * explicá su estructura, elección de pila, funcionamiento, operaciones,
 * casos límite y complejidad. Mostrá ejemplos con Integer, String y un objeto
 * propio". Iteración posterior: con ayuda del planificador se aclaró que la
 * pila debía ser genérica, que {@code pop}/{@code peek} devuelven
 * {@code null} en vacío, que {@code buscar} devuelve boolean y que se debían
 * ofrecer los nombres en español y sus alias usuales en inglés.</p>
 *
 * <p>Se eligió una pila porque su política LIFO resulta natural cuando el
 * último elemento agregado debe procesarse primero. Cada nodo guarda un valor
 * y una referencia al siguiente nodo. Las operaciones sobre el tope son
 * {@code O(1)}; buscar e imprimir recorren hasta {@code n} nodos y son
 * {@code O(n)}. El espacio total es {@code O(n)}.</p>
 */
public final class Ejercicio3 {
    private Ejercicio3() {
        // Clase de demostración: no se instancia.
    }

    /**
     * Ejecuta demostraciones de las operaciones y de los casos límite.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        demostrarEnteros();
        demostrarCadenas();
        demostrarObjetoPropio();
        demostrarPilaVacia();
    }

    private static void demostrarEnteros() {
        // DECISION: se incluyen nombres en español y alias en inglés — Motivo:
        // el plan solicita una convención clara y ambos nombres son habituales.
        Pila<Integer> pila = new Pila<>();
        pila.push(10);
        pila.apilar(20);
        pila.apilar(30);
        System.out.println("Integer (tope a base):");
        pila.imprimir();
        System.out.println("peek: " + pila.peek());
        System.out.println("buscar 20: " + pila.buscar(20));
        System.out.println("pop: " + pila.pop());
        System.out.println("tope luego de pop: " + pila.tope());
    }

    private static void demostrarCadenas() {
        Pila<String> pila = new Pila<>();
        pila.apilar("uno");
        pila.apilar("dos");
        System.out.println("\nString (tope a base):");
        pila.imprimir();
        System.out.println("buscar 'tres': " + pila.buscar("tres"));
    }

    private static void demostrarObjetoPropio() {
        Pila<Persona> pila = new Pila<>();
        pila.apilar(new Persona("Ana", 20));
        pila.apilar(new Persona("Luis", 22));
        System.out.println("\nObjeto propio (tope a base):");
        pila.imprimir();
        System.out.println("buscar Ana: " + pila.buscar(new Persona("Ana", 20)));
    }

    private static void demostrarPilaVacia() {
        Pila<Integer> pila = new Pila<>();
        System.out.println("\nPila vacía:");
        System.out.println("estaVacia: " + pila.estaVacia());
        System.out.println("peek vacío: " + pila.peek());
        System.out.println("pop vacío: " + pila.pop());
    }
}
