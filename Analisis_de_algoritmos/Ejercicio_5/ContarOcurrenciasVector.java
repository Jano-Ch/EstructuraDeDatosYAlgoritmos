/**
 * Cuenta cuantas veces aparece un valor dentro de un vector de enteros.
 *
 * El vector debe recorrerse completamente porque una coincidencia no permite
 * descartar que existan otras apariciones en posiciones posteriores.
 *
 * Complejidad temporal: O(n).
 * Complejidad espacial: O(1).
 */
public class ContarOcurrenciasVector {

    /**
     * Cuenta todas las apariciones de un valor en un vector.
     *
     * @param vector vector en el que se contaran las ocurrencias
     * @param valorBuscado valor que se desea contar
     * @return cantidad de posiciones cuyo valor coincide con valorBuscado
     * @throws IllegalArgumentException si el vector es null o esta vacio
     */
    public static int contarOcurrencias(int[] vector, int valorBuscado) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null.");
        }

        if (vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede estar vacio.");
        }

        int ocurrencias = 0;
        for (int elemento : vector) {
            if (elemento == valorBuscado) {
                ocurrencias++;
            }
        }

        return ocurrencias;
    }

    /**
     * Ejecuta ejemplos del conteo y de sus casos limite.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector = {8, -3, 12, 0, -3, 4, -3};

        System.out.println("Ocurrencias de -3: "
                + contarOcurrencias(vector, -3));
        System.out.println("Ocurrencias de 8: "
                + contarOcurrencias(vector, 8));
        System.out.println("Valor inexistente: "
                + contarOcurrencias(vector, 7));
        System.out.println("Todas las posiciones coinciden: "
                + contarOcurrencias(new int[]{5, 5, 5}, 5));
        System.out.println("Vector de un elemento: "
                + contarOcurrencias(new int[]{Integer.MIN_VALUE}, Integer.MIN_VALUE));

        probarValidacion(null);
        probarValidacion(new int[]{});
    }

    private static void probarValidacion(int[] vector) {
        try {
            contarOcurrencias(vector, 0);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }
    }
}