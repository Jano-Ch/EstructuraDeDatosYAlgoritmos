/**
 * Calcula factoriales mediante una definicion recursiva.
 *
 * El factorial de 0 y de 1 es 1. Para los demas valores validos, el problema
 * se reduce calculando el factorial del numero anterior.
 */
public class FactorialRecursivo {

    /**
     * Calcula el factorial de un numero entero no negativo.
     *
     * @param numero numero cuyo factorial se desea calcular
     * @return el factorial de {@code numero}
     * @throws IllegalArgumentException si {@code numero} no esta entre 0 y 20
     */
    public static long calcularFactorial(int numero) {
        if (numero < 0 || numero > 20) {
            // DECISION: usar un mensaje unico para ambos limites invalidos — Motivo: mantiene explicita y consistente la regla de rango del ejercicio.
            throw new IllegalArgumentException(
                    "El numero debe estar entre 0 y 20.");
        }

        if (numero == 0 || numero == 1) {
            return 1;
        }

        return numero * calcularFactorial(numero - 1);
    }

    /**
     * Ejecuta ejemplos normales y casos fuera del rango permitido.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("0! = " + calcularFactorial(0));
        System.out.println("1! = " + calcularFactorial(1));
        System.out.println("5! = " + calcularFactorial(5));
        System.out.println("10! = " + calcularFactorial(10));
        System.out.println("20! = " + calcularFactorial(20));

        probarValidacion(-1);
        probarValidacion(21);
    }

    private static void probarValidacion(int numero) {
        try {
            calcularFactorial(numero);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta para " + numero + ": "
                    + excepcion.getMessage());
        }
    }
}