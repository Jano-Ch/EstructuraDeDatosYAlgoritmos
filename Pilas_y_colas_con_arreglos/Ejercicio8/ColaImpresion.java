/**
 * Cola FIFO de documentos implementada con un arreglo de capacidad fija.
 *
 * @param <T> tipo de elemento almacenado
 */
public final class ColaImpresion<T> {
    private final Object[] elementos;
    private int frente;
    private int fin;
    private int cantidad;

    /**
     * Crea una cola con la capacidad indicada.
     *
     * @param capacidad cantidad máxima de documentos
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public ColaImpresion(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
        }
        elementos = new Object[capacidad];
    }

    /**
     * Agrega un documento al final de la cola.
     *
     * <p>La cola es FIFO: el primer documento encolado será el primero
     * disponible para imprimir.</p>
     *
     * @param elemento documento que se agrega
     * @throws IllegalStateException si la cola está llena
     * @throws IllegalArgumentException si el elemento es nulo
     */
    public void encolar(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("No se puede encolar un documento nulo.");
        }
        if (estaLlena()) {
            throw new IllegalStateException("La cola de impresión está llena.");
        }
        elementos[fin] = elemento;
        fin = (fin + 1) % elementos.length;
        cantidad++;
    }

    /**
     * Quita y devuelve el documento más antiguo de la cola.
     *
     * @return el documento que estaba primero
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    @SuppressWarnings("unchecked")
    public T imprimir() {
        if (estaVacia()) {
            throw new java.util.NoSuchElementException(
                    "No hay documentos pendientes para imprimir.");
        }
        T elemento = (T) elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % elementos.length;
        cantidad--;
        return elemento;
    }

    /**
     * Indica si no hay documentos pendientes.
     *
     * @return true cuando la cola está vacía
     */
    public boolean estaVacia() {
        return cantidad == 0;
    }

    /**
     * Indica si se alcanzó la capacidad fija.
     *
     * @return true cuando no quedan posiciones disponibles
     */
    public boolean estaLlena() {
        return cantidad == elementos.length;
    }

    /**
     * Devuelve la cantidad de documentos pendientes.
     *
     * @return cantidad actual
     */
    public int tamanio() {
        return cantidad;
    }

    /**
     * Devuelve la capacidad máxima de la cola.
     *
     * @return capacidad fija
     */
    public int capacidad() {
        return elementos.length;
    }
}
