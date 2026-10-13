/**
 * Cuenta recursivamente la cantidad de digitos de un entero positivo.
 *
 * Complejidad temporal: O(log10(n)).
 * Complejidad espacial: O(log10(n)) por la pila de llamadas.
 */
public class ContarDigitos {

    /**
     * Cuenta los digitos decimales de un entero positivo.
     *
     * @param numero entero positivo cuyos digitos se contaran
     * @return cantidad de digitos de numero
     * @throws IllegalArgumentException si numero es cero o negativo
     */
    public static int contarDigitos(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El numero debe ser positivo.");
        }

        if (numero < 10) {
            return 1;
        }

        return 1 + contarDigitos(numero / 10);
    }

    /**
     * Ejecuta ejemplos de conteo y valida los casos invalidos.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("7: " + contarDigitos(7));
        System.out.println("42: " + contarDigitos(42));
        System.out.println("1000: " + contarDigitos(1000));
        System.out.println("1: " + contarDigitos(1));
        System.out.println("Integer.MAX_VALUE: " + contarDigitos(Integer.MAX_VALUE));

        probarNumeroInvalido(0);
        probarNumeroInvalido(-1);
    }

    private static void probarNumeroInvalido(int numero) {
        try {
            contarDigitos(numero);
            System.out.println("Error: se acepto el numero invalido " + numero);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta para " + numero + ": "
                    + excepcion.getMessage());
        }
    }
}