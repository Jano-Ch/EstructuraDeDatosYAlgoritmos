/**
 * Programa de demostración del ejercicio de cola enlazada.
 *
 * <p>Prompt inicial inventado: "Diseñá una estructura para administrar
 * enteros en orden de llegada. Elegí una cola FIFO, explicá su funcionamiento
 * y resolvé encolar, desencolar, consultar el frente, comprobar si está vacía,
 * buscar e imprimir. Considerá cola vacía, negativos, cero y duplicados, e
 * indicá la complejidad temporal y espacial de cada operación."</p>
 *
 * <p>Iteración posterior con ayuda del planificador: "Implementá la cola con
 * nodos propios y referencias al frente (head) y al final (tail), devolvé
 * {@code null} al desencolar o consultar el frente de una cola vacía, usá
 * {@code boolean} para buscar, documentá por qué se necesitan ambas
 * referencias y agregá Javadoc público. Encolar, desencolar, frente y
 * estaVacia deben ser O(1); buscar e imprimir, O(n); el espacio, O(n)."</p>
 */
public class Main {
    /**
     * Ejecuta una demostración que cubre los casos normales y los casos límite.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        ColaEnlazada cola = new ColaEnlazada();

        exigir(cola.estaVacia(), "La cola debe comenzar vacía");
        exigir(cola.frente() == null, "El frente de una cola vacía debe ser null");
        exigir(cola.desencolar() == null,
                "Desencolar una cola vacía debe devolver null");

        // DECISION: se usa el nombre ColaEnlazada y el paquete predeterminado —
        // Motivo: la carpeta estaba vacía y no definía una convención de nombres
        // ni de paquetes para reutilizar.
        cola.encolar(-7);
        cola.encolar(0);
        cola.encolar(4);
        cola.encolar(4);

        exigir(Integer.valueOf(-7).equals(cola.frente()),
                "El frente debe conservar el primer elemento");
        exigir(cola.buscar(-7), "Debe encontrar un negativo");
        exigir(cola.buscar(0), "Debe encontrar cero");
        exigir(cola.buscar(4), "Debe encontrar duplicados");
        exigir(!cola.buscar(99), "No debe encontrar un valor ausente");

        System.out.print("Cola: ");
        cola.imprimir();
        exigir(Integer.valueOf(-7).equals(cola.desencolar()),
                "La cola debe desencolar en orden FIFO");
        exigir(Integer.valueOf(0).equals(cola.desencolar()),
                "La cola debe conservar el orden FIFO");
        exigir(Integer.valueOf(4).equals(cola.desencolar()),
                "Debe devolver el primer 4");
        exigir(Integer.valueOf(4).equals(cola.desencolar()),
                "Debe devolver el segundo 4");
        exigir(cola.estaVacia(), "La cola debe quedar vacía");
        exigir(cola.desencolar() == null,
                "Desencolar después de vaciar debe devolver null");
        exigir(cola.frente() == null,
                "El frente después de vaciar debe ser null");

        System.out.println("Demostración completada correctamente.");
    }

    private static void exigir(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}
