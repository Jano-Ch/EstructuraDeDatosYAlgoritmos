/**
 * Prompt inicial (inventado):
 * <p>
 * Diseñar un verificador de paréntesis redondos. La estructura elegida es una
 * pila enlazada propia, porque los paréntesis abiertos deben resolverse en
 * orden LIFO. Se recorre la expresión de izquierda a derecha: cada '(' se
 * apila, cada ')' desapila y cualquier otro carácter se ignora. Un cierre sin
 * apertura correspondiente invalida la expresión y, al terminar, la pila debe
 * estar vacía. Las operaciones necesarias son apilar, desapilar y consultar si
 * la pila está vacía. La cadena {@code null} es inválida y la cadena vacía es
 * válida. La solución usa O(n) tiempo y O(n) espacio en el peor caso.
 * </p>
 *
 * <p>
 * Iteración: el planteo y los casos límite fueron revisados con ayuda del
 * planificador antes de implementar esta versión.
 * </p>
 */
public class VerificadorParentesis {

    /**
     * Indica si todos los paréntesis redondos de una expresión están
     * correctamente balanceados.
     *
     * @param expresion texto que se desea verificar
     * @return {@code false} para {@code null}, o si hay un cierre sin apertura
     *         o aperturas pendientes; {@code true} en los demás casos
     */
    public static boolean estaBalanceada(String expresion) {
        if (expresion == null) {
            return false;
        }

        PilaEnlazada pila = new PilaEnlazada();
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(') {
                pila.apilar();
            } else if (caracter == ')' && pila.estaVacia()) {
                return false;
            } else if (caracter == ')') {
                pila.desapilar();
            }
        }
        return pila.estaVacia();
    }

    /**
     * Ejecuta los casos válidos e inválidos definidos para el ejercicio.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        verificar("()", true);
        verificar("(())", true);
        verificar("a + (b * c) - ((d))", true);
        verificar("", true);

        verificar("(", false);
        verificar(")", false);
        verificar("(()", false);
        verificar("())(", false);
        verificar(null, false);

        System.out.println("Todas las pruebas del verificador fueron aprobadas.");
    }

    private static void verificar(String expresion, boolean resultadoEsperado) {
        boolean resultado = estaBalanceada(expresion);
        if (resultado != resultadoEsperado) {
            throw new AssertionError(
                    "Resultado inesperado para " + String.valueOf(expresion)
                            + ": se esperaba " + resultadoEsperado
                            + " y se obtuvo " + resultado);
        }
    }

    /**
     * Pila mínima enlazada, específica para registrar aperturas de paréntesis.
     */
    private static final class PilaEnlazada {
        private Nodo cima;

        private void apilar() {
            cima = new Nodo(cima);
        }

        private void desapilar() {
            cima = cima.siguiente;
        }

        private boolean estaVacia() {
            return cima == null;
        }
    }

    /**
     * Nodo de la pila enlazada.
     */
    private static final class Nodo {
        private final Nodo siguiente;

        private Nodo(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
