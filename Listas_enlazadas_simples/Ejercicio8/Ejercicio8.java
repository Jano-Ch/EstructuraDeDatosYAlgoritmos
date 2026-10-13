/**
 * Ejercicio 8: operaciones mínimas sobre una lista simplemente enlazada.
 *
 * <p>Prompt inicial utilizado (prompt vago simulado): "Hacer el ejercicio 8
 * de listas enlazadas simples".</p>
 *
 * <p>Iteración con agente planificador: se precisó que la operación debía
 * implementar {@code int contarOcurrencias(int dato)}, recorrer la lista
 * completa, contar todas las coincidencias, devolver cero para una lista
 * vacía y no alterar los enlaces.</p>
 *
 * <p>Ajustes tras la primera respuesta de OpenCode: se mantuvo el recorrido
 * hasta {@code null} en lugar de retornar en la primera coincidencia; se
 * documentaron la complejidad lineal, los casos borde y la preservación de
 * enlaces.</p>
 *
 * // DECISION: se utiliza esta clase autocontenida y un nodo privado porque
 * // la carpeta no incluía un esqueleto ni un nombre de clase definido; así
 * // se implementa el ejercicio sin introducir dependencias externas.
 */
public class Ejercicio8 {

    private Nodo inicio;

    /**
     * Agrega un dato al final de la lista.
     *
     * @param dato valor que se agregará
     */
    public void agregarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
            return;
        }

        Nodo actual = inicio;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    /**
     * Cuenta todas las apariciones de un dato en la lista.
     *
     * <p>El recorrido debe continuar después de encontrar una coincidencia:
     * cortar en la primera devolvería presencia (o a lo sumo una coincidencia)
     * y no la cantidad solicitada. Para una lista vacía el primer nodo ya es
     * {@code null}, por lo que el resultado es cero. Este método solo lee los
     * nodos y no asigna ningún enlace, de modo que la estructura permanece
     * intacta.</p>
     *
     * <p>Complejidad temporal: O(n), donde n es la cantidad de nodos.
     * Complejidad espacial adicional: O(1).</p>
     *
     * @param dato valor cuyas apariciones se contarán
     * @return cantidad total de nodos cuyo valor coincide con {@code dato}
     */
    public int contarOcurrencias(int dato) {
        int ocurrencias = 0;
        Nodo actual = inicio;

        while (actual != null) {
            if (actual.dato == dato) {
                ocurrencias++;
            }
            actual = actual.siguiente;
        }

        return ocurrencias;
    }

    private static final class Nodo {
        private final int dato;
        private Nodo siguiente;

        private Nodo(int dato) {
            this.dato = dato;
        }
    }
}
