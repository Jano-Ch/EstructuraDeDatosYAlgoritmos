/**
 * Cola enlazada propia para procesar trabajos de impresión en orden FIFO.
 *
 * <p>Conserva referencias al primer y al último nodo, por lo que agregar y
 * retirar el próximo trabajo se realizan en tiempo constante.</p>
 */
public final class ColaImpresion {
    private Nodo primero;
    private Nodo ultimo;
    private int cantidad;

    /**
     * Agrega un trabajo al final de la cola.
     *
     * @param trabajo trabajo que se agregará
     * @throws IllegalArgumentException si el trabajo es {@code null}
     * @implNote Tiene complejidad O(1) porque se inserta directamente después
     *           del último nodo.
     */
    public void agregar(TrabajoImpresion trabajo) {
        if (trabajo == null) {
            throw new IllegalArgumentException("No se puede agregar un trabajo nulo.");
        }

        Nodo nuevo = new Nodo(trabajo);
        if (ultimo == null) {
            primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        cantidad++;
    }

    /**
     * Imprime y elimina el trabajo más antiguo de la cola.
     *
     * @return el trabajo que se imprimió
     * @throws IllegalStateException si no hay trabajos pendientes
     * @implNote Tiene complejidad O(1) porque se retira el primer nodo.
     */
    public TrabajoImpresion imprimirProximo() {
        TrabajoImpresion trabajo = consultarProximoTrabajo();
        primero = primero.siguiente;
        cantidad--;
        if (primero == null) {
            ultimo = null;
        }
        return trabajo;
    }

    /**
     * Consulta solamente el nombre del archivo que se procesará próximo.
     *
     * @return nombre del próximo archivo
     * @throws IllegalStateException si no hay trabajos pendientes
     * @implNote Tiene complejidad O(1) porque consulta directamente el primer nodo.
     */
    public String consultarProximoArchivo() {
        return consultarProximoTrabajo().getNombreArchivo();
    }

    /**
     * Muestra los trabajos pendientes sin retirarlos ni cambiar su orden.
     *
     * @return texto con un trabajo por línea, o un mensaje si la cola está vacía
     */
    public String mostrarPendientes() {
        if (estaVacia()) {
            return "No hay trabajos pendientes.";
        }

        StringBuilder resultado = new StringBuilder();
        Nodo actual = primero;
        while (actual != null) {
            if (resultado.length() > 0) {
                resultado.append(System.lineSeparator());
            }
            resultado.append(actual.trabajo);
            actual = actual.siguiente;
        }
        return resultado.toString();
    }

    /**
     * @return {@code true} cuando no hay trabajos pendientes
     */
    public boolean estaVacia() {
        return primero == null;
    }

    /**
     * @return cantidad de trabajos pendientes
     */
    public int cantidad() {
        return cantidad;
    }

    private TrabajoImpresion consultarProximoTrabajo() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola de impresión está vacía.");
        }
        return primero.trabajo;
    }

    private static final class Nodo {
        private final TrabajoImpresion trabajo;
        private Nodo siguiente;

        private Nodo(TrabajoImpresion trabajo) {
            this.trabajo = trabajo;
        }
    }
}
