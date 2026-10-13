/**
 * Determina si una cadena es un palindromo mediante recursion.
 */
public class Palindromo {

    /**
     * Indica si la cadena se lee igual de izquierda a derecha y de derecha a izquierda.
     * La comparacion es literal y no realiza normalizaciones.
     *
     * @param palabra cadena que se desea verificar
     * @return {@code true} si la cadena es un palindromo
     * @throws IllegalArgumentException si {@code palabra} es {@code null}
     */
    public static boolean esPalindromo(String palabra) {
        if (palabra == null) {
            throw new IllegalArgumentException("La palabra no puede ser null");
        }

        return esPalindromo(palabra, 0, palabra.length() - 1);
    }

    private static boolean esPalindromo(String palabra, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }

        if (palabra.charAt(inicio) != palabra.charAt(fin)) {
            return false;
        }

        return esPalindromo(palabra, inicio + 1, fin - 1);
    }

    /**
     * Ejecuta ejemplos fijos de uso del algoritmo.
     *
     * @param args argumentos de linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        mostrarResultado("reconocer");
        mostrarResultado("algoritmo");
        mostrarResultado("a");
        mostrarResultado("");

        try {
            System.out.println("null -> " + esPalindromo(null));
        } catch (IllegalArgumentException exception) {
            System.out.println("null -> IllegalArgumentException: " + exception.getMessage());
        }
    }

    private static void mostrarResultado(String palabra) {
        System.out.println("\"" + palabra + "\" -> " + esPalindromo(palabra));
    }
}
