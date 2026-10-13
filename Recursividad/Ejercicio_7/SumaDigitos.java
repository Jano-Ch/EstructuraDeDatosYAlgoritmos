/**
 * Calcula recursivamente la suma de los digitos de un numero entero no negativo.
 */
public class SumaDigitos {

    /**
     * Suma los digitos decimales de un numero.
     *
     * @param numero numero entero no negativo
     * @return suma de sus digitos
     * @throws IllegalArgumentException si el numero es negativo
     */
    public static int sumarDigitos(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El numero no puede ser negativo");
        }
        if (numero < 10) {
            return numero;
        }
        return numero % 10 + sumarDigitos(numero / 10);
    }

    /**
     * Ejecuta ejemplos fijos de la suma recursiva de digitos.
     *
     * @param args argumentos de linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] numeros = {12345, 7, 1000, 0, Integer.MAX_VALUE};

        for (int numero : numeros) {
            System.out.println(numero + " -> " + sumarDigitos(numero));
        }

        try {
            sumarDigitos(-1);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("-1 -> " + excepcion.getMessage());
        }
    }
}
