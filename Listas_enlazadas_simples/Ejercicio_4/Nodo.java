/**
 * Nodo de una lista simplemente enlazada de enteros.
 */
public class Nodo {

    private final int dato;
    private Nodo siguiente;

    /**
     * Crea un nodo sin sucesor.
     *
     * @param dato valor almacenado
     */
    public Nodo(int dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el valor almacenado.
     *
     * @return dato del nodo
     */
    public int getDato() {
        return dato;
    }

    /**
     * Obtiene el nodo siguiente.
     *
     * @return sucesor o {@code null} si es el último
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el sucesor del nodo.
     *
     * @param siguiente nuevo sucesor
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
