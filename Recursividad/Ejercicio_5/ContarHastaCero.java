/**
 * Imprime una cuenta regresiva desde un numero entero hasta cero mediante
 * recursividad. La operacion produce salida por consola y no calcula un valor
 * para devolverlo.
 */
public class ContarHastaCero {

    /**
     * Imprime el valor recibido y continua contando hasta llegar a cero.
     * El caso base es {@code n == 0}; para valores positivos, la reduccion del
     * problema se realiza llamando al metodo con {@code n - 1}.
     *
     * @param n valor inicial de la cuenta regresiva
     * @throws IllegalArgumentException si n es negativo
     */
    public static void contarHastaCero(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El numero no puede ser negativo.");
        }

        System.out.println(n);

        if (n > 0) {
            contarHastaCero(n - 1);
        }
    }

    /**
     * Ejecuta ejemplos de cuenta regresiva y valida un valor negativo.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        contarHastaCero(5);
        contarHastaCero(0);

        try {
            contarHastaCero(-1);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }
    }
}