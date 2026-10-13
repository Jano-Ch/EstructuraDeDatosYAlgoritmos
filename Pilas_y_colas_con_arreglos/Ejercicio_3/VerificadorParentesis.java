/*
 * Prompt inicial basado en el plan:
 * "Implementar en Java un programa que valide únicamente paréntesis redondos
 * usando un arreglo como pila; cada ')' debe hacer pop de una apertura o
 * producir un resultado inválido, y al terminar la pila debe estar vacía.
 * Incluir ejemplos ejecutables, comentarios, Javadoc y el análisis de casos."
 *
 * Refinamiento iterativo de una especificación vaga:
 * La frase "validar una expresión" se precisó en pasos observables: ignorar
 * todo carácter que no sea '(' o ')', hacer push al encontrar '(', hacer pop
 * al encontrar ')' y rechazar inmediatamente si no existe una apertura. La
 * condición final se fijó como "pila vacía", lo que permite detectar también
 * aperturas pendientes. De este modo, la solución no intenta validar otros
 * tipos de delimitadores ni la sintaxis completa de la expresión.
 *
 * Complejidad y casos:
 * - Tiempo: O(n), porque cada carácter se visita una sola vez.
 * - Espacio: O(n) en el peor caso, por el arreglo de aperturas.
 * - Se contemplan expresión vacía, ausencia de paréntesis, cierres sin
 *   apertura, aperturas pendientes, expresiones balanceadas y otros
 *   caracteres intercalados.
 *
 * Prueba de ejecución (salida esperada resumida):
 * - "(a + b) * (c)"       -> válido
 * - "a + b)"              -> inválido: cierre sin apertura
 * - "((a)"                -> inválido: apertura pendiente
 */

/**
 * Demuestra y encapsula la validación de paréntesis redondos mediante una pila
 * implementada con un arreglo.
 */
public class VerificadorParentesis {

    /**
     * Valida únicamente el balance de los paréntesis redondos de una expresión.
     *
     * <p>Los caracteres distintos de {@code '('} y {@code ')'} se ignoran.
     * Cada apertura se apila y cada cierre desapila la apertura más reciente.
     * Un cierre sin apertura disponible invalida la expresión; después de
     * recorrerla, una pila no vacía indica aperturas pendientes.</p>
     *
     * @param expresion expresión cuyos paréntesis se desean validar
     * @return {@code true} si los paréntesis están balanceados; {@code false}
     *         si hay un cierre sin apertura o una apertura pendiente
     */
    public static boolean esValida(String expresion) {
        // DECISION: una expresión null se considera inválida — Motivo: evita
        // tratar la ausencia de entrada como una expresión correctamente balanceada.
        if (expresion == null) {
            return false;
        }

        char[] pila = new char[expresion.length()];
        int cima = 0;

        for (int indice = 0; indice < expresion.length(); indice++) {
            char caracter = expresion.charAt(indice);

            if (caracter == '(') {
                // PUSH: se guarda la apertura para recordar que aún debe cerrarse.
                pila[cima] = caracter;
                cima++;
            } else if (caracter == ')') {
                if (cima == 0) {
                    // No hay una apertura que pueda corresponder a este cierre.
                    return false;
                }

                // POP: se elimina la apertura más reciente de la pila.
                cima--;
            }
            // Los demás caracteres no modifican la pila.
        }

        // Si quedan elementos, son aperturas que no encontraron su cierre.
        return cima == 0;
    }

    /**
     * Ejecuta ejemplos válidos e inválidos y explica la operación de la pila.
     *
     * @param args argumentos de línea de comandos; no son necesarios
     */
    public static void main(String[] args) {
        String[] ejemplos = {
            "(a + b) * (c)",
            "a + b)",
            "((a)",
            "sin parentesis + 2"
        };

        System.out.println("Validador de parentesis redondos");
        System.out.println("Cada '(' hace PUSH y cada ')' hace POP.");
        System.out.println("Los demas caracteres se ignoran.");

        for (String ejemplo : ejemplos) {
            System.out.printf("\"%s\" -> %s%n",
                    ejemplo, esValida(ejemplo) ? "valido" : "invalido");
        }
    }
}
