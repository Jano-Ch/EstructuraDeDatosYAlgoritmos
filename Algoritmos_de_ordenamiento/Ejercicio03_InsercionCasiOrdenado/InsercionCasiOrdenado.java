/*
 * Resolución:
 * Se aplica Insertion Sort al arreglo {1, 2, 3, 5, 4, 6, 7}. El algoritmo
 * recorre el arreglo desde la segunda posición, toma el elemento actual como
 * clave y desplaza hacia la derecha los elementos mayores que esa clave.
 * Luego inserta la clave en el hueco que queda. En este ejemplo, solamente
 * es necesario desplazar el 5 para insertar el 4 antes de él.
 *
 * Complejidad temporal:
 * - Mejor caso: O(n), cuando el arreglo ya está ordenado; no hay
 *   desplazamientos y se realiza una comparación por posición.
 * - Caso promedio: O(n^2), porque una clave puede desplazarse varias
 *   posiciones hacia la izquierda.
 * - Peor caso: O(n^2), cuando el arreglo está ordenado en sentido inverso.
 * Complejidad espacial: O(1) de espacio auxiliar, porque ordena en el mismo
 * arreglo.
 *
 * Casos contemplados:
 * - Arreglo casi ordenado: se muestran los desplazamientos realizados.
 * - Arreglo ya ordenado: no se realizan desplazamientos.
 * - Arreglo invertido: cada nueva clave puede desplazarse hasta el inicio.
 * - Arreglo vacío o de un elemento: ya está ordenado.
 *
 * ¿Por qué funciona bien con datos casi ordenados? Insertion Sort conserva
 * ordenado el prefijo que ya recorrió. Si una clave está cerca de su posición
 * final, el bucle interno realiza pocos desplazamientos; por eso, para el
 * arreglo dado solo mueve un elemento y su comportamiento se acerca al mejor
 * caso O(n), en lugar de hacer intercambios innecesarios.
 */
public class InsercionCasiOrdenado {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 5, 4, 6, 7};

        System.out.println("Arreglo original: " + arregloComoTexto(numeros));
        ordenarYMostrarDesplazamientos(numeros);
        System.out.println("Arreglo ordenado: " + arregloComoTexto(numeros));
        System.out.println();
        System.out.println("El arreglo es casi ordenado porque solo el 4 y el 5"
                + " están fuera de lugar.");
        System.out.println("Insertion Sort funciona bien aquí porque desplaza"
                + " únicamente los elementos necesarios.");
    }

    /**
     * Ordena el arreglo ascendentemente mediante Insertion Sort y muestra cada
     * desplazamiento efectuado.
     *
     * @param numeros arreglo de enteros que se modificará en el lugar
     * @throws IllegalArgumentException si el arreglo es {@code null}
     */
    public static void ordenarYMostrarDesplazamientos(int[] numeros) {
        // DECISION: un arreglo null se rechaza con un mensaje explícito —
        // Motivo: evita un error ambiguo y distingue null de un arreglo vacío,
        // que sí es un caso válido y ya está ordenado.
        if (numeros == null) {
            throw new IllegalArgumentException(
                    "El arreglo no puede ser null.");
        }

        for (int posicion = 1; posicion < numeros.length; posicion++) {
            int clave = numeros[posicion];
            int indice = posicion - 1;
            int desplazamientosEnEstaInsercion = 0;

            while (indice >= 0 && numeros[indice] > clave) {
                numeros[indice + 1] = numeros[indice];
                desplazamientosEnEstaInsercion++;
                System.out.println("Desplazamiento " + desplazamientosEnEstaInsercion
                        + " de la inserción de " + clave + ": "
                        + numeros[indice] + " pasa de la posición " + indice
                        + " a la posición " + (indice + 1) + " -> "
                        + arregloComoTexto(numeros));
                indice--;
            }

            numeros[indice + 1] = clave;
            if (desplazamientosEnEstaInsercion == 0) {
                System.out.println("La clave " + clave
                        + " no necesita desplazamientos: "
                        + arregloComoTexto(numeros));
            } else {
                System.out.println("Insertada la clave " + clave + ": "
                        + arregloComoTexto(numeros));
            }
        }
    }

    /**
     * Convierte un arreglo en una representación legible.
     *
     * @param numeros arreglo que se representará
     * @return elementos separados por comas y encerrados entre corchetes
     */
    public static String arregloComoTexto(int[] numeros) {
        if (numeros == null) {
            return "null";
        }

        StringBuilder resultado = new StringBuilder("[");
        for (int posicion = 0; posicion < numeros.length; posicion++) {
            if (posicion > 0) {
                resultado.append(", ");
            }
            resultado.append(numeros[posicion]);
        }
        return resultado.append("]").toString();
    }
}
