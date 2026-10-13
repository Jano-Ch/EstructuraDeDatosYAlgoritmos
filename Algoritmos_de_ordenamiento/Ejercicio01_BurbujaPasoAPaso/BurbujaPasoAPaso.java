/*
 * Resolución:
 * Se ordena un arreglo de números enteros mediante Bubble Sort y se imprime
 * el arreglo original junto con el estado del arreglo después de cada pasada.
 *
 * Estrategia:
 * En cada pasada se comparan elementos contiguos y se intercambian cuando
 * están en el orden incorrecto. Al finalizar una pasada, el elemento mayor
 * que todavía no estaba ubicado recorre el arreglo hacia la derecha mediante
 * intercambios sucesivos y queda en su posición definitiva. Por eso, en la
 * siguiente pasada no es necesario revisar esa última posición.
 *
 * Complejidad temporal:
 * - Mejor caso: O(n), cuando el arreglo ya está ordenado y se usa la bandera
 *   de intercambio para detenerse tempranamente.
 * - Peor caso: O(n^2), cuando el arreglo está ordenado en sentido inverso.
 * - Caso promedio: O(n^2).
 * Complejidad espacial: O(1) de espacio auxiliar, porque se ordena en el
 * mismo arreglo.
 */
public class BurbujaPasoAPaso {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        int[] numeros = {5, 1, 4, 2, 8};

        System.out.println("Arreglo original: " + arregloComoTexto(numeros));
        ordenarYMostrarPasadas(numeros);
        System.out.println("Arreglo ordenado: " + arregloComoTexto(numeros));
    }

    /**
     * Ordena el arreglo ascendentemente y muestra su estado después de cada
     * pasada completa.
     *
     * @param numeros arreglo de enteros que se modificará en el lugar
     */
    public static void ordenarYMostrarPasadas(int[] numeros) {
        for (int ultimaPosicion = numeros.length - 1;
                ultimaPosicion > 0;
                ultimaPosicion--) {
            boolean huboIntercambio = false;

            for (int posicion = 0; posicion < ultimaPosicion; posicion++) {
                if (numeros[posicion] > numeros[posicion + 1]) {
                    intercambiar(numeros, posicion, posicion + 1);
                    huboIntercambio = true;
                }
            }

            System.out.println("Después de la pasada "
                    + (numeros.length - ultimaPosicion) + ": "
                    + arregloComoTexto(numeros));

            if (!huboIntercambio) {
                break;
            }
        }
    }

    /**
     * Intercambia dos posiciones de un arreglo.
     *
     * @param numeros arreglo cuyos elementos se intercambiarán
     * @param primeraPosicion índice del primer elemento
     * @param segundaPosicion índice del segundo elemento
     */
    public static void intercambiar(
            int[] numeros, int primeraPosicion, int segundaPosicion) {
        int temporal = numeros[primeraPosicion];
        numeros[primeraPosicion] = numeros[segundaPosicion];
        numeros[segundaPosicion] = temporal;
    }

    /**
     * Convierte un arreglo en una representación legible.
     *
     * @param numeros arreglo que se representará
     * @return elementos del arreglo separados por comas y encerrados entre
     *         corchetes
     */
    public static String arregloComoTexto(int[] numeros) {
        StringBuilder resultado = new StringBuilder("[");

        for (int posicion = 0; posicion < numeros.length; posicion++) {
            if (posicion > 0) {
                resultado.append(", ");
            }
            resultado.append(numeros[posicion]);
        }

        return resultado.append("]").toString();
    }
}
