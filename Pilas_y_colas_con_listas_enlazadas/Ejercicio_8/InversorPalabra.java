/**
 * Invierte una cadena utilizando una pila enlazada implementada en este
 * ejercicio.
 *
 * <p>Prompt inicial inventado: diseñar una solución con una estructura
 * enlazada, elegir una pila por su comportamiento LIFO, explicar su
 * funcionamiento y sus operaciones {@code push} y {@code pop}, contemplar
 * cadenas normales, vacías y con mayúsculas, acentos o símbolos, e indicar
 * complejidad temporal y espacial. La solución fue iterada posteriormente
 * con ayuda del planificador para confirmar el recorrido de izquierda a
 * derecha y la implementación de la pila propia.</p>
 *
 * <p>LIFO significa "último en entrar, primero en salir". Por eso, al
 * insertar los caracteres de izquierda a derecha y retirarlos con {@code
 * pop}, el último carácter insertado es el primero de la cadena invertida.</p>
 *
 * <p>La operación completa utiliza O(n) tiempo y O(n) espacio adicional.</p>
 */
public final class InversorPalabra {

    private InversorPalabra() {
        // Esta clase solo ofrece una operación estática.
    }

    /**
     * Devuelve la cadena recibida en orden inverso.
     *
     * @param palabra cadena que se desea invertir; no puede ser {@code null}
     * @return la cadena invertida, o una cadena vacía si la entrada es vacía
     * @throws IllegalArgumentException si {@code palabra} es {@code null}
     */
    public static String invertir(String palabra) {
        if (palabra == null) {
            // DECISION: rechazar null con un mensaje explícito — Motivo: el plan define cadenas, no una referencia inexistente.
            throw new IllegalArgumentException("La palabra no puede ser null.");
        }

        PilaEnlazada pila = new PilaEnlazada();
        for (int indice = 0; indice < palabra.length(); indice++) {
            pila.push(palabra.charAt(indice));
        }

        StringBuilder invertida = new StringBuilder(palabra.length());
        while (!pila.estaVacia()) {
            invertida.append(pila.pop());
        }
        return invertida.toString();
    }

    /**
     * Pila mínima, enlazada y de uso exclusivo para este algoritmo.
     */
    private static final class PilaEnlazada {
        private Nodo cima;

        /**
         * Inserta un carácter en la cima de la pila.
         *
         * @param caracter carácter que se agrega
         */
        private void push(char caracter) {
            cima = new Nodo(caracter, cima);
        }

        /**
         * Retira y devuelve el carácter ubicado en la cima.
         *
         * @return carácter retirado
         * @throws IllegalStateException si la pila está vacía
         */
        private char pop() {
            if (estaVacia()) {
                throw new IllegalStateException("No se puede hacer pop de una pila vacía.");
            }
            char caracter = cima.valor;
            cima = cima.siguiente;
            return caracter;
        }

        /**
         * Indica si no quedan elementos en la pila.
         *
         * @return {@code true} cuando la pila está vacía
         */
        private boolean estaVacia() {
            return cima == null;
        }
    }

    /**
     * Nodo simple de la pila enlazada.
     */
    private static final class Nodo {
        private final char valor;
        private final Nodo siguiente;

        private Nodo(char valor, Nodo siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
        }
    }
}
