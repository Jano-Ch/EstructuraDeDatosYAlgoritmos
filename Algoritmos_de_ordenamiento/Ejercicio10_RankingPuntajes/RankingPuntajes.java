/*
 * Resolución: se ordena un arreglo de jugadores de mayor a menor puntaje.
 * DECISION: se utiliza Merge Sort porque garantiza O(n log n) en todos los casos,
 * es adecuado para ordenar un ranking y mantiene el orden original cuando dos
 * jugadores tienen el mismo puntaje (ordenamiento estable). Usa O(n) memoria
 * auxiliar.
 * Casos contemplados: arreglo vacío o con un solo jugador (ya está ordenado),
 * puntajes repetidos (se conserva su orden de llegada), puntajes negativos y
 * referencias nulas, que se informan mediante una excepción clara.
 */

/**
 * Programa que ordena y muestra un ranking de jugadores por puntaje.
 */
public class RankingPuntajes {

    /**
     * Ordena el arreglo recibido de mayor a menor puntaje.
     * En caso de empate se conserva el orden original de los jugadores.
     *
     * @param jugadores arreglo de jugadores a ordenar
     * @throws IllegalArgumentException si el arreglo o alguno de sus jugadores es nulo
     */
    public static void ordenarRanking(Jugador[] jugadores) {
        if (jugadores == null) {
            throw new IllegalArgumentException("El arreglo de jugadores no puede ser nulo.");
        }

        for (Jugador jugador : jugadores) {
            if (jugador == null) {
                throw new IllegalArgumentException("El arreglo no puede contener jugadores nulos.");
            }
        }

        if (jugadores.length < 2) {
            return;
        }

        Jugador[] auxiliar = new Jugador[jugadores.length];
        mergeSort(jugadores, auxiliar, 0, jugadores.length - 1);
    }

    /**
     * Ejecuta un ejemplo de ranking con los jugadores solicitados.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        Jugador[] jugadores = {
            new Jugador("Ana", 1200),
            new Jugador("Pedro", 900),
            new Jugador("Lucia", 1500)
        };

        ordenarRanking(jugadores);

        System.out.println("Ranking de puntajes:");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println((i + 1) + ". " + jugadores[i]);
        }
    }

    private static void mergeSort(
            Jugador[] jugadores, Jugador[] auxiliar, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int medio = inicio + (fin - inicio) / 2;
        mergeSort(jugadores, auxiliar, inicio, medio);
        mergeSort(jugadores, auxiliar, medio + 1, fin);
        mezclar(jugadores, auxiliar, inicio, medio, fin);
    }

    private static void mezclar(
            Jugador[] jugadores, Jugador[] auxiliar, int inicio, int medio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            auxiliar[i] = jugadores[i];
        }

        int izquierda = inicio;
        int derecha = medio + 1;

        // Se toma primero la mitad izquierda en empates para mantener estabilidad.
        for (int posicion = inicio; posicion <= fin; posicion++) {
            if (izquierda > medio) {
                jugadores[posicion] = auxiliar[derecha++];
            } else if (derecha > fin) {
                jugadores[posicion] = auxiliar[izquierda++];
            } else if (auxiliar[izquierda].getPuntaje() >= auxiliar[derecha].getPuntaje()) {
                jugadores[posicion] = auxiliar[izquierda++];
            } else {
                jugadores[posicion] = auxiliar[derecha++];
            }
        }
    }
}
