/*
 * Resolución: se recorre el arreglo desde la primera posición y, en cada
 * recorrido, se busca el nombre menor en la parte todavía desordenada.
 * Luego se intercambia ese nombre con el de la posición actual. Para textos
 * no se comparan valores numéricos: compareTo devuelve un valor negativo,
 * cero o positivo cuando el texto es menor, igual o mayor lexicográficamente.
 *
 * Complejidad temporal: O(n^2) en el mejor, promedio y peor caso, porque
 * Selection Sort siempre busca el mínimo en la parte restante.
 * Complejidad espacial: O(1) adicional, ya que solo usa variables auxiliares
 * para índices e intercambio.
 *
 * Casos contemplados: arreglo normal, arreglo ya ordenado, arreglo en orden
 * inverso, nombres repetidos y arreglos vacíos o de un solo elemento.
 */

import java.util.Arrays;

/**
 * Ordena nombres alfabéticamente mediante el algoritmo Selection Sort.
 */
public class Ejercicio04NombresSelectionSort {

    // DECISION: se usa compareTo para el orden lexicográfico sensible a mayúsculas
    // — Motivo: es la comparación natural de String en Java y muestra cómo
    // cambia Selection Sort al trabajar con textos en lugar de números.

    /**
     * Ordena el arreglo recibido alfabéticamente en el mismo arreglo.
     *
     * @param nombres arreglo de nombres que se ordenará
     */
    public static void ordenar(String[] nombres) {
        for (int posicion = 0; posicion < nombres.length - 1; posicion++) {
            int posicionMenor = posicion;

            for (int candidato = posicion + 1; candidato < nombres.length; candidato++) {
                // En textos, compareTo reemplaza a la comparación numérica (<).
                if (nombres[candidato].compareTo(nombres[posicionMenor]) < 0) {
                    posicionMenor = candidato;
                }
            }

            String temporal = nombres[posicion];
            nombres[posicion] = nombres[posicionMenor];
            nombres[posicionMenor] = temporal;
        }
    }

    /**
     * Ejecuta el ejemplo solicitado y muestra el arreglo antes y después.
     *
     * @param args argumentos de la línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        String[] nombres = {"Lucia", "Ana", "Pedro", "Juan"};

        System.out.println("Antes:  " + Arrays.toString(nombres));
        ordenar(nombres);
        System.out.println("Después: " + Arrays.toString(nombres));
    }
}
