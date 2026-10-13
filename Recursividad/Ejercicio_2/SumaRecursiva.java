// DECISION: usar sintaxis compatible con Java 17 o superior — Motivo: el proyecto no define una version de Java y se adopta una version LTS moderna.
/**
 * Calcula recursivamente la suma de los enteros desde cero hasta un numero dado.
 *
 * Para un numero no negativo, la relacion es
 * {@code suma(n) = n + suma(n - 1)} y el caso base es {@code suma(0) = 0}.
 * La recursion reduce el problema en una unidad en cada llamada.
 *
 * Complejidad temporal: O(n).
 * Complejidad espacial: O(n) por la pila de llamadas recursivas.
 *
 * La clase incluye un {@code main} con ejemplos de uso y una prueba de la
 * validacion de valores negativos.
 */
public class SumaRecursiva {

    /**
    * Suma todos los enteros desde cero hasta {@code n}, inclusive.
    *
    * <p>Si {@code n} vale cero, devuelve cero sin realizar otra llamada.
    * Para un valor positivo, aplica {@code n + sumarHastaUno(n - 1)}.</p>
     *
     * @param n limite superior no negativo de la suma
     * @return la suma de los enteros desde cero hasta {@code n}
     * @throws IllegalArgumentException si {@code n} es negativo
     */
    public static long sumarHastaUno(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El numero no puede ser negativo.");
        }

        if (n == 0) {
            return 0;
        }

        return n + sumarHastaUno(n - 1);
    }

    /**
     * Ejecuta ejemplos normales y el caso invalido contemplado.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Suma hasta 5: " + sumarHastaUno(5));
        System.out.println("Suma hasta 1: " + sumarHastaUno(1));
        System.out.println("Suma hasta 0: " + sumarHastaUno(0));
        System.out.println("Suma hasta 10: " + sumarHastaUno(10));

        try {
            sumarHastaUno(-1);
        } catch (IllegalArgumentException excepcion) {
            System.out.println("Validacion correcta: " + excepcion.getMessage());
        }
    }
}
