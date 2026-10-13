/**
 * Pila enlazada de enteros implementada con nodos propios.
 *
 * <p>Prompt inicial inventado: "Diseñá una estructura para almacenar enteros
 * que permita agregar y quitar elementos respetando el orden de llegada.
 * Explicá por qué conviene una pila, cómo funciona, qué operaciones ofrece,
 * cuáles son sus casos especiales y cuál es la complejidad temporal y
 * espacial. La estructura debe aceptar negativos, cero y valores duplicados.
 * Luego se iteró con ayuda del planificador para precisar la API y los casos
 * de pila vacía."</p>
 *
 * <p>Se eligió una pila porque sigue la política LIFO (el último elemento
 * apilado es el primero que se desapila). Cada nodo guarda un entero y una
 * referencia al nodo siguiente. {@code head} representa explícitamente el
 * tope de la pila: cuando la pila no está vacía, {@code head} apunta al nodo
 * que se devolverá primero.</p>
 *
 * <p>Apilar, desapilar, consultar el tope y consultar si está vacía son
 * operaciones O(1). Buscar e imprimir recorren los nodos y son O(n). El
 * espacio utilizado por la pila es O(n), donde n es la cantidad de elementos.
 * En una pila vacía, desapilar y tope devuelven {@code null}; buscar devuelve
 * {@code false}.</p>
 */
public class PilaEnlazada {

    /**
     * Nodo propio de la pila. No se expone para mantener encapsulada la
     * representación interna.
     */
    private static final class Nodo {
        private final int valor;
        private Nodo siguiente;

        private Nodo(int valor, Nodo siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
        }
    }

    private Nodo head;

    /**
     * Agrega un entero en el tope de la pila.
     *
     * @param valor entero que se desea apilar; se aceptan negativos y cero
     */
    public void apilar(int valor) {
        head = new Nodo(valor, head);
    }

    /**
     * Quita y devuelve el entero ubicado en el tope.
     *
     * @return el valor retirado, o {@code null} si la pila está vacía
     */
    public Integer desapilar() {
        if (estaVacia()) {
            return null;
        }

        int valor = head.valor;
        head = head.siguiente;
        return valor;
    }

    /**
     * Consulta el entero ubicado en el tope sin quitarlo.
     *
     * @return el valor del tope, o {@code null} si la pila está vacía
     */
    public Integer tope() {
        return estaVacia() ? null : head.valor;
    }

    /**
     * Indica si la pila no contiene elementos.
     *
     * @return {@code true} cuando no hay nodos; {@code false} en otro caso
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Busca un valor recorriendo la pila desde el tope.
     *
     * @param valor entero que se desea encontrar
     * @return {@code true} si existe al menos una coincidencia; {@code false}
     *         si no existe o la pila está vacía
     */
    public boolean buscar(int valor) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.valor == valor) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Imprime los valores desde el tope hasta la base, uno por línea.
     */
    public void imprimir() {
        // DECISION: imprimir un valor por línea, desde el tope a la base —
        // Motivo: el plan define la operación pero no su formato, y este formato
        // hace visible directamente el orden LIFO sin agregar dependencias.
        Nodo actual = head;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }
}
