import java.util.Arrays;

/**
 * Ejercicio 9 - Comparacion de algoritmos simples de ordenamiento.
 *
 * Resolucion: se parte del mismo arreglo de entrada y se entrega una copia
 * independiente a Bubble Sort, Selection Sort e Insertion Sort. Cada algoritmo
 * informa el arreglo resultante y sus metricas de comparaciones y movimientos.
 *
 * Complejidades temporales: Bubble Sort es O(n) en el mejor caso (si ya esta
 * ordenado) y O(n^2) en promedio y peor caso; Selection Sort es O(n^2) en los
 * tres casos; Insertion Sort es O(n) en el mejor caso y O(n^2) en promedio y
 * peor caso. Los tres usan O(1) memoria adicional, sin contar las copias
 * usadas por el programa para comparar resultados.
 *
 * Casos contemplados: arreglo vacio, arreglo de un elemento, valores
 * repetidos, arreglo ya ordenado y arreglo ordenado en sentido inverso.
 *
 * Estrategias: Bubble Sort intercambia vecinos fuera de orden y hace subir los
 * mayores hacia el final; Selection Sort busca el minimo restante y lo coloca
 * en la siguiente posicion; Insertion Sort desplaza los elementos mayores y
 * inserta cada valor en el tramo ya ordenado.
 */
public class ComparacionAlgoritmosSimples {

    /**
     * Ejecuta la demostracion con un arreglo que incluye valores repetidos.
     *
     * @param args argumentos de linea de comandos no utilizados
     */
    public static void main(String[] args) {
        int[] arregloOriginal = {64, 25, 12, 22, 11, 25, 90, 1};

        System.out.println("Arreglo original: " + Arrays.toString(arregloOriginal));
        imprimirResultado("Bubble Sort", bubbleSort(arregloOriginal));
        imprimirResultado("Selection Sort", selectionSort(arregloOriginal));
        imprimirResultado("Insertion Sort", insertionSort(arregloOriginal));
    }

    /**
     * Ordena una copia con Bubble Sort.
     *
     * Cada comparacion cuenta una evaluacion entre dos vecinos. Cada
     * intercambio cuenta solamente cuando los vecinos realmente cambian de
     * posicion. El algoritmo termina antes si no hubo intercambios.
     *
     * @param entrada arreglo que no se modifica
     * @return resultado con arreglo ordenado y metricas
     */
    public static ResultadoOrdenamiento bubbleSort(int[] entrada) {
        int[] arreglo = copiarEntrada(entrada);
        long comparaciones = 0;
        long intercambios = 0;

        for (int limite = arreglo.length - 1; limite > 0; limite--) {
            boolean huboIntercambio = false;
            for (int indice = 0; indice < limite; indice++) {
                comparaciones++;
                if (arreglo[indice] > arreglo[indice + 1]) {
                    intercambiar(arreglo, indice, indice + 1);
                    intercambios++;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break;
            }
        }
        return new ResultadoOrdenamiento(arreglo, comparaciones, intercambios);
    }

    /**
     * Ordena una copia con Selection Sort.
     *
     * Las comparaciones cuentan cada evaluacion usada para buscar el minimo.
     * Los intercambios cuentan solo cuando el minimo encontrado no esta ya en
     * la posicion que le corresponde.
     *
     * @param entrada arreglo que no se modifica
     * @return resultado con arreglo ordenado y metricas
     */
    public static ResultadoOrdenamiento selectionSort(int[] entrada) {
        int[] arreglo = copiarEntrada(entrada);
        long comparaciones = 0;
        long intercambios = 0;

        for (int inicio = 0; inicio < arreglo.length - 1; inicio++) {
            int indiceMinimo = inicio;
            for (int indice = inicio + 1; indice < arreglo.length; indice++) {
                comparaciones++;
                if (arreglo[indice] < arreglo[indiceMinimo]) {
                    indiceMinimo = indice;
                }
            }
            if (indiceMinimo != inicio) {
                intercambiar(arreglo, inicio, indiceMinimo);
                intercambios++;
            }
        }
        return new ResultadoOrdenamiento(arreglo, comparaciones, intercambios);
    }

    /**
     * Ordena una copia con Insertion Sort.
     *
     * Las comparaciones cuentan comparaciones entre la clave y un elemento
     * previo, incluyendo la ultima comparacion que detiene el desplazamiento
     * cuando la clave no es menor. Los desplazamientos cuentan asignaciones de
     * elementos hacia la derecha; la insercion final de la clave no se cuenta
     * como desplazamiento.
     *
     * @param entrada arreglo que no se modifica
     * @return resultado con arreglo ordenado y metricas
     */
    public static ResultadoOrdenamiento insertionSort(int[] entrada) {
        int[] arreglo = copiarEntrada(entrada);
        long comparaciones = 0;
        long desplazamientos = 0;

        for (int indice = 1; indice < arreglo.length; indice++) {
            int clave = arreglo[indice];
            int posicion = indice - 1;
            while (posicion >= 0) {
                comparaciones++;
                if (arreglo[posicion] <= clave) {
                    break;
                }
                arreglo[posicion + 1] = arreglo[posicion];
                desplazamientos++;
                posicion--;
            }
            // DECISION: no contar la insercion final de la clave — Motivo: la
            // metrica solicitada distingue desplazamientos de elementos de la
            // asignacion que completa la insercion.
            arreglo[posicion + 1] = clave;
        }
        return new ResultadoOrdenamiento(arreglo, comparaciones, desplazamientos);
    }

    private static int[] copiarEntrada(int[] entrada) {
        if (entrada == null) {
            throw new IllegalArgumentException("El arreglo de entrada no puede ser null.");
        }
        return Arrays.copyOf(entrada, entrada.length);
    }

    private static void intercambiar(int[] arreglo, int primero, int segundo) {
        int temporal = arreglo[primero];
        arreglo[primero] = arreglo[segundo];
        arreglo[segundo] = temporal;
    }

    private static void imprimirResultado(String nombre, ResultadoOrdenamiento resultado) {
        System.out.println("\n" + nombre + ":");
        System.out.println("  Arreglo ordenado: " + Arrays.toString(resultado.arreglo()));
        System.out.println("  Comparaciones: " + resultado.comparaciones());
        System.out.println("  Intercambios/desplazamientos: " + resultado.movimientos());
    }

    /**
     * Resultado inmutable de una ejecucion de ordenamiento.
     *
     * @param arreglo arreglo ordenado
     * @param comparaciones cantidad de comparaciones realizadas
     * @param movimientos intercambios o desplazamientos realizados
     */
    public record ResultadoOrdenamiento(
            int[] arreglo,
            long comparaciones,
            long movimientos) {

        /**
         * Construye un resultado validando sus metricas.
         *
         * @param arreglo arreglo ordenado
         * @param comparaciones cantidad de comparaciones
         * @param movimientos cantidad de movimientos
         */
        public ResultadoOrdenamiento {
            if (arreglo == null) {
                throw new IllegalArgumentException("El arreglo resultante no puede ser null.");
            }
            if (comparaciones < 0 || movimientos < 0) {
                throw new IllegalArgumentException("Las metricas no pueden ser negativas.");
            }
            arreglo = Arrays.copyOf(arreglo, arreglo.length);
        }

        /**
         * Devuelve una copia del arreglo ordenado para preservar la
         * inmutabilidad del resultado.
         *
         * @return copia del arreglo ordenado
         */
        @Override
        public int[] arreglo() {
            return Arrays.copyOf(arreglo, arreglo.length);
        }
    }
}
