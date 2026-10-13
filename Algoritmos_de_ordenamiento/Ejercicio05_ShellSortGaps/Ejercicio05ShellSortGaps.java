import java.util.Arrays;

/*
 * Resolución: ShellSort ordena el arreglo mediante Insertion Sort sobre
 * subsecuencias separadas por un gap. El gap comienza en n / 2 y se reduce a
 * la mitad hasta llegar a 1; la última pasada garantiza el orden total.
 *
 * Complejidad temporal: depende de la secuencia de gaps; con la secuencia
 * n/2, n/4, ..., 1 es O(n^2) en el peor caso y suele ser mejor que
 * Insertion Sort en la práctica. Complejidad espacial: O(1) adicional.
 * Casos aplicables: arreglos pequeños o medianos, memoria limitada y datos
 * parcialmente ordenados. Es una alternativa simple cuando no se necesita
 * estabilidad ni el rendimiento garantizado de un algoritmo O(n log n).
 */
/**
 * Ejecuta y explica el algoritmo de ordenamiento ShellSort.
 *
 * <p>ShellSort mejora Insertion Sort al comparar elementos que están separados
 * por un {@code gap}. De ese modo, los valores pueden acercarse a su posición
 * final en saltos grandes antes de realizar la pasada final con gap 1.</p>
 */
public class Ejercicio05ShellSortGaps {

    /**
     * Punto de entrada del ejemplo ejecutable.
     *
     * @param args argumentos de línea de comandos; no se requieren
     */
    public static void main(String[] args) {
        int[] arreglo = {35, 12, 8, 99, 1, 45, 23, 7};

        System.out.println("Arreglo inicial: " + Arrays.toString(arreglo));
        shellSort(arreglo);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
    }

    /**
     * Ordena el arreglo en forma ascendente y muestra cada etapa del algoritmo.
     *
     * @param arreglo arreglo de enteros que se ordenará
     * @throws IllegalArgumentException si el arreglo es {@code null}
     */
    public static void shellSort(int[] arreglo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        for (int gap = arreglo.length / 2; gap > 0; gap /= 2) {
            System.out.println("Gap = " + gap);

            // Para cada posición, este Insertion Sort salta de gap en gap.
            // Los saltos reducen desplazamientos largos que serían necesarios
            // si Insertion Sort trabajara desde el principio con vecinos.
            for (int indice = gap; indice < arreglo.length; indice++) {
                int valor = arreglo[indice];
                int posicion = indice;

                while (posicion >= gap
                        && arreglo[posicion - gap] > valor) {
                    arreglo[posicion] = arreglo[posicion - gap];
                    posicion -= gap;
                }
                arreglo[posicion] = valor;
            }

            System.out.println("Arreglo después de la pasada: "
                    + Arrays.toString(arreglo));
        }
    }
}
