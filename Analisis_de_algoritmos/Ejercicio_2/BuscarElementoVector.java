/**
 * Busca un elemento dentro de un vector desordenado.
 *
 * La estrategia elegida es una busqueda lineal iterativa: se recorren las
 * posiciones desde el principio y se finaliza al encontrar la primera
 * coincidencia. Esta estrategia es adecuada porque el vector no esta
 * ordenado y permite contar directamente las posiciones examinadas.
 *
 * Complejidad temporal: O(1) en el mejor caso y O(n) en el peor y promedio.
 * Complejidad espacial: O(1), sin contar el objeto resultado devuelto.
 */
public class BuscarElementoVector {

    /**
     * Busca la primera aparicion de un elemento en un vector desordenado.
     *
     * @param vector vector en el que se realizara la busqueda
     * @param elemento valor que se desea encontrar
     * @return resultado con el estado, indice y posiciones recorridas
     * @throws IllegalArgumentException si el vector es null o esta vacio
     */
    public static ResultadoBusqueda buscar(int[] vector, int elemento) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null.");
        }

        if (vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede estar vacio.");
        }

        for (int indice = 0; indice < vector.length; indice++) {
            int posicionesRecorridas = indice + 1;
            if (vector[indice] == elemento) {
                return new ResultadoBusqueda(true, indice, posicionesRecorridas);
            }
        }

        return new ResultadoBusqueda(false, -1, vector.length);
    }

    /**
     * Contiene el resultado de una busqueda y la cantidad de posiciones
     * examinadas para obtenerlo.
     */
    public static final class ResultadoBusqueda {
        private final boolean encontrado;
        private final int indice;
        private final int posicionesRecorridas;

        private ResultadoBusqueda(boolean encontrado, int indice,
                int posicionesRecorridas) {
            this.encontrado = encontrado;
            this.indice = indice;
            this.posicionesRecorridas = posicionesRecorridas;
        }

        /**
         * Indica si el elemento fue encontrado.
         *
         * @return true si se encontro; false en caso contrario
         */
        public boolean fueEncontrado() {
            return encontrado;
        }

        /**
         * Devuelve el indice de la primera coincidencia.
         *
         * @return indice encontrado o -1 si el elemento no existe
         */
        public int getIndice() {
            return indice;
        }

        /**
         * Devuelve la cantidad de posiciones examinadas.
         *
         * @return cantidad de posiciones recorridas
         */
        public int getPosicionesRecorridas() {
            return posicionesRecorridas;
        }

        @Override
        public String toString() {
            if (encontrado) {
                return "Elemento encontrado en el indice " + indice
                        + ". Posiciones recorridas: " + posicionesRecorridas;
            }
            return "Elemento no encontrado. Posiciones recorridas: "
                    + posicionesRecorridas;
        }
    }

    /**
     * Ejecuta ejemplos de busqueda y de sus casos limite.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector = {8, -3, 12, 0, -9, 4};

        System.out.println("Busqueda al inicio: " + buscar(vector, 8));
        System.out.println("Busqueda al final: " + buscar(vector, 4));
        System.out.println("Busqueda inexistente: " + buscar(vector, 7));
        System.out.println("Primera coincidencia: "
                + buscar(new int[]{5, 2, 5, 9}, 5));
        System.out.println("Busqueda en un elemento: "
                + buscar(new int[]{Integer.MIN_VALUE}, Integer.MIN_VALUE));

        probarValidacion(null);
        probarValidacion(new int[]{});
    }

    private static void probarValidacion(int[] vector) {
        try {
            buscar(vector, 0);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }
    }
}