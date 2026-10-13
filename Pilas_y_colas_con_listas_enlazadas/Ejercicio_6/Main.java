/**
 * Demostración de la cola bancaria con los casos vacío, único y varios.
 */
public class Main {
    /**
     * Ejecuta una demostración de las operaciones y sus casos límite.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        ColaBancaria cola = new ColaBancaria();

        System.out.println("=== Caso vacío ===");
        System.out.println("Consulta: " + cola.consultarQuienSigue());
        System.out.println("Atención: " + cola.atenderProximo());
        cola.imprimirFila();

        System.out.println("\n=== Caso único ===");
        Cliente unico = new Cliente("Ana", 1, "Depósito");
        cola.agregarCliente(unico);
        System.out.println("Sigue: " + cola.consultarQuienSigue());
        cola.imprimirFila();
        System.out.println("Atendido: " + cola.atenderProximo());
        System.out.println("Después de atender: " + cola.consultarQuienSigue());

        System.out.println("\n=== Caso varios y turnos duplicados ===");
        cola.agregarCliente(new Cliente("Bruno", 7, "Retiro"));
        cola.agregarCliente(new Cliente("Carla", 7, "Consulta"));
        cola.agregarCliente(new Cliente("Diego", 9, "Transferencia"));
        cola.imprimirFila();
        System.out.println("Sigue: " + cola.consultarQuienSigue());
        System.out.println("Atendido: " + cola.atenderProximo());
        System.out.println("Sigue: " + cola.consultarQuienSigue());
        System.out.println("Clientes restantes: " + cola.getCantidad());
    }
}
