/**
 * Verificación ejecutable del ejercicio 6, sin dependencias externas.
 */
public final class PruebaEjercicio6 {

    private PruebaEjercicio6() {
    }

    /**
     * Ejecuta los casos normal y límite definidos para la eliminación.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        ListaEnlazadaSimple<String> lista = new ListaEnlazadaSimple<>();
        lista.agregarAlFinal("A");
        lista.agregarAlFinal("B");
        lista.agregarAlFinal("C");

        lista.eliminarEnPosicion(0);
        comprobar(lista.size() == 2 && "B".equals(lista.obtener(0)),
                "eliminación de la cabeza");

        lista.eliminarEnPosicion(1);
        comprobar(lista.size() == 1 && "B".equals(lista.obtener(0)),
                "eliminación de un nodo intermedio/final");

        lista.eliminarEnPosicion(0);
        comprobar(lista.size() == 0, "eliminación del único elemento");

        comprobarInvalida(lista, -1);
        comprobarInvalida(lista, 0);

        lista.agregarAlFinal("D");
        comprobarInvalida(lista, 1);
        comprobar(lista.size() == 1 && "D".equals(lista.obtener(0)),
                "posición inválida no modifica la lista");

        System.out.println("PruebaEjercicio6: todos los casos aprobados.");
    }

    private static void comprobarInvalida(
            ListaEnlazadaSimple<String> lista, int posicion) {
        try {
            lista.eliminarEnPosicion(posicion);
            throw new AssertionError(
                    "Se esperaba IndexOutOfBoundsException para " + posicion);
        } catch (IndexOutOfBoundsException esperado) {
            // Caso esperado: la lista debe permanecer sin cambios.
        }
    }

    private static void comprobar(boolean condicion, String caso) {
        if (!condicion) {
            throw new AssertionError("Falló: " + caso);
        }
    }
}
