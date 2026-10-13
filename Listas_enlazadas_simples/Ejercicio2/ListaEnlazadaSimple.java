/**
 * Lista enlazada simple de enteros para el Ejercicio 2.
 *
 * <p>Una lista enlazada simple no ofrece acceso directo por índice: para llegar
 * al elemento de una posición hay que seguir los enlaces desde {@code head}.
 * Por el mismo motivo, {@link #buscar(int)} realiza una búsqueda secuencial,
 * deteniéndose al encontrar el dato o al llegar a {@code null}.</p>
 *
 * <p>Complejidad: agregar al frente es O(1) y buscar es O(n) en el peor caso
 * y O(1) si la coincidencia está en el primer nodo. El espacio adicional de
 * buscar es O(1). En una lista vacía, buscar devuelve {@code false}; los
 * valores repetidos se consideran encontrados si aparece cualquiera de ellos.</p>
 *
 * <p>Prompt inicial utilizado (simulando un prompt vago):</p>
 * <blockquote>
 * Implementa el ejercicio 2 de listas enlazadas simples en Java y pruébalo.
 * </blockquote>
 *
 * <p>Iteración posterior con agente planificador:</p>
 * <blockquote>
 * Implementar una lista enlazada simple de enteros con
 * {@code boolean buscar(int dato)}, recorriendo desde {@code head} hasta la
 * coincidencia o {@code null}; agregar únicamente las operaciones locales
 * mínimas necesarias para probar y documentar complejidad y casos.
 * </blockquote>
 *
 * <p>Ajustes tras la primera respuesta de OpenCode: limitar el alcance
 * exclusivamente a este Ejercicio 2, evitar README y agregar una prueba
 * ejecutable local que cubra lista vacía, coincidencias y ausencia.</p>
 */
// DECISION: mantener el paquete por defecto — Motivo: el ejercicio es autónomo
// y así puede compilarse localmente sin suponer una convención externa.
public class ListaEnlazadaSimple {
    /**
     * Nodo inicial de la lista. Es {@code null} cuando la lista está vacía.
     */
    private Nodo head;

    /**
     * Agrega un dato al comienzo de la lista.
     *
     * @param dato entero que se incorporará
     */
    public void agregarAlInicio(int dato) {
        // DECISION: ofrecer solo inserción al inicio — Motivo: es la operación mínima
        // local necesaria para construir casos de prueba sin ampliar el ejercicio.
        head = new Nodo(dato, head);
    }

    /**
     * Busca secuencialmente un dato desde {@code head}.
     *
     * @param dato entero buscado
     * @return {@code true} si algún nodo contiene el dato; {@code false} si no
     */
    public boolean buscar(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Nodo privado que enlaza un entero con el siguiente nodo.
     */
    private static final class Nodo {
        private final int dato;
        private final Nodo siguiente;

        private Nodo(int dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }
}
