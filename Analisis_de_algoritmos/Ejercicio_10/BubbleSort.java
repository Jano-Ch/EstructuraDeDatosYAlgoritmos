import java.util.Arrays;

/**
 * Implementacion didactica de Bubble Sort con metricas de ejecucion.
 * El algoritmo ordena ascendentemente el vector recibido y lo modifica
 * directamente, sin crear otro vector.
 */
public class BubbleSort {

    /**
     * Ordena un vector de enteros en forma ascendente y modifica el vector original.
     *
     * @param vector vector que se ordenara in-place
     * @return objeto con la cantidad de comparaciones e intercambios realizados
     * @throws IllegalArgumentException si el vector es null o no tiene elementos
     */
    public static ResultadoOrdenamiento ordenar(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null");
        }
        if (vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede estar vacio");
        }

        long comparaciones = 0;
        long intercambios = 0;
        boolean huboIntercambio;

        for (int limite = vector.length - 1; limite > 0; limite--) {
            huboIntercambio = false;
            for (int indice = 0; indice < limite; indice++) {
                comparaciones++;
                if (vector[indice] > vector[indice + 1]) {
                    int temporal = vector[indice];
                    vector[indice] = vector[indice + 1];
                    vector[indice + 1] = temporal;
                    intercambios++;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break;
            }
        }

        return new ResultadoOrdenamiento(comparaciones, intercambios);
    }

    /**
     * Ejecuta ejemplos normales y casos limite del algoritmo.
     *
     * @param args argumentos de linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        ejecutarCaso("Desordenado", new int[] {5, 1, 4, 2, 8});
        ejecutarCaso("Inverso", new int[] {5, 4, 3, 2, 1});
        ejecutarCaso("Ordenado", new int[] {1, 2, 3, 4, 5});
        ejecutarCaso("Repetidos", new int[] {3, 1, 3, 2, 1});
        ejecutarCaso("Negativos y extremos", new int[] {Integer.MAX_VALUE, -1, 0, Integer.MIN_VALUE});
        ejecutarCaso("Un elemento", new int[] {42});

        ejecutarCasoInvalido("Null", null);
        ejecutarCasoInvalido("Vacio", new int[0]);
    }

    private static void ejecutarCaso(String nombre, int[] vector) {
        System.out.println(nombre + ": entrada=" + Arrays.toString(vector));
        ResultadoOrdenamiento resultado = ordenar(vector);
        System.out.println("  salida=" + Arrays.toString(vector) + ", " + resultado);
    }

    private static void ejecutarCasoInvalido(String nombre, int[] vector) {
        try {
            ordenar(vector);
            System.out.println(nombre + ": ERROR, se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException excepcion) {
            System.out.println(nombre + ": IllegalArgumentException controlada - " + excepcion.getMessage());
        }
    }

    /**
     * Resultado de las metricas obtenidas durante un ordenamiento.
     * Contiene la cantidad de comparaciones entre elementos y de intercambios
     * reales realizados por {@link BubbleSort#ordenar(int[])}.
     */
    public static class ResultadoOrdenamiento {
        // DECISION: usar contadores long — Motivo: evita desbordamientos en vectores grandes sin cambiar la API solicitada.
        private final long comparaciones;
        private final long intercambios;

        private ResultadoOrdenamiento(long comparaciones, long intercambios) {
            this.comparaciones = comparaciones;
            this.intercambios = intercambios;
        }

        /**
         * @return cantidad de comparaciones entre elementos
         */
        public long getComparaciones() {
            return comparaciones;
        }

        /**
         * @return cantidad de intercambios reales
         */
        public long getIntercambios() {
            return intercambios;
        }

        /**
         * Devuelve las metricas en un formato legible.
         *
         * @return texto con las cantidades de comparaciones e intercambios
         */
        @Override
        public String toString() {
            return "comparaciones=" + comparaciones + ", intercambios=" + intercambios;
        }
    }
}