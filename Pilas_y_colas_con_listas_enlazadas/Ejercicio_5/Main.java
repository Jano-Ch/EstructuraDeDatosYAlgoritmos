/**
 * Demostración del historial de navegación y de sus casos límite.
 */
public class Main {
    /**
     * Ejecuta casos normales, páginas duplicadas, entradas inválidas y
     * operaciones realizadas cuando el historial está vacío.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        HistorialNavegacion historial = new HistorialNavegacion();

        System.out.println("=== Operaciones con historial vacío ===");
        System.out.println(historial.actual());
        System.out.println(historial.volver());
        System.out.println(historial.imprimir());

        System.out.println("\n=== Navegación normal ===");
        System.out.println(historial.visitar("https://inicio.example"));
        System.out.println(historial.visitar("https://busqueda.example"));
        System.out.println(historial.visitar("https://articulo.example"));
        System.out.println(historial.visitar("https://busqueda.example"));
        System.out.println("Actual: " + historial.actual());
        System.out.println("Historial: " + historial.imprimir());

        System.out.println("\n=== Entradas inválidas ===");
        System.out.println(historial.visitar(null));
        System.out.println(historial.visitar(""));
        System.out.println(historial.visitar("   "));

        System.out.println("\n=== Volver ===");
        System.out.println(historial.volver());
        System.out.println("Actual: " + historial.actual());
        System.out.println(historial.imprimir());
        System.out.println(historial.volver());
        System.out.println(historial.volver());
        System.out.println(historial.volver());
        System.out.println(historial.volver());
        System.out.println(historial.imprimir());
    }
}
