/**
 * Busca recursivamente la primera aparicion de un numero en un vector de enteros.
 */
public class BuscarNumeroRecursivo {

    /**
    * Devuelve el indice de la primera coincidencia de un numero.
     *
    * @param vector vector de enteros en el que se realiza la busqueda
    * @param numero numero que se desea encontrar
    * @return indice de la primera coincidencia o {@code -1} si no existe
    * @throws IllegalArgumentException si {@code vector} es {@code null} o esta vacio
     */
    public static int buscar(int[] vector, int numero) {
        if (vector == null || vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede ser null ni vacio");
        }

        return buscarDesde(vector, numero, 0);
    }

    private static int buscarDesde(int[] vector, int numero, int indice) {
        if (indice == vector.length) {
            return -1;
        }

        if (vector[indice] == numero) {
            return indice;
        }

        return buscarDesde(vector, numero, indice + 1);
    }

    /**
     * Ejecuta verificaciones fijas de los casos principales y de las validaciones.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        verificar(buscar(new int[] {7, 2, 9, 4}, 7) == 0, "coincidencia inicial");
        verificar(buscar(new int[] {7, 2, 9, 4}, 4) == 3, "coincidencia final");
        verificar(buscar(new int[] {7, 2, 9, 4}, 8) == -1, "numero inexistente");
        verificar(buscar(new int[] {5, 3, 5, 5}, 5) == 0, "primera coincidencia repetida");
        verificar(buscar(new int[] {6}, 6) == 0, "arreglo unitario encontrado");
        verificar(buscar(new int[] {6}, 2) == -1, "arreglo unitario sin coincidencia");
        verificarLanzaExcepcion(null, 1, "vector null");
        verificarLanzaExcepcion(new int[] {}, 1, "vector vacio");

        System.out.println("Todas las validaciones fueron exitosas.");
    }

    private static void verificar(boolean condicion, String caso) {
        if (!condicion) {
            throw new AssertionError("Fallo en el caso: " + caso);
        }
    }

    private static void verificarLanzaExcepcion(int[] vector, int numero, String caso) {
        try {
            buscar(vector, numero);
            throw new AssertionError("Fallo en el caso: " + caso);
        } catch (IllegalArgumentException excepcion) {
            // La excepcion esperada confirma la validacion de entrada.
        }
    }
}