/*
 * Prompt inicial (basado en el plan): implementar un simulador de historial
 * de navegación con una pila de URLs en un arreglo de capacidad fija. Visitar
 * debe apilar una URL, volver debe desapilarla y dejar disponible la anterior,
 * y debe ser posible consultar/mostrar el historial, informando URL vacía,
 * historial lleno e historial vacío, con una demostración ejecutable.
 *
 * La especificación vaga se ajustó iterativamente: se decidió conservar en la
 * pila la URL actual como elemento superior, mostrar desde la más reciente a
 * la más antigua y comunicar los errores mediante excepciones explícitas.
 *
 * Complejidad: visitar y volver son O(1); consultarHistorial y mostrar son
 * O(n), donde n es la cantidad de URLs almacenadas. Casos considerados:
 * historial vacío, historial lleno y URL nula o vacía.
 *
 * Prueba de ejecución con ejemplos: la demostración visita
 * https://inicio.test, https://productos.test y https://detalle.test;
 * luego vuelve a productos y también prueba URL vacía, historial lleno y
 * volver con historial vacío.
 */

/**
 * Demostración ejecutable del simulador de historial de navegación.
 */
public class Main {

    /**
     * Ejecuta ejemplos normales y los casos límite definidos para el ejercicio.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        HistorialNavegacion historial = new HistorialNavegacion(3);

        System.out.println("=== Historial de navegación ===");
        historial.visitar("https://inicio.test");
        historial.visitar("https://productos.test");
        historial.visitar("https://detalle.test");
        historial.mostrarHistorial();

        intentar("visitar con historial lleno",
                () -> historial.visitar("https://otra.test"));

        System.out.println("\nVolver: " + historial.volver());
        System.out.println("URL actual: " + historial.consultarActual());
        historial.mostrarHistorial();

        System.out.println("\n=== Casos límite ===");
        intentar("visitar una URL vacía",
                () -> historial.visitar("   "));

        HistorialNavegacion vacio = new HistorialNavegacion(2);
        intentar("volver con historial vacío", vacio::volver);
        System.out.println("Consulta de historial vacío: "
                + vacio.consultarHistorial());
    }

    private static void intentar(String caso, Accion accion) {
        try {
            accion.ejecutar();
        } catch (IllegalArgumentException | IllegalStateException error) {
            System.out.println(caso + " -> " + error.getMessage());
        }
    }

    @FunctionalInterface
    private interface Accion {
        void ejecutar();
    }
}

/**
 * Simula un historial de navegación mediante una pila implementada con un
 * arreglo de capacidad fija.
 */
class HistorialNavegacion {
    // Una pila usa LIFO porque al volver se debe quitar primero la página
    // visitada más recientemente y revelar inmediatamente la anterior.
    // DECISION: conservar la URL actual dentro de la pila — Motivo: así volver
    // se implementa directamente con pop y la cima representa la página actual.
    private final String[] urls;
    private int cantidad;

    /**
     * Construye un historial con capacidad fija.
     *
     * @param capacidad cantidad máxima de URLs permitidas
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public HistorialNavegacion(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero.");
        }
        urls = new String[capacidad];
    }

    /**
     * Visita una URL y la coloca en la cima de la pila.
     *
     * @param url URL que se desea visitar
     * @throws IllegalArgumentException si la URL es nula o está vacía
     * @throws IllegalStateException si el historial ya está lleno
     */
    public void visitar(String url) {
        validarUrl(url);
        if (estaLleno()) {
            throw new IllegalStateException(
                    "No se puede visitar: el historial está lleno.");
        }
        // DECISION: quitar espacios exteriores de la URL — Motivo: tratar una
        // entrada con espacios accidentales como la misma URL limpia.
        urls[cantidad] = url.trim();
        cantidad++;
    }

    /**
     * Retrocede a la URL anterior desapilando la URL actual.
     *
     * @return URL que queda como actual después de volver
     * @throws IllegalStateException si no hay URL para desapilar
     */
    public String volver() {
        if (estaVacio()) {
            throw new IllegalStateException(
                    "No se puede volver: el historial está vacío.");
        }
        urls[cantidad - 1] = null;
        cantidad--;
        return consultarActual();
    }

    /**
     * Obtiene la URL que está actualmente en la cima de la pila.
     *
     * @return URL actual, o un mensaje explícito si no existe
     */
    public String consultarActual() {
        return estaVacio() ? "(sin URL actual)" : urls[cantidad - 1];
    }

    /**
     * Devuelve el historial desde la URL más reciente hasta la más antigua.
     *
     * @return representación del historial, o un mensaje si está vacío
     */
    public String consultarHistorial() {
        if (estaVacio()) {
            return "(historial vacío)";
        }

        StringBuilder resultado = new StringBuilder();
        for (int indice = cantidad - 1; indice >= 0; indice--) {
            resultado.append(urls[indice]);
            if (indice > 0) {
                resultado.append(System.lineSeparator());
            }
        }
        return resultado.toString();
    }

    /**
     * Muestra por consola el historial, de la URL más reciente a la antigua.
     */
    public void mostrarHistorial() {
        System.out.println(consultarHistorial());
    }

    /**
     * Indica si no hay URLs almacenadas.
     *
     * @return true cuando la pila no contiene URLs
     */
    public boolean estaVacio() {
        return cantidad == 0;
    }

    /**
     * Indica si se alcanzó la capacidad fija.
     *
     * @return true cuando no queda espacio en el arreglo
     */
    public boolean estaLleno() {
        return cantidad == urls.length;
    }

    private void validarUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La URL no puede ser nula ni estar vacía.");
        }
    }
}
