/**
 * Calcula el producto de dos enteros mediante sumas repetidas y recursividad,
 * sin utilizar el operador {@code *}.
 */
public class MultiplicacionRecursiva {

    /**
    * Multiplica dos enteros mediante sumas repetidas y recursividad. Trabaja
    * con las magnitudes de los factores, repite la suma tantas veces como
    * indica la menor magnitud y aplica el signo al resultado final.
     *
     * @param factorA primer factor
     * @param factorB segundo factor
    * @return el producto como un valor {@code long}; es negativo si
    *         exactamente uno de los factores es negativo
     */
    public static long multiplicar(int factorA, int factorB) {
        long magnitudA = factorA;
        if (magnitudA < 0L) {
            magnitudA = -magnitudA;
        }

        long magnitudB = factorB;
        if (magnitudB < 0L) {
            magnitudB = -magnitudB;
        }

        boolean resultadoNegativo = (factorA < 0) != (factorB < 0);
        long resultado;
        if (magnitudA < magnitudB) {
            resultado = sumar(magnitudB, magnitudA);
        } else {
            resultado = sumar(magnitudA, magnitudB);
        }

        return resultadoNegativo ? -resultado : resultado;
    }

    private static long sumar(long sumando, long veces) {
        if (veces == 0L) {
            return 0L;
        }
        return sumando + sumar(sumando, veces - 1L);
    }

    /**
     * Muestra casos de prueba con factores positivos, cero, signos negativos
     * y los límites de {@code int}.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("6 x 4 = " + multiplicar(6, 4));
        System.out.println("0 x 8 = " + multiplicar(0, 8));
        System.out.println("-6 x 4 = " + multiplicar(-6, 4));
        System.out.println("-6 x -4 = " + multiplicar(-6, -4));
        System.out.println("Integer.MAX_VALUE x 1 = "
                + multiplicar(Integer.MAX_VALUE, 1));
        System.out.println("Integer.MIN_VALUE x 1 = "
                + multiplicar(Integer.MIN_VALUE, 1));
        System.out.println("Integer.MIN_VALUE x -1 = "
                + multiplicar(Integer.MIN_VALUE, -1));
        System.out.println("Integer.MIN_VALUE x 0 = "
                + multiplicar(Integer.MIN_VALUE, 0));
    }
}