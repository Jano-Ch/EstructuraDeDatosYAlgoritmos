/**
 * Cola enlazada FIFO para administrar la fila de clientes de un banco.
 *
 * <p>La cola se representa mediante nodos enlazados y dos referencias:
 * {@code frente} apunta al próximo cliente a atender y {@code finalCola}
 * apunta al último cliente agregado. Cada nodo apunta al siguiente en orden
 * de llegada. Por eso agregar y atender se ejecutan en O(1), mientras que
 * recorrer para imprimir cuesta O(n) y el espacio utilizado es O(n).</p>
 */
public class ColaBancaria {
    private Nodo frente;
    private Nodo finalCola;
    private int cantidad;

    /**
     * Agrega un cliente al final de la fila.
     *
     * @param cliente cliente que ingresa a la fila
     * @throws IllegalArgumentException si {@code cliente} es {@code null}
     */
    public void agregarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("No se puede agregar un cliente nulo.");
        }

        Nodo nuevo = new Nodo(cliente);
        if (finalCola == null) {
            frente = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.siguiente = nuevo;
            finalCola = nuevo;
        }
        cantidad++;
    }

    /**
     * Atiende y retira al próximo cliente de la fila.
     *
     * @return el cliente del frente, o {@code null} si la cola está vacía
     */
    public Cliente atenderProximo() {
        if (frente == null) {
            return null;
        }

        Cliente atendido = frente.cliente;
        frente = frente.siguiente;
        cantidad--;
        if (frente == null) {
            finalCola = null;
        }
        return atendido;
    }

    /**
     * Consulta sin retirar quién será atendido próximo.
     *
     * @return cliente del frente, o {@code null} si la cola está vacía
     */
    public Cliente consultarQuienSigue() {
        return frente == null ? null : frente.cliente;
    }

    /**
     * Imprime la fila completa desde el frente hasta el final.
     *
     * <p>El orden mostrado es el orden de llegada y no se reordena por turno.</p>
     */
    public void imprimirFila() {
        Nodo actual = frente;
        if (actual == null) {
            System.out.println("Fila vacía.");
            return;
        }

        while (actual != null) {
            System.out.println(actual.cliente);
            actual = actual.siguiente;
        }
    }

    /**
     * @return cantidad de clientes actualmente en la fila
     */
    public int getCantidad() {
        return cantidad;
    }

    private static final class Nodo {
        private final Cliente cliente;
        private Nodo siguiente;

        private Nodo(Cliente cliente) {
            this.cliente = cliente;
        }
    }
}
