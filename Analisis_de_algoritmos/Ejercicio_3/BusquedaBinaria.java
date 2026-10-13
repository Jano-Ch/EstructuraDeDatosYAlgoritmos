// DECISION: usar sintaxis compatible con Java 17 o superior — Motivo: el proyecto no define una version de Java y se adopta una version LTS moderna.
/**
 * Busca la primera aparicion de un elemento en un vector ordenado.
 *
 * La busqueda binaria descarta aproximadamente la mitad del intervalo en cada
 * iteracion, por lo que la busqueda tiene complejidad O(log n). La validacion
 * del orden del vector requiere O(n) antes de iniciar la busqueda.
 */
public class BusquedaBinaria {

    /**
     * Busca la primera aparicion de un elemento en un vector ordenado
     * ascendentemente y muestra la traza de cada iteracion.
     *
     * @param vector vector ordenado ascendentemente donde se buscara
     * @param elemento valor que se desea encontrar
     * @return indice de la primera aparicion o -1 si no existe
     * @throws IllegalArgumentException si el vector es null, vacio o no esta
     *         ordenado ascendentemente
     */
    public static int buscar(int[] vector, int elemento) {
        validarVector(vector);

        int inicio = 0;
        int fin = vector.length - 1;
        int indiceEncontrado = -1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int valorMedio = vector[medio];

            System.out.println("Traza: inicio=" + inicio + ", fin=" + fin
                    + ", medio=" + medio + ", valorMedio=" + valorMedio);

            if (valorMedio == elemento) {
                indiceEncontrado = medio;
                System.out.println("Decision: encontrado; continuar hacia la izquierda"
                        + " para hallar la primera aparicion.");
                fin = medio - 1;
            } else if (valorMedio < elemento) {
                System.out.println("Decision: buscar a la derecha.");
                inicio = medio + 1;
            } else {
                System.out.println("Decision: buscar a la izquierda.");
                fin = medio - 1;
            }
        }

        return indiceEncontrado;
    }

    private static void validarVector(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null.");
        }

        if (vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede estar vacio.");
        }

        for (int indice = 1; indice < vector.length; indice++) {
            if (vector[indice - 1] > vector[indice]) {
                // DECISION: exigir orden ascendente — Motivo: la busqueda binaria solo puede descartar mitades si el vector esta ordenado.
                throw new IllegalArgumentException(
                        "El vector debe estar ordenado ascendentemente.");
            }
        }
    }

    /**
     * Ejecuta ejemplos de busqueda y de los casos borde contemplados.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector = {1, 3, 5, 7, 9, 11, 13};

        System.out.println("Busqueda al inicio: " + buscar(vector, 1));
        System.out.println("Busqueda en el medio: " + buscar(vector, 7));
        System.out.println("Busqueda al final: " + buscar(vector, 13));
        System.out.println("Busqueda inexistente: " + buscar(vector, 8));
        System.out.println("Primera coincidencia: "
                + buscar(new int[]{2, 4, 4, 4, 8}, 4));
        System.out.println("Busqueda en un elemento: "
                + buscar(new int[]{Integer.MIN_VALUE}, Integer.MIN_VALUE));

        probarValidacion(null, 0);
        probarValidacion(new int[]{}, 0);
        probarValidacion(new int[]{3, 1, 2}, 1);
    }

    private static void probarValidacion(int[] vector, int elemento) {
        try {
            buscar(vector, elemento);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }
    }
}
