/**
 * Busca el mayor elemento de una matriz rectangular de enteros sin modificarla.
 */
public class MayorMatriz {

    /**
     * Encuentra el mayor elemento de una matriz rectangular no vacia.
     *
     * <p>El valor inicial se toma de la primera posicion para que el resultado
     * sea correcto incluso cuando todos los elementos son negativos. Se
     * inspeccionan todas las posiciones de la matriz.</p>
     *
     * @param matriz matriz rectangular no nula, no vacia, con filas no nulas
     *               ni vacias y con igual cantidad de columnas
     * @return el mayor elemento de la matriz
     * @throws IllegalArgumentException si la matriz es nula, vacia, contiene
     *                                  una fila nula o vacia, o no es rectangular
     */
    public static int encontrarMayor(int[][] matriz) {
        validarMatriz(matriz);

        int maximo = matriz[0][0];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] > maximo) {
                    maximo = matriz[fila][columna];
                }
            }
        }
        return maximo;
    }

    private static void validarMatriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz debe tener al menos una fila");
        }
        if (matriz[0] == null || matriz[0].length == 0) {
            throw new IllegalArgumentException("La matriz debe tener al menos una columna");
        }

        int cantidadColumnas = matriz[0].length;
        for (int fila = 0; fila < matriz.length; fila++) {
            if (matriz[fila] == null || matriz[fila].length != cantidadColumnas) {
                throw new IllegalArgumentException("La matriz debe ser rectangular y sus filas no pueden ser nulas");
            }
        }
    }

    /**
     * Ejecuta ejemplos y validaciones del algoritmo.
     *
     * @param args argumentos de linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        verificar("positivos", 9, new int[][] {{3, 1}, {9, 4}});
        verificar("negativos", -1, new int[][] {{-7, -3}, {-5, -1}});
        verificar("repetidos", 8, new int[][] {{8, 2}, {8, 8}});
        verificar("un elemento", 42, new int[][] {{42}});
        verificar("Integer.MAX_VALUE", Integer.MAX_VALUE,
                new int[][] {{Integer.MIN_VALUE, 0}, {17, Integer.MAX_VALUE}});

        verificarExcepcion("matriz nula", null);
        verificarExcepcion("matriz vacia", new int[][] {});
        verificarExcepcion("fila nula", new int[][] {null});
        verificarExcepcion("fila vacia", new int[][] {new int[] {}});
        verificarExcepcion("filas inconsistentes", new int[][] {{1, 2}, {3}});

        System.out.println("Todas las pruebas fueron exitosas.");
    }

    private static void verificar(String caso, int esperado, int[][] matriz) {
        int resultado = encontrarMayor(matriz);
        if (resultado != esperado) {
            throw new AssertionError(caso + ": se esperaba " + esperado + ", se obtuvo " + resultado);
        }
        System.out.println("OK - " + caso + ": " + resultado);
    }

    private static void verificarExcepcion(String caso, int[][] matriz) {
        try {
            encontrarMayor(matriz);
            throw new AssertionError(caso + ": se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException excepcion) {
            System.out.println("OK - " + caso + ": excepcion rechazada");
        }
    }
}