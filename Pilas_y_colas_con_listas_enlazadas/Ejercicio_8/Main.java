/**
 * Demostración ejecutable del Ejercicio 8.
 */
public final class Main {

    private Main() {
        // Evita instanciaciones innecesarias.
    }

    /**
     * Ejecuta los casos normales y especiales del ejercicio.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        mostrarResultado("algoritmo");
        mostrarResultado("");
        mostrarResultado("Árbol");
        mostrarResultado("¡Hola, señor!");
        mostrarResultado("A1#b");
    }

    private static void mostrarResultado(String palabra) {
        System.out.println("\"" + palabra + "\" -> \"" + InversorPalabra.invertir(palabra) + "\"");
    }
}
