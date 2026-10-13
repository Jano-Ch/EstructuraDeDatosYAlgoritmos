import java.util.Arrays;

/*
 * Resolución:
 * Quicksort divide el arreglo alrededor de un pivote. En este ejercicio el
 * pivote es siempre el primer elemento del subarreglo; después de particionar,
 * el algoritmo se aplica recursivamente a los elementos de la izquierda y de
 * la derecha. Esto relaciona la recursividad con divide y vencerás: se divide
 * un problema en dos subproblemas más pequeños y se resuelven de la misma
 * manera, sin necesitar una etapa de combinación.
 *
 * Complejidad:
 * - Promedio: O(n log n) en tiempo.
 * - Peor caso: O(n^2) en tiempo cuando el primer elemento produce particiones
 *   muy desbalanceadas (por ejemplo, un arreglo ya ordenado).
 * - Espacio auxiliar: O(log n) promedio y O(n) en el peor caso por la
 *   profundidad de la recursividad.
 *
 * Casos contemplados: arreglo normal, arreglo vacío, arreglo de un elemento,
 * elementos repetidos y arreglos ya ordenados o ordenados en sentido inverso.
 */

/**
 * Ordena arreglos de enteros mediante Quicksort usando el primer elemento
 * de cada subarreglo como pivote.
 */
public class QuickSortPrimerPivote {

    /**
     * Ordena el arreglo recibido en forma ascendente e informa cada
     * partición realizada.
     *
     * @param arreglo arreglo de enteros que se ordenará en el mismo arreglo
     * @throws IllegalArgumentException si {@code arreglo} es {@code null}
     */
    public static void quickSort(int[] arreglo) {
        if (arreglo == null) {
            // DECISION: rechazar arreglos null con una excepción explícita — Motivo: evita un error ambiguo y mantiene definido el contrato público.
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        quickSort(arreglo, 0, arreglo.length - 1);
    }

    /**
     * Ejecuta una demostración del algoritmo con un arreglo que incluye
     * valores repetidos.
     *
     * @param args argumentos de la línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] arreglo = { 8, 3, 1, 7, 0, 10, 2, 8 };

        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        quickSort(arreglo);
        System.out.println("Arreglo final ordenado: " + Arrays.toString(arreglo));
    }

    /**
     * Ordena recursivamente el intervalo inclusivo indicado.
     *
     * @param arreglo arreglo que se está ordenando
     * @param inicio primer índice del subarreglo
     * @param fin último índice del subarreglo
     */
    private static void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int indicePivote = particionar(arreglo, inicio, fin);
        int valorPivote = arreglo[indicePivote];

        System.out.println("Pivote elegido: " + valorPivote);
        System.out.println("Subarreglo izquierdo: "
                + subarregloComoTexto(arreglo, inicio, indicePivote - 1));
        System.out.println("Subarreglo derecho: "
                + subarregloComoTexto(arreglo, indicePivote + 1, fin));

        // La recursividad resuelve cada mitad, concretando la estrategia
        // divide y vencerás hasta llegar a subarreglos de cero o un elemento.
        quickSort(arreglo, inicio, indicePivote - 1);
        quickSort(arreglo, indicePivote + 1, fin);
    }

    /**
     * Particiona el intervalo usando como pivote su primer elemento.
     *
     * @param arreglo arreglo que se está particionando
     * @param inicio primer índice del intervalo
     * @param fin último índice del intervalo
     * @return índice definitivo del pivote
     */
    private static int particionar(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[inicio];
        int elementosMenores = inicio;

        for (int indice = inicio + 1; indice <= fin; indice++) {
            if (arreglo[indice] < pivote) {
                elementosMenores++;
                intercambiar(arreglo, elementosMenores, indice);
            }
        }

        intercambiar(arreglo, inicio, elementosMenores);
        return elementosMenores;
    }

    /**
     * Intercambia dos posiciones del arreglo.
     *
     * @param arreglo arreglo cuyos valores se intercambiarán
     * @param primero primera posición
     * @param segundo segunda posición
     */
    private static void intercambiar(int[] arreglo, int primero, int segundo) {
        int temporal = arreglo[primero];
        arreglo[primero] = arreglo[segundo];
        arreglo[segundo] = temporal;
    }

    /**
     * Obtiene la representación de un intervalo inclusivo, incluso si está
     * vacío.
     *
     * @param arreglo arreglo fuente
     * @param inicio primer índice del intervalo
     * @param fin último índice del intervalo
     * @return intervalo en formato de arreglo
     */
    private static String subarregloComoTexto(int[] arreglo, int inicio, int fin) {
        if (inicio > fin) {
            return "[]";
        }

        return Arrays.toString(Arrays.copyOfRange(arreglo, inicio, fin + 1));
    }
}
