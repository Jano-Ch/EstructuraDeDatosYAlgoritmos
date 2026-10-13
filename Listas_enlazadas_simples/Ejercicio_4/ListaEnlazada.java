/**
 * Lista simplemente enlazada para el Ejercicio 4.
 *
 * <p>Prompt inicial utilizado (prompt vago simulado):
 * {@code "Hacer el ejercicio 4 de listas enlazadas simples."}</p>
 *
 * <p>Iteración con agente planificador: se precisaron posiciones base cero,
 * el rango válido {@code 0..size}, la inclusión de la lista vacía y la
 * excepción requerida. Ajustes tras la primera respuesta de OpenCode:
 * se adaptó la solución a clases locales, se dejó el método con retorno
 * {@code void} y se incorporaron pruebas para inicio, medio, final e índices
 * inválidos.</p>
 */
// DECISION: usar la carpeta existente Ejercicio_4 — Motivo: la ruta solicitada
// Ejercicio4 no existe y el repositorio usa el nombre con guion bajo.
public class ListaEnlazada {

    private Nodo primero;
    private int tamanio;

    /**
     * Inserta un dato en una posición base cero.
     *
     * <p>Casos contemplados: posición {@code 0} para insertar al inicio
     * (también cuando la lista está vacía), posición {@code size} para
     * insertar al final y cualquier posición intermedia. Las posiciones
     * menores que cero o mayores que {@code size} lanzan
     * {@link IndexOutOfBoundsException}; la lista no se modifica en esos
     * casos.</p>
     *
     * <p>Complejidad temporal: O(n) en el peor caso por recorrer hasta la
     * posición anterior. Complejidad espacial adicional: O(1), sin contar el
     * nodo nuevo.</p>
     *
     * <p>En una inserción intermedia, el orden de estas dos instrucciones es
     * esencial y debe conservarse exactamente:</p>
     *
     * <pre>
     * nuevo.setSiguiente(actual.getSiguiente());
     * actual.setSiguiente(nuevo);
     * </pre>
     *
     * <p>Si se invierte el orden, se pierde la referencia al resto de la
     * lista (o se enlaza incorrectamente el nodo nuevo), rompiendo la cadena
     * de nodos.</p>
     *
     * @param dato dato que se agregará
     * @param posicion índice base cero donde se insertará
     * @throws IndexOutOfBoundsException si la posición no pertenece a
     *         {@code 0..size}
     */
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > tamanio) {
            throw new IndexOutOfBoundsException(
                    "Posición inválida: " + posicion
                            + ". Rango válido: 0.." + tamanio);
        }

        Nodo nuevo = new Nodo(dato);
        if (posicion == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {
            Nodo actual = primero;
            for (int i = 1; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
        tamanio++;
    }

    /**
     * Devuelve la cantidad actual de elementos.
     *
     * @return tamaño de la lista
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Devuelve una representación de los datos en orden.
     *
     * @return datos separados por {@code " -> "}
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo actual = primero;
        while (actual != null) {
            if (resultado.length() > 0) {
                resultado.append(" -> ");
            }
            resultado.append(actual.getDato());
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }
}
