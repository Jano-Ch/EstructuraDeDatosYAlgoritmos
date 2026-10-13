/**
 * Historial de navegación implementado con una pila enlazada propia.
 *
 * <p>Prompt inicial inventado: "Diseñá en Java un historial de navegación
 * para una aplicación que permita visitar URLs, volver a la página anterior,
 * consultar la página actual e imprimir todo el recorrido desde la página
 * actual hasta la más antigua. La estructura debe ser una pila enlazada
 * creada sin colecciones de la biblioteca y debe informar entradas inválidas
 * o acciones realizadas con el historial vacío."</p>
 *
 * <p>Iteración posterior con ayuda del planificador: se confirmó que las
 * páginas duplicadas son válidas, que visitar, volver y consultar deben ser
 * O(1), que imprimir debe ser O(n), y que las operaciones sobre un historial
 * vacío deben resolverse sin lanzar errores.</p>
 *
 * <p>La política LIFO representa naturalmente "volver atrás": la última
 * página visitada es la primera que debe quitarse cuando se vuelve, por lo
 * que queda disponible inmediatamente la página visitada antes de ella.</p>
 */
public class HistorialNavegacion {
    private Nodo cima;
    private int cantidad;

    /*
     * DECISION: se considera válida una página no nula y con contenido no
     * blanco; se conserva el texto original para no alterar la URL informada.
     * Motivo: el plan exige rechazar null/vacío, pero no define normalización.
     */

    /**
     * Agrega una página en la cima del historial.
     *
     * @param pagina URL o nombre de la página a visitar
     * @return mensaje que indica si la página fue agregada o rechazada
     */
    public String visitar(String pagina) {
        if (!esValida(pagina)) {
            return "No se puede visitar una página nula o vacía.";
        }

        cima = new Nodo(pagina, cima);
        cantidad++;
        return "Página visitada: " + pagina;
    }

    /**
     * Vuelve desde la página actual a la anterior, desapilando la actual.
     *
     * @return mensaje con la página quitada o información de historial vacío
     */
    public String volver() {
        if (cima == null) {
            return "No se puede volver: el historial está vacío.";
        }

        String paginaQuitada = cima.pagina;
        cima = cima.siguiente;
        cantidad--;
        return "Se volvió desde: " + paginaQuitada;
    }

    /**
     * Obtiene la página que se encuentra actualmente en la cima.
     *
     * @return la página actual, o {@code null} si no hay historial
     */
    public String actual() {
        return cima == null ? null : cima.pagina;
    }

    /**
     * Construye una representación del historial desde la página actual
     * hacia la más antigua.
     *
     * @return páginas separadas por {@code " -> "}, o un mensaje si está vacío
     */
    public String imprimir() {
        if (cima == null) {
            return "El historial está vacío.";
        }

        StringBuilder resultado = new StringBuilder();
        Nodo nodo = cima;
        while (nodo != null) {
            if (resultado.length() > 0) {
                resultado.append(" -> ");
            }
            resultado.append(nodo.pagina);
            nodo = nodo.siguiente;
        }
        return resultado.toString();
    }

    /**
     * Indica cuántas páginas conserva el historial.
     *
     * @return cantidad de páginas almacenadas
     */
    public int tamanio() {
        return cantidad;
    }

    private boolean esValida(String pagina) {
        return pagina != null && !pagina.trim().isEmpty();
    }

    private static class Nodo {
        private final String pagina;
        private final Nodo siguiente;

        private Nodo(String pagina, Nodo siguiente) {
            this.pagina = pagina;
            this.siguiente = siguiente;
        }
    }
}
