/**
 * Demostración reproducible de una cola de impresión FIFO.
 */
public final class Main {
    private Main() {
        // Clase de demostración: no se instancia.
    }

    /**
     * Encola documentos, los imprime en orden de llegada y verifica casos
     * normales y límites de una cola de capacidad fija.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        ColaImpresion<Documento> cola = new ColaImpresion<>(3);
        Documento informe = new Documento("informe.pdf", 12);
        Documento diapositivas = new Documento("diapositivas.pptx", 8);
        Documento resumen = new Documento("resumen.txt", 3);

        System.out.println("=== Cola de impresión FIFO ===");
        cola.encolar(informe);
        cola.encolar(diapositivas);
        cola.encolar(resumen);
        System.out.println("Documentos encolados: " + cola.tamanio());

        // FIFO garantiza que se imprime informe, luego diapositivas y finalmente resumen.
        imprimirYVerificar(cola, informe);
        imprimirYVerificar(cola, diapositivas);

        // Este encolado demuestra que el arreglo circular reutiliza el espacio liberado.
        Documento contrato = new Documento("contrato.docx", 5);
        cola.encolar(contrato);
        imprimirYVerificar(cola, resumen);
        imprimirYVerificar(cola, contrato);

        verificarColaVacia(cola);
        verificarColaLlena();
        System.out.println("Prueba completada correctamente.");
    }

    private static void imprimirYVerificar(
            ColaImpresion<Documento> cola, Documento esperado) {
        Documento impreso = cola.imprimir();
        if (impreso != esperado) {
            throw new AssertionError("Se imprimió un documento fuera de orden.");
        }
        System.out.println("Imprimiendo: " + impreso);
    }

    private static void verificarColaVacia(ColaImpresion<Documento> cola) {
        try {
            cola.imprimir();
            throw new AssertionError("La cola vacía debería rechazar la impresión.");
        } catch (java.util.NoSuchElementException esperado) {
            System.out.println("Caso cola vacía: " + esperado.getMessage());
        }
    }

    private static void verificarColaLlena() {
        ColaImpresion<Documento> cola = new ColaImpresion<>(1);
        cola.encolar(new Documento("unico.pdf", 1));
        try {
            cola.encolar(new Documento("extra.pdf", 1));
            throw new AssertionError("La cola llena debería rechazar otro documento.");
        } catch (IllegalStateException esperado) {
            System.out.println("Caso cola llena: " + esperado.getMessage());
        }
    }
}
