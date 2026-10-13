/**
 * Demostración del ejercicio 9: una cola de impresión enlazada FIFO.
 *
 * <p>Prompt inicial inventado completo: "Implementá en Java el ejercicio 9
 * sobre una cola de impresión usando una estructura enlazada propia. Cada
 * trabajo debe guardar el nombre del archivo, la cantidad de páginas y el
 * usuario. Permití agregar trabajos, imprimir y eliminar el próximo, consultar
 * solamente el nombre del próximo archivo y mostrar los pendientes sin
 * modificar la cola. Validá datos inválidos, explicá el orden FIFO y probá
 * cola vacía y varios trabajos."</p>
 *
 * <p>La impresora procesa FIFO porque cada solicitud debe respetar el orden
 * de llegada: el primer usuario que encola su trabajo es atendido primero y
 * ningún trabajo posterior puede adelantarse.</p>
 *
 * <p>Aclaración de la iteración posterior: con ayuda del planificador se
 * precisó que agregar, imprimir y consultar deben ser O(1), mostrar debe ser
 * O(n), la cola debe conservar referencias al primero y al último nodo, y la
 * validación exige archivo y usuario no vacíos y páginas mayores que cero.</p>
 */
public final class Main {
    private Main() {
    }

    /**
     * Ejecuta casos de cola vacía, validación, varios trabajos y orden FIFO.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        ColaImpresion cola = new ColaImpresion();

        System.out.println("=== Caso cola vacía ===");
        System.out.println(cola.mostrarPendientes());
        try {
            cola.consultarProximoArchivo();
        } catch (IllegalStateException excepcion) {
            System.out.println("Consulta vacía: " + excepcion.getMessage());
        }
        try {
            cola.imprimirProximo();
        } catch (IllegalStateException excepcion) {
            System.out.println("Impresión vacía: " + excepcion.getMessage());
        }

        System.out.println("\n=== Validación ===");
        probarDatoInvalido(null, 2, "Ana");
        probarDatoInvalido("informe.pdf", 0, "Ana");
        probarDatoInvalido("informe.pdf", 2, " ");

        cola.agregar(new TrabajoImpresion("primero.pdf", 3, "Ana"));
        cola.agregar(new TrabajoImpresion("segundo.docx", 1, "Luis"));
        cola.agregar(new TrabajoImpresion("tercero.txt", 5, "Marta"));

        System.out.println("\n=== Pendientes antes de imprimir ===");
        System.out.println(cola.mostrarPendientes());
        System.out.println("Próximo archivo: " + cola.consultarProximoArchivo());
        System.out.println("Pendientes después de consultar (sin modificar):");
        System.out.println(cola.mostrarPendientes());

        System.out.println("\n=== Procesamiento FIFO ===");
        while (!cola.estaVacia()) {
            System.out.println("Imprimiendo: " + cola.imprimirProximo());
        }
        System.out.println("Cola al finalizar: " + cola.mostrarPendientes());
    }

    private static void probarDatoInvalido(String archivo, int paginas, String usuario) {
        try {
            new TrabajoImpresion(archivo, paginas, usuario);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validación correcta: " + excepcion.getMessage());
        }
    }
}
