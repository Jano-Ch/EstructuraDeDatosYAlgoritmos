/**
 * Proporciona dos estrategias para detectar elementos duplicados en un vector.
 */
public class DetectarDuplicados {

    /**
     * Detecta duplicados comparando cada elemento con los que aparecen despues.
     *
     * <p>La complejidad temporal es O(n^2) y la espacial es O(1).</p>
     *
     * @param vector vector de enteros que se desea analizar
     * @return {@code true} si existe al menos un valor repetido; {@code false}
     *         en caso contrario
     * @throws IllegalArgumentException si el vector es {@code null}
     */
    public static boolean detectarConCiclosAnidados(int[] vector) {
        validarVector(vector);

        for (int indice = 0; indice < vector.length - 1; indice++) {
            for (int siguiente = indice + 1; siguiente < vector.length; siguiente++) {
                if (vector[indice] == vector[siguiente]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Detecta duplicados registrando los valores ya observados en un
     * {@link java.util.HashSet}.
     *
     * <p>La complejidad temporal promedio es O(n) y la espacial es O(n). En el
     * peor caso teorico, las operaciones de la tabla hash pueden costar mas
     * que O(1) por elemento.</p>
     *
     * @param vector vector de enteros que se desea analizar
     * @return {@code true} si existe al menos un valor repetido; {@code false}
     *         en caso contrario
     * @throws IllegalArgumentException si el vector es {@code null}
     */
    public static boolean detectarConHashSet(int[] vector) {
        validarVector(vector);

        java.util.HashSet<Integer> valoresObservados = new java.util.HashSet<>();
        for (int valor : vector) {
            if (!valoresObservados.add(valor)) {
                return true;
            }
        }

        return false;
    }

    private static void validarVector(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null.");
        }
    }

    /**
     * Ejecuta ejemplos de las dos estrategias y muestra sus resultados.
     *
     * @param args argumentos de linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[][] ejemplos = {
            {1, 2, 3, 4},
            {1, 2, 3, 2},
            {5, 5, 5},
            {},
            {7}
        };

        for (int indice = 0; indice < ejemplos.length; indice++) {
            int[] vector = ejemplos[indice];
            System.out.println("Ejemplo " + (indice + 1) + ": "
                    + "ciclos anidados="
                    + detectarConCiclosAnidados(vector) + ", HashSet="
                    + detectarConHashSet(vector));
        }

        try {
            detectarConCiclosAnidados(null);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }

        try {
            detectarConHashSet(null);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }
    }
}
