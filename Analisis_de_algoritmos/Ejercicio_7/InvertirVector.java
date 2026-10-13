import java.util.Arrays;

/**
 * Ofrece dos estrategias para invertir un vector de enteros.
 *
 * La estrategia auxiliar construye un vector nuevo, mientras que la estrategia
 * in-place intercambia elementos dentro del vector recibido.
 */
public class InvertirVector {

    /**
     * Devuelve una copia del vector con sus elementos en orden inverso.
     *
     * El vector recibido no se modifica. La copia requiere espacio adicional
     * O(n) y el recorrido tiene complejidad temporal O(n).
     *
     * @param vector vector que se desea invertir
     * @return un vector nuevo con los elementos en orden inverso
     * @throws IllegalArgumentException si vector es null
     */
    public static int[] invertirConVectorAuxiliar(int[] vector) {
        validarVector(vector);

        int[] vectorInvertido = new int[vector.length];
        for (int indice = 0; indice < vector.length; indice++) {
            vectorInvertido[indice] = vector[vector.length - 1 - indice];
        }

        return vectorInvertido;
    }

    /**
     * Invierte el vector recibido modificandolo en el mismo lugar.
     *
     * Utiliza dos indices y una variable temporal, por lo que requiere
     * espacio adicional O(1). El tiempo de ejecucion es O(n).
     *
     * @param vector vector que se desea invertir
     * @throws IllegalArgumentException si vector es null
     */
    public static void invertirEnElMismoVector(int[] vector) {
        validarVector(vector);

        int indiceInicio = 0;
        int indiceFin = vector.length - 1;
        while (indiceInicio < indiceFin) {
            int temporal = vector[indiceInicio];
            vector[indiceInicio] = vector[indiceFin];
            vector[indiceFin] = temporal;
            indiceInicio++;
            indiceFin--;
        }
    }

    /**
     * Ejecuta casos normales y casos limite de las dos estrategias.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        probarCaso("normal", new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
        probarCaso("vacio", new int[]{}, new int[]{});
        probarCaso("un elemento", new int[]{7}, new int[]{7});
        probarCaso("cantidad par", new int[]{10, 20, 30, 40},
                new int[]{40, 30, 20, 10});
        probarCaso("cantidad impar", new int[]{5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5});
        probarCaso("repetidos", new int[]{3, 3, -1, 3},
                new int[]{3, -1, 3, 3});
        probarCaso("negativos", new int[]{-8, -2, 0, 4},
                new int[]{4, 0, -2, -8});

        probarNull();
        System.out.println("Todos los casos fueron verificados correctamente.");
    }

    private static void probarCaso(String nombre, int[] vector,
            int[] esperado) {
        int[] original = vector.clone();
        int[] resultadoAuxiliar = invertirConVectorAuxiliar(vector);
        verificar(Arrays.equals(resultadoAuxiliar, esperado),
                "Resultado auxiliar incorrecto en caso " + nombre);
        verificar(Arrays.equals(vector, original),
                "La version auxiliar modifico el original en caso " + nombre);
        verificar(resultadoAuxiliar != vector,
                "La version auxiliar no creo un vector nuevo en caso " + nombre);

        int[] vectorInPlace = vector.clone();
        invertirEnElMismoVector(vectorInPlace);
        verificar(Arrays.equals(vectorInPlace, esperado),
                "Resultado in-place incorrecto en caso " + nombre);
        System.out.println("Caso verificado: " + nombre);
    }

    private static void probarNull() {
        try {
            invertirConVectorAuxiliar(null);
            throw new AssertionError("La version auxiliar acepto null.");
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion auxiliar correcta: "
                    + excepcion.getMessage());
        }

        try {
            invertirEnElMismoVector(null);
            throw new AssertionError("La version in-place acepto null.");
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion in-place correcta: "
                    + excepcion.getMessage());
        }
    }

    private static void validarVector(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null.");
        }
    }

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}