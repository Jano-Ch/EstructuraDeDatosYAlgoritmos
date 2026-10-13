/*
 * Resolución:
 * Merge Sort usa la estrategia divide y vencerás. Primero DIVIDE el arreglo
 * recursivamente en dos subarreglos hasta que cada uno tiene cero o un
 * elemento. Ese es el caso base: un subarreglo de ese tamaño ya está
 * ordenado. Después FUSIONA dos subarreglos ya ordenados, comparando sus
 * primeros elementos disponibles y copiando el menor al arreglo auxiliar.
 *
 * Dividir solamente separa el problema y no ordena los elementos. Fusionar,
 * en cambio, combina dos partes que ya están ordenadas y sí construye una
 * parte ordenada más grande.
 *
 * Complejidad temporal:
 * - Mejor caso: O(n log n).
 * - Caso promedio: O(n log n).
 * - Peor caso: O(n log n).
 * Complejidad espacial: O(n) por el arreglo auxiliar usado durante la
 * fusión y O(log n) por la profundidad de la recursividad.
 *
 * Casos contemplados: arreglo normal, arreglo vacío, arreglo de un elemento,
 * valores repetidos, valores negativos y arreglos ya ordenados o invertidos.
 */

import java.util.Arrays;

/**
 * Ordena un arreglo de enteros mediante Merge Sort e informa sus etapas.
 */
public class MergeSortPasoAPaso {

    /**
     * Ejecuta una demostración con valores desordenados, repetidos y negativos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] arreglo = { 8, -2, 5, 3, 3, 1 };

        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        mergeSort(arreglo);
        System.out.println("Arreglo final ordenado: " + Arrays.toString(arreglo));
    }

    /**
     * Ordena el arreglo recibido en forma ascendente y muestra cómo se divide,
     * cuándo se alcanza el caso base y cómo se fusionan sus subarreglos.
     *
     * @param arreglo arreglo de enteros que se ordenará en el mismo arreglo
     * @throws IllegalArgumentException si {@code arreglo} es {@code null}
     */
    public static void mergeSort(int[] arreglo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        int[] auxiliar = new int[arreglo.length];
        mergeSort(arreglo, auxiliar, 0, arreglo.length - 1, 0);
    }

    /**
     * Divide recursivamente un intervalo y luego fusiona sus mitades ordenadas.
     *
     * @param arreglo arreglo que se está ordenando
     * @param auxiliar espacio temporal para una fusión
     * @param inicio primer índice inclusivo del intervalo
     * @param fin último índice inclusivo del intervalo
     * @param nivel profundidad actual de la recursividad
     */
    private static void mergeSort(
            int[] arreglo, int[] auxiliar, int inicio, int fin, int nivel) {
        String sangria = "  ".repeat(nivel);

        if (inicio >= fin) {
            System.out.println(sangria + "Condición de corte: "
                    + intervaloComoTexto(arreglo, inicio, fin)
                    + " tiene cero o un elemento.");
            return;
        }

        int medio = inicio + (fin - inicio) / 2;
        System.out.println(sangria + "Dividir "
                + intervaloComoTexto(arreglo, inicio, fin) + " en "
                + intervaloComoTexto(arreglo, inicio, medio) + " y "
                + intervaloComoTexto(arreglo, medio + 1, fin));

        mergeSort(arreglo, auxiliar, inicio, medio, nivel + 1);
        mergeSort(arreglo, auxiliar, medio + 1, fin, nivel + 1);
        fusionar(arreglo, auxiliar, inicio, medio, fin, sangria);
    }

    /**
     * Fusiona dos intervalos contiguos y ordenados en el arreglo principal.
     *
     * @param arreglo arreglo que contiene las dos mitades
     * @param auxiliar espacio temporal para combinar valores
     * @param inicio primer índice de la mitad izquierda
     * @param medio último índice de la mitad izquierda
     * @param fin último índice de la mitad derecha
     * @param sangria texto usado para conservar el nivel visual de la traza
     */
    private static void fusionar(
            int[] arreglo, int[] auxiliar, int inicio, int medio, int fin,
            String sangria) {
        System.out.println(sangria + "Fusionar "
                + intervaloComoTexto(arreglo, inicio, medio) + " y "
                + intervaloComoTexto(arreglo, medio + 1, fin));

        for (int indice = inicio; indice <= fin; indice++) {
            auxiliar[indice] = arreglo[indice];
        }

        int izquierda = inicio;
        int derecha = medio + 1;

        for (int indice = inicio; indice <= fin; indice++) {
            if (izquierda > medio) {
                arreglo[indice] = auxiliar[derecha++];
            } else if (derecha > fin) {
                arreglo[indice] = auxiliar[izquierda++];
            } else if (auxiliar[izquierda] <= auxiliar[derecha]) {
                arreglo[indice] = auxiliar[izquierda++];
            } else {
                arreglo[indice] = auxiliar[derecha++];
            }
        }

        System.out.println(sangria + "Resultado de fusionar: "
                + intervaloComoTexto(arreglo, inicio, fin));
    }

    /**
     * Representa un intervalo inclusivo del arreglo.
     *
     * @param arreglo arreglo que contiene el intervalo
     * @param inicio primer índice inclusivo
     * @param fin último índice inclusivo
     * @return valores del intervalo encerrados entre corchetes
     */
    private static String intervaloComoTexto(int[] arreglo, int inicio, int fin) {
        return Arrays.toString(Arrays.copyOfRange(arreglo, inicio, fin + 1));
    }
}
