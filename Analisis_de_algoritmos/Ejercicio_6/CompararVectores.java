/**
 * Compara dos vectores de enteros por longitud y por posicion, sin modificar
 * sus contenidos.
 */
public class CompararVectores {

    /**
    * Determina si dos vectores tienen la misma longitud y el mismo valor en
    * cada posicion. La comparacion termina en la primera diferencia.
     *
     * @param vector1 primer vector a comparar
     * @param vector2 segundo vector a comparar
    * @return {@code true} si ambos vectores tienen la misma longitud y los
    *         mismos valores en las posiciones correspondientes; {@code false}
    *         si sus longitudes difieren o se encuentra una diferencia
     * @throws IllegalArgumentException si alguno de los vectores es {@code null}
     */
    public static boolean sonIguales(int[] vector1, int[] vector2) {
        if (vector1 == null || vector2 == null) {
            throw new IllegalArgumentException("Los vectores no pueden ser null");
        }

        if (vector1.length != vector2.length) {
            return false;
        }

        for (int posicion = 0; posicion < vector1.length; posicion++) {
            if (vector1[posicion] != vector2[posicion]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Ejecuta comprobaciones representativas del algoritmo.
     *
     * @param args argumentos de linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        comprobar(sonIguales(new int[] {1, 2, 3}, new int[] {1, 2, 3}),
                "vectores iguales");
        comprobar(!sonIguales(new int[] {9, 2, 3}, new int[] {1, 2, 3}),
                "diferencia al inicio");
        comprobar(!sonIguales(new int[] {1, 2, 9}, new int[] {1, 2, 3}),
                "diferencia al final");
        comprobar(!sonIguales(new int[] {1, 2}, new int[] {1, 2, 3}),
                "longitudes distintas");
        comprobar(sonIguales(new int[0], new int[0]), "vectores vacios");
        comprobar(sonIguales(new int[] {Integer.MIN_VALUE, -7, Integer.MAX_VALUE},
                new int[] {Integer.MIN_VALUE, -7, Integer.MAX_VALUE}),
                "negativos y extremos");
        comprobar(!sonIguales(new int[] {Integer.MIN_VALUE}, new int[] {Integer.MAX_VALUE}),
                "extremos distintos");

        comprobarLanzaIllegalArgumentException(null, new int[0], "primer vector null");
        comprobarLanzaIllegalArgumentException(new int[0], null, "segundo vector null");

        int[] vectorOriginal1 = {4, 5, 6};
        int[] vectorOriginal2 = {4, 5, 6};
        sonIguales(vectorOriginal1, vectorOriginal2);
        comprobar(vectorOriginal1[0] == 4 && vectorOriginal1[1] == 5 && vectorOriginal1[2] == 6,
                "primer vector sin modificaciones");
        comprobar(vectorOriginal2[0] == 4 && vectorOriginal2[1] == 5 && vectorOriginal2[2] == 6,
                "segundo vector sin modificaciones");

        System.out.println("Todas las comprobaciones fueron exitosas.");
    }

    private static void comprobar(boolean resultado, String caso) {
        if (!resultado) {
            throw new AssertionError("Fallo en el caso: " + caso);
        }
    }

    private static void comprobarLanzaIllegalArgumentException(int[] vector1, int[] vector2,
            String caso) {
        try {
            sonIguales(vector1, vector2);
            throw new AssertionError("No se lanzo IllegalArgumentException en el caso: " + caso);
        } catch (IllegalArgumentException esperado) {
            // La excepcion es el resultado esperado para este caso.
        }
    }
}