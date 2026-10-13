/**
 * Demostración ejecutable del simulador de torre de platos.
 *
 * <p>Una pila aplica LIFO (último en entrar, primero en salir): el último
 * plato agregado queda arriba y es el primero que se retira. Una cola aplica
 * FIFO (primero en entrar, primero en salir), por lo que no modelaría
 * correctamente una torre en la que solo se puede tomar el plato superior.</p>
 */
public class Ejercicio2 {

    /**
     * Ejecuta una demostración con datos numéricos y nombres, además de probar
     * los estados lleno y vacío.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        // DECISION: se usa Java LTS disponible (25) y no se agrega configuración de build — Motivo: el proyecto no define versión ni herramienta de compilación para este ejercicio.
        PilaDePlatos torre = new PilaDePlatos(4);

        System.out.println("=== Torre de platos (pila LIFO) ===");
        torre.agregar("Plato 1");
        torre.agregar("Plato 2");
        torre.agregar("Azul");
        torre.agregar("42");
        System.out.println("Superior consultado: " + torre.consultarSuperior());

        try {
            torre.agregar("99");
        } catch (IllegalStateException e) {
            System.out.println("Prueba de pila llena: " + e.getMessage());
        }

        System.out.println("Orden de retiro (LIFO):");
        while (!torre.estaVacia()) {
            System.out.println("- " + torre.retirarSuperior());
        }

        try {
            torre.retirarSuperior();
        } catch (IllegalStateException e) {
            System.out.println("Prueba de pila vacía: " + e.getMessage());
        }

        System.out.println("La consulta superior también preserva la torre: "
                + "se consultó antes de retirar y los platos salieron en orden inverso.");
    }
}
