/**
 * Calcula potencias enteras mediante multiplicaciones sucesivas recursivas.
 */
public class PotenciaRecursiva {

    /**
     * Calcula una potencia mediante multiplicaciones sucesivas recursivas.
     *
     * @param base base de la potencia
     * @param exponente exponente no negativo
     * @return el resultado de elevar la base al exponente
     * @throws IllegalArgumentException si el exponente es negativo
     * @throws ArithmeticException si el resultado no puede representarse como long
     */
    public static long calcularPotencia(long base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente debe ser mayor o igual que cero");
        }

        if (exponente == 0) {
            return 1;
        }

        return Math.multiplyExact(base, calcularPotencia(base, exponente - 1));
    }

    /**
     * Ejecuta los casos de prueba incluidos para mostrar resultados validos,
     * casos borde y excepciones esperadas.
     *
     * @param args argumentos de la linea de comandos; no se utilizan
     */
    public static void main(String[] args) {
        mostrarResultado(2, 0);
        mostrarResultado(2, 5);
        mostrarResultado(-2, 3);
        mostrarResultado(-2, 4);
        mostrarResultado(0, 5);
        mostrarResultado(0, 0);
        mostrarResultado(Long.MAX_VALUE, 2);
        mostrarResultado(2, -1);
    }

    private static void mostrarResultado(long base, int exponente) {
        try {
            System.out.println(base + "^" + exponente + " = " + calcularPotencia(base, exponente));
        } catch (IllegalArgumentException | ArithmeticException exception) {
            System.out.println(base + "^" + exponente + " -> " + exception.getClass().getSimpleName()
                    + ": " + exception.getMessage());
        }
    }
}