/**
 * Encuentra el valor minimo de un vector de numeros enteros.
 *
 * La estrategia elegida es un recorrido iterativo: se visita cada elemento
 * una sola vez y se conserva el menor valor encontrado hasta el momento.
 * Esta estrategia es preferible a ordenar el vector porque solo necesitamos
 * conocer un elemento y no el orden completo de todos los datos.
 *
 * Complejidad temporal: O(n), donde n es la cantidad de elementos del vector.
 * Complejidad espacial: O(1), porque utiliza una cantidad constante de
 * memoria adicional y no modifica el vector recibido.
 */
public class MinimoVector {

    /**
     * Devuelve el menor valor contenido en un vector de enteros.
     *
     * @param vector vector cuyos elementos se desean analizar
     * @return el menor valor del vector
     * @throws IllegalArgumentException si el vector es null o esta vacio
     */
    public static int encontrarMinimo(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null.");
        }

        if (vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede estar vacio.");
        }

        // Se toma el primer elemento para que la solucion funcione tambien
        // cuando todos los valores son positivos, negativos o Integer.MIN_VALUE.
        int minimo = vector[0];

        for (int indice = 1; indice < vector.length; indice++) {
            if (vector[indice] < minimo) {
                minimo = vector[indice];
            }
        }

        return minimo;
    }

    /**
     * Ejecuta ejemplos de uso del algoritmo y de sus casos limite.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector = {8, -3, 12, 0, -9, 4};
        System.out.println("Minimo: " + encontrarMinimo(vector));

        System.out.println("Minimo de un elemento: "
                + encontrarMinimo(new int[]{Integer.MIN_VALUE}));
        System.out.println("Minimo de valores repetidos: "
                + encontrarMinimo(new int[]{5, 5, 5}));

        probarValidacion(null);
        probarValidacion(new int[]{});
    }

    private static void probarValidacion(int[] vector) {
        try {
            encontrarMinimo(vector);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }
    }
}
