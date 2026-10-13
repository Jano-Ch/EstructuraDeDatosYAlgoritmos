/**
 * Suma todos los elementos de una matriz y cuenta los elementos procesados.
 */
public class SumarElementosMatriz {

    /**
     * Valida y suma todos los elementos de una matriz rectangular.
     * Cada elemento visitado por el recorrido incrementa una vez el contador
     * de operaciones.
     *
     * @param matriz matriz de enteros a procesar
    * @return resultado con la suma, almacenada como {@code long}, y la
    *         cantidad de elementos procesados
    * @throws IllegalArgumentException si {@code matriz} es {@code null},
    *                                  contiene una fila {@code null} o no es
    *                                  rectangular
     */
    public static ResultadoSuma sumar(int[][] matriz) {
        validarMatriz(matriz);

        long suma = 0;
        long operaciones = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                suma += matriz[fila][columna];
                operaciones++;
            }
        }

        return new ResultadoSuma(suma, operaciones);
    }

    private static void validarMatriz(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser null");
        }

        int columnasEsperadas = matriz.length == 0 ? 0 : obtenerCantidadDeColumnas(matriz[0]);
        for (int fila = 0; fila < matriz.length; fila++) {
            if (matriz[fila] == null) {
                throw new IllegalArgumentException("La fila " + fila + " no puede ser null");
            }
            if (matriz[fila].length != columnasEsperadas) {
                throw new IllegalArgumentException("La matriz debe ser rectangular");
            }
        }
    }

    private static int obtenerCantidadDeColumnas(int[] fila) {
        if (fila == null) {
            throw new IllegalArgumentException("La fila 0 no puede ser null");
        }
        return fila.length;
    }

    /**
     * Contiene la suma y el contador de elementos procesados por una matriz.
     * Ambos valores se almacenan como {@code long}.
     */
    public static class ResultadoSuma {
        private final long suma;
        private final long operaciones;

        private ResultadoSuma(long suma, long operaciones) {
            this.suma = suma;
            this.operaciones = operaciones;
        }

        /**
         * @return suma de los elementos de la matriz
         */
        public long getSuma() {
            return suma;
        }

        /**
         * @return cantidad de elementos procesados
         */
        public long getOperaciones() {
            return operaciones;
        }
    }

    /**
     * Ejecuta ejemplos normales y casos límite del algoritmo.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        verificarResultado(
                new int[][]{{1, 2, 3}, {4, 5, 6}},
                21,
                6,
                "matriz rectangular");
        verificarResultado(new int[0][0], 0, 0, "matriz sin filas");
        verificarResultado(new int[][]{{}, {}}, 0, 0, "filas sin columnas");
        verificarResultado(new int[][]{{-4, 7}, {-2, -1}}, 0, 4, "valores negativos");
        verificarResultado(
                new int[][]{{Integer.MAX_VALUE, Integer.MAX_VALUE}, {Integer.MAX_VALUE, 1}},
                (long) Integer.MAX_VALUE * 3 + 1,
                4,
                "suma grande");

        verificarLanzaIllegalArgumentException(null, "matriz null");
        verificarLanzaIllegalArgumentException(new int[][]{{1}, null}, "fila null");
        verificarLanzaIllegalArgumentException(new int[][]{{1, 2}, {3}}, "matriz irregular");

        System.out.println("Todas las verificaciones de Ejercicio_8 fueron exitosas.");
    }

    private static void verificarResultado(
            int[][] matriz,
            long sumaEsperada,
            long operacionesEsperadas,
            String caso) {
        ResultadoSuma resultado = sumar(matriz);
        if (resultado.getSuma() != sumaEsperada
                || resultado.getOperaciones() != operacionesEsperadas) {
            throw new AssertionError("Fallo en " + caso);
        }
    }

    private static void verificarLanzaIllegalArgumentException(int[][] matriz, String caso) {
        try {
            sumar(matriz);
            throw new AssertionError("No se lanzó excepción en " + caso);
        } catch (IllegalArgumentException excepcion) {
            // La excepción esperada confirma la validación del caso.
        }
    }
}
