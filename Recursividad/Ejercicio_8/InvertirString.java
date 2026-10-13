/**
 * Invierte cadenas mediante intercambio recursivo de sus extremos.
 */
public class InvertirString {

    /**
     * Devuelve el texto con sus caracteres en orden inverso.
     *
     * @param texto texto que se desea invertir
     * @return texto invertido
     * @throws IllegalArgumentException si texto es null
     */
    public static String invertir(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("El texto no puede ser null");
        }

        char[] caracteres = texto.toCharArray();
        invertir(caracteres, 0, caracteres.length - 1);
        return new String(caracteres);
    }

    private static void invertir(char[] caracteres, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        char temporal = caracteres[inicio];
        caracteres[inicio] = caracteres[fin];
        caracteres[fin] = temporal;
        invertir(caracteres, inicio + 1, fin - 1);
    }

    /**
     * Ejecuta ejemplos fijos de inversión de cadenas.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("normal: " + invertir("algoritmos"));
        System.out.println("otra normal: " + invertir("recursividad"));
        System.out.println("vacía: [" + invertir("") + "]");
        System.out.println("un carácter: " + invertir("A"));
        System.out.println("espacios: [" + invertir("  hola mundo  ") + "]");
        System.out.println("palíndromo: " + invertir("reconocer"));
    }
}
