/*
 * Resolución: se implementa Quicksort eligiendo siempre el primer elemento
 * como pivote y se ordena {1, 2, 3, 4, 5, 6, 7}. La métrica es la cantidad
 * de invocaciones al método recursivo quickSort, incluyendo la invocación
 * inicial y las invocaciones para subarreglos vacíos. Para esta entrada se
 * obtienen 13 invocaciones (12 llamadas realizadas recursivamente).
 * DECISION: Se cuentan también la invocación inicial y las bases vacías —
 * Motivo: así la métrica representa todo el árbol de llamadas y hace visible
 * el costo adicional de las particiones degeneradas.
 *
 * Complejidades:
 * - Mejor caso: O(n log n) de tiempo, cuando el pivote divide equilibradamente.
 * - Caso promedio: O(n log n) de tiempo.
 * - Peor caso: O(n^2) de tiempo y O(n) de pila, cuando el pivote siempre es
 *   el menor o el mayor elemento.
 *
 * Casos contemplados:
 * - Arreglo ordenado ascendentemente: provoca el peor caso con este pivote.
 * - Arreglo vacío o de un elemento: no requiere partición y termina.
 * - Arreglo con varios elementos: se particiona y se ordenan ambos lados.
 */

/**
 * Demuestra el peor caso de Quicksort al usar el primer elemento como pivote.
 */
public class PeorCasoQuickSort {

    /**
     * Ordena el arreglo con Quicksort y muestra la métrica de llamadas.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] valores = {1, 2, 3, 4, 5, 6, 7};
        int llamadas = quickSort(valores);

        System.out.println("Arreglo ordenado: " + formato(valores));
        System.out.println("Invocaciones de quickSort: " + llamadas);
        System.out.println("Llamadas recursivas posteriores a la inicial: "
                + (llamadas - 1));
        System.out.println("El primer pivote produce mal rendimiento porque, "
                + "al estar ordenado el arreglo, cada pivote es el menor "
                + "elemento y deja una partición vacía y otra de tamaño n-1.");
    }

    /**
     * Ordena todos los elementos de un arreglo.
     *
     * @param arreglo arreglo que se ordenará en el mismo lugar
     * @return cantidad de invocaciones a la operación recursiva
     */
    public static int quickSort(int[] arreglo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        Contador contador = new Contador();
        quickSort(arreglo, 0, arreglo.length - 1, contador);
        return contador.llamadas;
    }

    private static void quickSort(int[] arreglo, int inicio, int fin,
            Contador contador) {
        contador.llamadas++;
        if (inicio >= fin) {
            return;
        }

        int posicionPivote = particionar(arreglo, inicio, fin);
        quickSort(arreglo, inicio, posicionPivote - 1, contador);
        quickSort(arreglo, posicionPivote + 1, fin, contador);
    }

    /*
     * Se elige el primer elemento como pivote. En un arreglo ya ordenado,
     * todos los elementos restantes son mayores, por lo que el pivote queda
     * siempre al comienzo y la recursión se reduce de uno en uno.
     */
    private static int particionar(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[inicio];
        int posicion = inicio;

        for (int indice = inicio + 1; indice <= fin; indice++) {
            if (arreglo[indice] < pivote) {
                posicion++;
                intercambiar(arreglo, posicion, indice);
            }
        }

        intercambiar(arreglo, inicio, posicion);
        return posicion;
    }

    private static void intercambiar(int[] arreglo, int primero, int segundo) {
        int temporal = arreglo[primero];
        arreglo[primero] = arreglo[segundo];
        arreglo[segundo] = temporal;
    }

    private static String formato(int[] arreglo) {
        StringBuilder resultado = new StringBuilder("[");
        for (int indice = 0; indice < arreglo.length; indice++) {
            if (indice > 0) {
                resultado.append(", ");
            }
            resultado.append(arreglo[indice]);
        }
        return resultado.append(']').toString();
    }

    private static final class Contador {
        private int llamadas;
    }
}
