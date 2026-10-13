/*
 * Resolución:
 * Bubble Sort compara vecinos consecutivos y los intercambia cuando están
 * invertidos; de ese modo, los valores mayores avanzan hacia el final.
 * Selection Sort recorre la parte no ordenada para buscar directamente el
 * menor y lo intercambia con la primera posición de esa parte. Por eso,
 * Bubble Sort puede realizar muchos intercambios pequeños entre vecinos,
 * mientras que Selection Sort hace como máximo un intercambio por posición,
 * aunque siempre busca el menor restante.
 *
 * Complejidad temporal:
 * - Bubble Sort: O(n) en el mejor caso con arreglo ordenado y O(n^2) en los
 *   casos promedio y peor.
 * - Selection Sort: O(n^2) en el mejor, promedio y peor caso.
 * Complejidad espacial: O(1) adicional para ambos algoritmos; los métodos
 * ordenan el mismo arreglo recibido, sin crear copias.
 *
 * Casos contemplados: arreglo vacío, arreglo de un elemento, arreglo ya
 * ordenado, arreglo invertido, valores repetidos y referencia null, que se
 * rechaza explícitamente.
 */

import java.util.Arrays;

// DECISION: se usa un record para las métricas — Motivo: el entorno no define
// versión de Java y el proyecto se ejecuta con una versión LTS moderna.

/**
 * Compara Bubble Sort y Selection Sort mediante sus comparaciones e
 * intercambios.
 */
public class Ejercicio02ComparacionBurbujaSeleccion {

    // DECISION: los métodos devuelven un objeto Metricas además de ordenar
    // in-place — Motivo: permite exponer comparaciones e intercambios sin
    // perder la firma solicitada bubbleSort(int[]) / selectionSort(int[]).

    /**
     * Ordena el arreglo recibido ascendentemente con Bubble Sort.
     *
     * <p>Cada comparación se realiza entre dos vecinos. Un intercambio se
     * cuenta únicamente cuando los vecinos están en orden incorrecto.</p>
     *
     * @param array arreglo que se ordenará en el mismo lugar
     * @return métricas de la ejecución
     * @throws IllegalArgumentException si {@code array} es {@code null}
     */
    public static Metricas bubbleSort(int[] array) {
        validarArray(array);
        long comparaciones = 0;
        long intercambios = 0;

        for (int limite = array.length - 1; limite > 0; limite--) {
            boolean huboIntercambio = false;

            for (int indice = 0; indice < limite; indice++) {
                comparaciones++;
                if (array[indice] > array[indice + 1]) {
                    intercambiar(array, indice, indice + 1);
                    intercambios++;
                    huboIntercambio = true;
                }
            }

            if (!huboIntercambio) {
                break;
            }
        }

        return new Metricas(comparaciones, intercambios);
    }

    /**
     * Ordena el arreglo recibido ascendentemente con Selection Sort.
     *
     * <p>Cada comparación se realiza al buscar el menor elemento de la parte
     * no ordenada. El intercambio se cuenta únicamente si el menor encontrado
     * no está ya en la posición correspondiente.</p>
     *
     * @param array arreglo que se ordenará en el mismo lugar
     * @return métricas de la ejecución
     * @throws IllegalArgumentException si {@code array} es {@code null}
     */
    public static Metricas selectionSort(int[] array) {
        validarArray(array);
        long comparaciones = 0;
        long intercambios = 0;

        for (int inicio = 0; inicio < array.length - 1; inicio++) {
            int indiceMenor = inicio;

            for (int indice = inicio + 1; indice < array.length; indice++) {
                comparaciones++;
                if (array[indice] < array[indiceMenor]) {
                    indiceMenor = indice;
                }
            }

            if (indiceMenor != inicio) {
                intercambiar(array, inicio, indiceMenor);
                intercambios++;
            }
        }

        return new Metricas(comparaciones, intercambios);
    }

    /**
     * Ejecuta una demostración con el mismo arreglo de entrada para ambos
     * algoritmos, usando copias para que cada uno reciba los mismos valores.
     *
     * @param args argumentos de la línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] entrada = {64, 25, 12, 22, 11, 25, 90, 1};
        // DECISION: se usan copias únicamente en la demostración — Motivo:
        // ambos algoritmos deben recibir los mismos datos, pero cada método
        // modifica el arreglo que recibe directamente.
        int[] arregloBubble = Arrays.copyOf(entrada, entrada.length);
        int[] arregloSelection = Arrays.copyOf(entrada, entrada.length);

        Metricas metricasBubble = bubbleSort(arregloBubble);
        Metricas metricasSelection = selectionSort(arregloSelection);

        System.out.println("Arreglo original: " + Arrays.toString(entrada));
        imprimirResultado("Bubble Sort", arregloBubble, metricasBubble);
        imprimirResultado("Selection Sort", arregloSelection, metricasSelection);
        System.out.println("\nDiferencia: Bubble Sort compara vecinos; "
                + "Selection Sort busca directamente el menor restante.");
    }

    private static void validarArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }
    }

    private static void intercambiar(int[] array, int primero, int segundo) {
        int temporal = array[primero];
        array[primero] = array[segundo];
        array[segundo] = temporal;
    }

    private static void imprimirResultado(
            String nombre, int[] array, Metricas metricas) {
        System.out.println("\n" + nombre + ":");
        System.out.println("  Arreglo ordenado: " + Arrays.toString(array));
        System.out.println("  Comparaciones: " + metricas.comparaciones());
        System.out.println("  Intercambios: " + metricas.intercambios());
    }

    /**
     * Representa las métricas contadas durante una ejecución de ordenamiento.
     *
     * @param comparaciones cantidad de comparaciones realizadas
     * @param intercambios cantidad de intercambios realizados
     */
    public record Metricas(long comparaciones, long intercambios) {

        /**
         * Construye métricas y verifica que sus valores sean válidos.
         *
         * @param comparaciones cantidad de comparaciones, no negativa
         * @param intercambios cantidad de intercambios, no negativa
         */
        public Metricas {
            if (comparaciones < 0 || intercambios < 0) {
                throw new IllegalArgumentException(
                        "Las métricas no pueden ser negativas.");
            }
        }
    }
}
